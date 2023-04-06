package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Loan;

public interface LoanRepositories extends JpaRepository<Loan, Long>{
    List<Loan> findBybookId(Long bookId);
    List<Loan> findBystudentId(Long studentId);
    List<Loan> findBycheckoutDate(String checkoutDate);
    List<Loan> findBydueDate(String dueDate);
    List<Loan> findByreturnDate(String returnDate);
}
