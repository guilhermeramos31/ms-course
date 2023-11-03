package com.guilhermeramos31.mshrworker.service;

import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkerService {
    public ResponseEntity<List<WorkerResponseDto>> findAll();

}
