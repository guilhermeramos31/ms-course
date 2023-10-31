package com.guilhermeramos31.mshrworker.model.dto;

import lombok.NonNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.guilhermeramos31.mshrworker.model.entity.Worker}
 */
@Value
@NonNull
public class WorkerRequestDto implements Serializable {
    String name;
    Double dailyIncome;
}