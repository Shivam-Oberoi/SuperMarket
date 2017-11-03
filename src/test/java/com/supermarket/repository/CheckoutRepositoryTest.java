package com.supermarket.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.supermarket.DummyDataTest;
import com.supermarket.dataaccessobject.OrderLineRepository;
import com.supermarket.dataaccessobject.OrderRepository;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckoutRepositoryTest extends DummyDataTest
{

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void createNewOrderLine()
    {
        OrderLineDO orderLineDO = getOrderLineDO();
        OrderDO orderDO = orderRepository.save(newOrderDO());
        OrderLineDO savedOrderLine = orderLineRepository.save(orderLineDO);
        assertNotNull(savedOrderLine);
        assertEquals(orderDO.getId(), savedOrderLine.getId(), 0L);
    }

}
