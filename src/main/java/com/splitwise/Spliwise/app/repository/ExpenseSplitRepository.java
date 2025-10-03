package com.splitwise.Spliwise.app.repository;

import com.splitwise.Spliwise.app.entities.ExpenseSplit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseSplitRepository extends JpaRepository<ExpenseSplit, Long> {
}
