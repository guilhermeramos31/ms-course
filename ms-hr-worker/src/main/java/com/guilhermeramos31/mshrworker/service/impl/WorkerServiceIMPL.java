package com.guilhermeramos31.mshrworker.service.impl;

import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestDto;
import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestUpdateDTO;
import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import com.guilhermeramos31.mshrworker.repository.WorkerRepository;
import com.guilhermeramos31.mshrworker.service.WorkerService;
import com.guilhermeramos31.mshrworker.service.assembler.WorkerConverter;
import com.guilhermeramos31.mshrworker.service.assembler.WorkerVerify;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceIMPL implements WorkerService {
    private final WorkerRepository repository;
    private final WorkerConverter mapper;

    @Override
    public List<WorkerResponseDto> getAll() {
        var workerListFound = repository.findAll();
        if (workerListFound.isEmpty()) throw new EntityNotFoundException("No workers found!");
        return mapper.listWorkToListWorkerResponseDto(workerListFound);
    }

    @Override
    public WorkerResponseDto getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Field id not be null!");
        }
        try {
            var workerFound = repository.findById(id).orElseThrow();

            return mapper.workerToWorkerResponseDto(workerFound);
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException("Entity not found!");
        }
    }

    @Override
    public WorkerResponseDto create(WorkerRequestDto requestDto) {
        if (requestDto == null) {
            throw new IllegalArgumentException("requestDto not be null!");
        }

        try {
            WorkerVerify.verify(requestDto);
            var requestSaved = repository.save(mapper.work(requestDto));

            return mapper.workerToWorkerResponseDto(requestSaved);
        } catch (IllegalAccessException exception){
            return null;
        }
    }

    @Override
    public WorkerResponseDto update(WorkerRequestUpdateDTO requestUpdateDTO, Long id) throws IllegalAccessException {
        WorkerVerify.verify(requestUpdateDTO);
        var workerFound = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        workerFound.setId(workerFound.getId());
        workerFound.setName(requestUpdateDTO.getName());
        workerFound.setDailyIncome(requestUpdateDTO.getDailyIncome());

        var workerSaved = repository.save(workerFound);

        return mapper.workerToWorkerResponseDto(workerSaved);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id field not be null");
        }

        try {
            repository.findById(id).orElseThrow(EntityNotFoundException::new);
            repository.deleteById(id);

        } catch (EntityNotFoundException exception){
            throw new EntityNotFoundException("Entity not found!");
        }
    }
}
