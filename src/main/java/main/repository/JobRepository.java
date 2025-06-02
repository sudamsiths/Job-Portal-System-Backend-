package main.repository;

import main.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface JobRepository extends JpaRepository<JobEntity , Integer> {
}
