package com.supermarket.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.supermarket.DummyDataTest;
import com.supermarket.dataaccessobject.OrderRepository;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.exception.OrderNotFoundException;
import com.supermarket.service.order.OrderServiceImpl;

public class OrderServiceTest extends DummyDataTest
{

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(OrderServiceImpl.class);
    }


    @Test
    public void findOrderByIdTest() throws EntityNotFoundException, OrderNotFoundException
    {
        OrderDO order = getOrderDO();
        when(orderRepository.findOne(any(Long.class))).thenReturn(order);
        orderService.findOrder(1L);
        verify(orderRepository, times(1)).findOne(any(Long.class));
    }


    @Test
    public void orderLinesByOrderIdTest() throws EntityNotFoundException, OrderNotFoundException
    {
        OrderDO order = getOrderDO();
        when(orderRepository.findOne(any(Long.class))).thenReturn(order);
        orderService.findOrderLines(1L);
        verify(orderRepository, times(1)).findOne(any(Long.class));
    }
}
