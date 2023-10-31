package com.guilhermeramos31.mshrworker.repository;

import com.guilhermeramos31.mshrworker.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}