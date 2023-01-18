package org.acme.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.entity.OrderProduct;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<OrderProduct> {

}
