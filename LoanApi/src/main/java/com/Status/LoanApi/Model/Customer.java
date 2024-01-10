package com.Status.LoanApi.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Customer_Status")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long CustomerId;
//    @Column(name = "LoanId")
    long LoanId;
    String CustomerName;
    long LoanAmount;
    LocalDate DateOfLoan;
    int Duration;
    boolean Status;

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }


    public long getLoanId() {
        return LoanId;
    }

    public void setLoanId(long loanId) {
        LoanId = loanId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public long getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        LoanAmount = loanAmount;
    }

    public LocalDate getDateOfLoan() {
        return DateOfLoan;
    }

    public void setDateOfLoan(LocalDate dateOfLoan) {
        DateOfLoan = dateOfLoan;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}
