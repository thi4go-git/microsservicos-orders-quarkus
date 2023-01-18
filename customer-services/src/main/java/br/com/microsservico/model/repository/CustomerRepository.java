package br.com.microsservico.model.repository;

import br.com.microsservico.model.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public PanacheQuery<Customer> findCustomerByCpf(String cpf) {
        return find("cpf = :cpf", Parameters.with("cpf", cpf));
    }

    public PanacheQuery<Customer> findCustomerByEmail(String email) {
        return find("email = :email", Parameters.with("email", email));
    }


}
