package org.acme.rest.controller;

import org.acme.rest.dto.OrderDTO;
import org.acme.service.impl.OrderServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    private OrderServiceImpl service;

    @POST
    public Response createOrder(OrderDTO dto) {
        return service.createOrder(dto);
    }



    @GET
    @RolesAllowed({"user", "admin"})//configuração KeyCloak segurança
    public Response findAllOrders() {
        return service.findAllOrders();
    }

}
