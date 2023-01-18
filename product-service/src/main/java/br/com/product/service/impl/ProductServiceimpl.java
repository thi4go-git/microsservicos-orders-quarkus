package br.com.product.service.impl;

import br.com.product.model.entiy.Product;
import br.com.product.model.repository.ProductRepository;
import br.com.product.rest.dto.ProductDTO;
import br.com.product.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductServiceimpl implements ProductService {

    @Inject
    private ProductRepository repository;


    @Override
    public ProductDTO findProductById(Long id) {
        return new ProductDTO(repository.findById(id));
    }

    @Override
    public Response findAllProducts() {
        List<ProductDTO> customers = new ArrayList<>();
        return Response.ok(repository.findAll().list()).build();
    }

    @Override
    @Transactional
    public Response createProduct(ProductDTO dto) {
        Product product = new Product
                (dto.getName(), dto.getDescription(), dto.getCategory(), dto.getPrice());
        repository.persist(product);
        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(product)
                .build();
    }

    @Override
    @Transactional
    public Response updateProduct(Long id, ProductDTO dto) {
        Product product = repository.findById(id);
        if (product != null) {
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setCategory(dto.getCategory());
            product.setPrice(dto.getPrice());
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    @Transactional
    public Response deleteProduct(Long id) {
        Product product = repository.findById(id);
        if (product != null) {
            repository.delete(product);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
