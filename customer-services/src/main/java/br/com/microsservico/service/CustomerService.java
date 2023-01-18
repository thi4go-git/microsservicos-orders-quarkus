package br.com.microsservico.service;

import br.com.microsservico.model.entity.Customer;
import br.com.microsservico.rest.dto.CustomerDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.ws.rs.core.Response;


public interface CustomerService {

    CustomerDTO findCustomerById(Long id);

    Response findAllCustomers();

    Response createCustomer(CustomerDTO dto);

    Response updateCustomer(Long id, CustomerDTO dto);

    Response deleteCustomer(Long id);

    PanacheQuery<Customer> findByCpf(String cpf);

    PanacheQuery<Customer> findByEmail(String email);

}
