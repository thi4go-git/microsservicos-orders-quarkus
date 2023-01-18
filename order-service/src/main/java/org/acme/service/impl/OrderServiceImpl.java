package org.acme.service.impl;

import org.acme.client.CustomerClient;
import org.acme.client.ProductClient;
import org.acme.model.entity.OrderProduct;
import org.acme.model.repository.OrderRepository;
import org.acme.rest.dto.CustomerDTO;
import org.acme.rest.dto.OrderDTO;
import org.acme.service.OrderService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderRepository repository;

    @Inject
    @RestClient
    private CustomerClient customerClient;

    @Inject
    @RestClient
    private ProductClient productClient;


    @Override
    public Response findAllOrders() {
        return Response.ok(repository.findAll().list()).build();
    }

    @Override
    @Transactional
    public Response createOrder(OrderDTO dto) {
        CustomerDTO customerDTO = customerClient.getCustomerById(dto.getCustomer_id());
        dto.setCustomer_name(customerDTO.getNome());
        if (customerDTO.getNome().equals(dto.getCustomer_name())
                && productClient.getProductById(dto.getProduct_id()) != null) {
            repository.persist(new OrderProduct(dto));
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(dto)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND.getStatusCode())
                    .build();
        }
    }

}
