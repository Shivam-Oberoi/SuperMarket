package com.supermarket.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.controller.mapper.OrderMapper;
import com.supermarket.datatransferobject.ConfirmedOrderDTO;
import com.supermarket.datatransferobject.OrderDTO;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.service.order.OrderService;

/**
 * All order creation and printing of orderLines of an order will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/order")
public class OrderController
{
    private final OrderService orderService;


    @Autowired
    public OrderController(final OrderService orderService)
    {
        this.orderService = orderService;
    }


    @PostMapping("/newOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createNewOrder() throws EntityNotFoundException
    {
        return OrderMapper.makeOrderDTO(orderService.createNewOrder());
    }


    @GetMapping("orderLines/{orderId}")
    public ConfirmedOrderDTO getOrderLines(@Valid @PathVariable long orderId)
    {
        return OrderMapper.makeConfirmedOrderDTO(orderService.findOrderLines(orderId), orderService.findOrder(orderId));
    }
}
