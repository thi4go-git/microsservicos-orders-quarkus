package br.com.product.rest.controller;

import br.com.product.rest.dto.ProductDTO;
import br.com.product.service.impl.ProductServiceimpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductServiceimpl service;


    @Path("/{id}")
    @GET
    public ProductDTO findProductById(@PathParam("id") Long id) {
        return service.findProductById(id);
    }

    @GET
    public Response findAllProducts() {
        return service.findAllProducts();
    }

    @POST
    public Response createProducts(@Valid ProductDTO dto) {
        return service.createProduct(dto);
    }

    @PUT
    @Path("{id}")
    public Response updateProducts(@PathParam("id") Long id, @Valid ProductDTO dto) {
        return service.updateProduct(id, dto);
    }

    @DELETE
    @Path("{id}")
    public Response deleteProducts(@PathParam("id") Long id) {
        return service.deleteProduct(id);
    }


}
