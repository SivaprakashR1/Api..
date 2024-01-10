package com.Status.LoanApi.Repository;

import com.Status.LoanApi.Model.Customer;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository

    public interface CustomerRepository extends JpaRepository<Customer, Long> {
        @Query("SELECT c FROM Customer c WHERE c.LoanId = :loanId")
        Customer findByLoanId(@Param("loanId") long loanId);
    }

