package com.guilhermeramos31.mshrworker.service.impl;

import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import com.guilhermeramos31.mshrworker.repository.WorkerRepository;
import com.guilhermeramos31.mshrworker.service.WorkerService;
import com.guilhermeramos31.mshrworker.service.assembler.WorkerConverter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceIMPL implements WorkerService {
    private final WorkerRepository repository;
    private final WorkerConverter mapper;

    @Override
    public ResponseEntity<List<WorkerResponseDto>> findAll() {
        var workerListFound = repository.findAll();
        if (workerListFound.isEmpty()) throw new EntityNotFoundException("No workers found!");
        return ResponseEntity.ok(mapper.listWorkToListWorkerResponseDto(workerListFound));
    }

}
