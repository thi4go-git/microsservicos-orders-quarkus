package org.acme.service;


import org.acme.rest.dto.OrderDTO;

import javax.ws.rs.core.Response;

public interface OrderService {
    Response findAllOrders();
    Response createOrder(OrderDTO dto);
}
