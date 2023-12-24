package com.guilhermeramos31.mshrworker.controller;

import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestDto;
import com.guilhermeramos31.mshrworker.model.dto.WorkerRequestUpdateDTO;
import com.guilhermeramos31.mshrworker.model.dto.WorkerResponseDto;
import com.guilhermeramos31.mshrworker.service.impl.WorkerServiceIMPL;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {
    private final WorkerServiceIMPL service;

    @GetMapping
    public ResponseEntity<List<WorkerResponseDto>> getAllWorkers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<WorkerResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<WorkerResponseDto> postNewWorker(@RequestBody WorkerRequestDto requestDto) {
        return ResponseEntity.ok(service.create(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerResponseDto> putWorker(@PathVariable long id,
                                                   @RequestBody WorkerRequestUpdateDTO requestUpdateDTO) throws IllegalAccessException {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(requestUpdateDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
