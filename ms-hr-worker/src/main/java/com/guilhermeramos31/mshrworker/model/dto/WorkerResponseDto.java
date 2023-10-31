package com.guilhermeramos31.mshrworker.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.guilhermeramos31.mshrworker.model.entity.Worker}
 */
@Value
public class WorkerResponseDto implements Serializable {
    Long id;
    String name;
    Double dailyIncome;
}