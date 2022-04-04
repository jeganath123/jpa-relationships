package io.pragra.com.japlearning2.repo;

import io.pragra.com.japlearning2.entites.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReviewsRepo extends JpaRepository<Reviews,Integer> {
}
