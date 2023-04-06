package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import com.xfactor.openlibrary.domain.Loan;
import com.xfactor.openlibrary.repositories.LoanRepositories;
@RestController
@RequestMapping("loans")
public class LoanController {
    private LoanRepositories loanRepositories;
    public LoanController(LoanRepositories loanRepositories){
        this.loanRepositories = loanRepositories;
    }

    @PostMapping("/saveloan")
    public Loan saveLoan(@RequestBody Loan loan)
    {
        loanRepositories.save(loan);
        return loan;
    }

    @PutMapping("/updateLoan")
    public Loan updateLoan(@RequestBody Loan loan, CrudRepository<Loan, Long> loanRepository) {
        if (loan.getId() != null) {
            Loan loan2 = loanRepository.save(loan);
            return loan2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanRepositories.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<Loan> getAllLoans()
    {
        return loanRepositories.findAll();
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return loanRepositories.count();
    }

    @GetMapping("findById/{id}")
    public Loan findById(@PathVariable Long id){
        Optional<Loan> optionalOfLoan = loanRepositories.findById(id);
        if(optionalOfLoan.isPresent()){
            return optionalOfLoan.get();
        }
        return null;
    }
    
    @GetMapping("findBybookId/{bookId}")
    public List<Loan> findBybookId(@PathVariable Long bookId){
        List<Loan> listOfbookId = loanRepositories.findBybookId(bookId);
        return listOfbookId;
    }

    @GetMapping("findBystudentId/{studentId}")
    public List<Loan> findBystudentId(@PathVariable Long studentId){
        List<Loan> listOfstudentId = loanRepositories.findBystudentId(studentId);
        return listOfstudentId;
    }

    @GetMapping("findBycheckoutDate/{checkoutDate}")
    public List<Loan> findBycheckoutDate(@PathVariable String checkoutDate) {
        List<Loan> listOfcheckoutDate = loanRepositories.findBycheckoutDate(checkoutDate);
        return listOfcheckoutDate;
    }

    @GetMapping("/findBydueDate/{dueDate}")
    public List<Loan> findBydueDate(@PathVariable String dueDate){
        List<Loan> listOfdueDate = loanRepositories.findBydueDate(dueDate);
        return listOfdueDate;
    }

    @GetMapping("findByreturnDate/{returnDate}")
    public List<Loan> findByreturnDate(@PathVariable String returnDate){
        List<Loan> listOfreturnDate = loanRepositories.findByreturnDate(returnDate);
        return listOfreturnDate;
    }

    
}