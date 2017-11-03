package com.supermarket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.controller.mapper.OrderLineMapper;
import com.supermarket.datatransferobject.OrderLineDTO;
import com.supermarket.datatransferobject.ProductQuantityDTO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.service.checkout.CheckoutService;

/**
 * All features and characteristics of a checkout will be routed by this controller.
 * <p/>
 */

@RestController
@RequestMapping("v1/checkout")
public class CheckoutController
{

    private final CheckoutService checkoutService;


    @Autowired
    public CheckoutController(final CheckoutService checkoutService)
    {
        this.checkoutService = checkoutService;
    }


    @PostMapping("/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLineDTO scanProduct(@Valid @RequestBody final ProductQuantityDTO productQuantityDTO, @Valid @PathVariable final long orderId)
    {
        OrderLineDO orderLineDO = OrderLineMapper.makeOrderLineDO(productQuantityDTO);
        return OrderLineMapper.makeOrderLineDTO(checkoutService.createOrderLine(orderLineDO, orderId));
    }

}
