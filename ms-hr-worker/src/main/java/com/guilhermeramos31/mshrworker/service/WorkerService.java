package com.guilhermeramos31.mshrworker.service;

import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestDto;
import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestUpdateDTO;
import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;

import java.util.List;

public interface WorkerService {
    List<WorkerResponseDto> getAll();

    WorkerResponseDto getById(Long id);
    WorkerResponseDto create(WorkerRequestDto requestDto) throws IllegalAccessException;
    WorkerResponseDto update(WorkerRequestUpdateDTO requestUpdateDTO, Long id) throws IllegalAccessException;

    void delete(Long id);
}
