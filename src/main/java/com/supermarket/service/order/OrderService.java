package com.supermarket.service.order;

import java.util.List;

import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.exception.OrderNotFoundException;

public interface OrderService
{
    OrderDO createNewOrder();


    OrderDO findOrder(Long id);


    List<OrderLineDO> findOrderLines(Long orderId) throws OrderNotFoundException;


    OrderDO createOrder(OrderDO orderDO);
}
