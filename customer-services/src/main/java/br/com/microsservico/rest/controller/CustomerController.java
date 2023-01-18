package br.com.microsservico.rest.controller;

import br.com.microsservico.model.entity.Customer;
import br.com.microsservico.rest.dto.CustomerDTO;
import br.com.microsservico.service.impl.CustomerServiceImpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

    @Inject
    private CustomerServiceImpl service;

    @GET
    public Response findAllCustomers() {
        return service.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    public CustomerDTO findCustomerById(@PathParam("id") Long id) {
        return service.findCustomerById(id);
    }

    @POST
    public Response createCustomer(@Valid CustomerDTO dto) {
        return service.createCustomer(dto);
    }

    @PUT
    @Path("{id}")
    public Response updateCustomer(@PathParam("id") Long id, @Valid CustomerDTO dto) {
        return service.updateCustomer(id, dto);
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        return service.deleteCustomer(id);
    }


}
