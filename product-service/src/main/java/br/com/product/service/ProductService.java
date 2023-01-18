package br.com.product.service;

import br.com.product.rest.dto.ProductDTO;

import javax.ws.rs.core.Response;

public interface ProductService {

    ProductDTO findProductById(Long id);

    Response findAllProducts();

    Response createProduct(ProductDTO dto);

    Response updateProduct(Long id, ProductDTO dto);

    Response deleteProduct(Long id);
}
