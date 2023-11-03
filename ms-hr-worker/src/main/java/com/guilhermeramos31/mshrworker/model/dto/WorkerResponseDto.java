package com.guilhermeramos31.mshrworker.model.dto;

import lombok.*;
import lombok.NonNull;

import java.io.Serializable;

/**
 * DTO for {@link com.guilhermeramos31.mshrworker.model.entity.Worker}
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerResponseDto {
    Long id;
    String name;
    Double dailyIncome;
}