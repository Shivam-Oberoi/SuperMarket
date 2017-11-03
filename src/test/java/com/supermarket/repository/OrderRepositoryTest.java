package com.supermarket.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.supermarket.DummyDataTest;
import com.supermarket.dataaccessobject.OrderRepository;
import com.supermarket.domainobject.OrderDO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest extends DummyDataTest
{

    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void createNewOrderTest()
    {
        OrderDO orderDO = newOrderDO();
        OrderDO savedOrder = orderRepository.save(orderDO);
        assertNotNull(savedOrder);
    }


    @Test
    public void createNewOrder()
    {
        OrderDO orderDO = newOrderDO();
        OrderDO savedOrder = orderRepository.save(orderDO);
        assertNotNull(savedOrder);
    }
}
