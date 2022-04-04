package io.pragra.com.japlearning2.repo;

import io.pragra.com.japlearning2.entites.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramsRepo extends JpaRepository<Programs,Integer> {
}
