package br.com.microsservico.service.impl;

import br.com.microsservico.model.entity.Customer;
import br.com.microsservico.model.repository.CustomerRepository;
import br.com.microsservico.rest.dto.CustomerDTO;
import br.com.microsservico.service.CustomerService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerRepository repository;

    @Override
    public CustomerDTO findCustomerById(Long id) {
        return CustomerDTO.converterParaDto(repository.findById(id));

    }

    @Override
    @Transactional
    public Response findAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
//        repository.findAll().stream().forEach(item -> {
//            customers.add(CustomerDTO.converterParaDto(item));
//        });
        return Response.ok(repository.findAll().list()).build();
    }

    @Override
    @Transactional
    public Response createCustomer(CustomerDTO dto) {
        Customer customer = new Customer
                (dto.getNome(), dto.getPhone(), dto.getEmail(), dto.getAddress(), dto.getAge(), dto.getCpf());
        repository.persist(customer);
        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(customer)
                .build();
    }

    @Override
    @Transactional
    public Response updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = repository.findById(id);
        if (customer != null) {
            customer.setAddress(dto.getAddress());
            customer.setAge(dto.getAge());
            customer.setEmail(dto.getEmail());
            customer.setNome(dto.getNome());
            customer.setPhone(dto.getPhone());
            customer.setCpf(dto.getCpf());
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @Transactional
    public Response deleteCustomer(Long id) {
        Customer customer = repository.findById(id);
        if (customer != null) {
            repository.delete(customer);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public PanacheQuery<Customer> findByCpf(String cpf) {
        PanacheQuery<Customer> customers = repository.findCustomerByCpf(cpf);
        return customers;
    }

    @Override
    public PanacheQuery<Customer> findByEmail(String email) {
        PanacheQuery<Customer> customers = repository.findCustomerByEmail(email);
        return customers;
    }

}
