package com.supermarket.service.order;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.supermarket.dataaccessobject.OrderRepository;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.exception.OrderNotFoundException;

/**
 * Service to create a new order and get orderlines for a order.
 * 
 * <p/>
 */
@Service
public class OrderServiceImpl implements OrderService
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;


    public OrderServiceImpl(final OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }


    /**
     * Create a new order or update an existing one.
     *
     * @param orderDO
     * @throws OrderNotFoundException if no order with the given id found.
     **/
    @Override
    public OrderDO createNewOrder()
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setTotalAmount(0L);
        return orderRepository.save(orderDO);
    }


    /**
     * Find a order for a given orderId.
     *
     * @param id
     * @throws OrderNotFoundException if no order with the given id found.
     **/
    @Override
    public OrderDO findOrder(Long id)
    {
        OrderDO order = orderRepository.findOne(id);
        LOG.debug("Getting the order using orderid" + order);
        if (order == null)
        {
            throw new OrderNotFoundException("No such order with id" + id);
        }
        return order;
    }


    /**
     * Find  Orderlines for a given orderId.
     *
     * @param id
     * @throws OrderNotFoundException if no order with the given id found.
     **/
    @Override
    public List<OrderLineDO> findOrderLines(Long id) throws OrderNotFoundException
    {
        OrderDO order = orderRepository.findOne(id);
        LOG.debug("Getting the order to find the orderlines" + order);
        if (order == null)
        {
            throw new OrderNotFoundException("No such order with id" + id);
        }
        return order.getOrderLine();
    }


    @Override
    public OrderDO createOrder(OrderDO orderDO)
    {
        return orderRepository.save(orderDO);
    }

}
