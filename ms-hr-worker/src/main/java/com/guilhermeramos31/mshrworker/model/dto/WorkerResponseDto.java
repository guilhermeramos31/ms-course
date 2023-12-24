package com.guilhermeramos31.mshrworker.model.dto;

import lombok.*;


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