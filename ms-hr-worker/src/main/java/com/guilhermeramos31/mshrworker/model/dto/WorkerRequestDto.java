package com.guilhermeramos31.mshrworker.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.guilhermeramos31.mshrworker.model.entity.Worker}
 */

@Getter
@Setter
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class WorkerRequestDto {
    String name;
    Double dailyIncome;
}