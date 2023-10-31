package com.guilhermeramos31.mshrworker.service.assembler;

import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestDto;
import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import com.guilhermeramos31.mshrworker.model.entity.Worker;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkerConverter {
    private final ModelMapper modelMapper;

    public WorkerResponseDto workerToWorkerResponseDto(Worker work){
        return modelMapper.map(work, WorkerResponseDto.class);
    }

    public Worker work(WorkerRequestDto requestDto){
        return modelMapper.map(requestDto, Worker.class);
    }

    public List<WorkerResponseDto> listWorkToListWorkerResponseDto(List<Worker> listWorker){
        return listWorker.stream().map((element) -> modelMapper.map(element, WorkerResponseDto.class)).toList();
    }
}
