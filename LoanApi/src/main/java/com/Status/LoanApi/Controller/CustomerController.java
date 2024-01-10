package com.Status.LoanApi.Controller;

import com.Status.LoanApi.Model.Customer;
import com.Status.LoanApi.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/LoanStatus")
public class CustomerController {
private CustomerService customerService;

public CustomerController(CustomerService customerService){
    this.customerService = customerService;
}

@GetMapping
    public List<Customer>getCustomers(){
    return customerService.getCustomers();
}
    @GetMapping("{Id}")
    public Customer getCustomerById(@PathVariable("Id")long Id){
        return customerService.getCustomerById(Id);
    }
@GetMapping("/loanId/{LoanId}")
    public Customer getCustomerByLoanId(@PathVariable("LoanId")long LoanId){
    return customerService.getCustomerByLoanId(LoanId);
}
@PostMapping
    public String insertNewCustomer(@RequestBody Customer customer){
    customerService.addNewCustomers(customer);
    return "Customer Added SuccessFully";
}
//@PutMapping(path = "{LoanId}")
//    public String updateStatus(@PathVariable("LaonId") Long LoanId,
//                               @RequestParam(required = false) Boolean Status){
//    customerService.updateCustomer(LoanId,Status);
//    return "Status Updated Successfully";
//}

    @PutMapping(path = "{Id}")
    public String updateStatus(@PathVariable("Id") Long Id,
                               @RequestParam(required = false) Boolean Status){
        customerService.updateCustomer(Id,Status);
        return "Status Updated Successfully";
    }

}
