package com.Status.LoanApi.Service;
import com.Status.LoanApi.Model.Customer;
import com.Status.LoanApi.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    public CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerByLoanId(long LoanId){
        return customerRepository.findByLoanId(LoanId);
    }
    public Customer getCustomerById(long Id){
        return customerRepository.findById(Id).get();
    }

    public void addNewCustomers(Customer customer){
        customerRepository.save(customer);
    }
    public void addNewCustomer(Customer customer){
        Optional<Optional<Customer>> CustomerByLoanId = Optional.ofNullable(customerRepository
                .findById(customer.getLoanId()));
        if(CustomerByLoanId.isPresent()){
            throw new IllegalStateException( "Id is already exists ");
        }
        customerRepository.save(customer);
        System.out.println(customer);
    }

    public Customer updateCustomer(Long Id, Boolean status) {
        return customerRepository.findById(Id).get();
    }


//    public void updateCustomer(Long LoanId, Boolean Status){
//        Customer customer = customerRepository.findByLoanId(LoanId);
//        if (Status){
//            customer.setStatus(false);
//        }
//        customer.setStatus(true);
//    }

}
