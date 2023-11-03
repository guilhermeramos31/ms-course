package com.guilhermeramos31.mshrworker.controller;

import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import com.guilhermeramos31.mshrworker.service.impl.WorkerServiceIMPL;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerServiceIMPL service;

    @GetMapping
    public ResponseEntity<List<WorkerResponseDto>> getAllWorkers(){
        return service.findAll();
    }

}
