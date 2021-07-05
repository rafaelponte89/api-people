package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
