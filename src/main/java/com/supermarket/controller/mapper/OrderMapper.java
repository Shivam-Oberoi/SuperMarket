package com.supermarket.controller.mapper;

import java.util.List;

import com.supermarket.datatransferobject.ConfirmedOrderDTO;
import com.supermarket.datatransferobject.OrderDTO;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;

public class OrderMapper
{
    public static OrderDTO makeOrderDTO(OrderDO OrderDO)
    {
        OrderDTO.OrderDTOBuilder OrderDTOBuilder = OrderDTO.newBuilder().setId(OrderDO.getId())
            .setCustomerPhoneNo(OrderDO.getCustomerName()).setCustomerPhoneNo(OrderDO.getCustomerPhoneNo()).setTotalAmount(OrderDO.getTotalAmount());
        return OrderDTOBuilder.createOrderDTO();
    }


    public static OrderDO makeOrderDO(OrderDTO orderDTO)
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(orderDTO.getId());
        orderDO.setCustomerName(orderDTO.getCustomerName());
        orderDO.setCustomerPhoneNo(orderDO.getCustomerPhoneNo());
        orderDO.setTotalAmount(orderDTO.getTotalAmount());
        return orderDO;
    }


    public static ConfirmedOrderDTO makeConfirmedOrderDTO(List<OrderLineDO> findOrderLines, OrderDO orderDO)
    {
        ConfirmedOrderDTO.ConfirmedOrderDTOBuilder confirmedOrderDTOBuilder = ConfirmedOrderDTO.newBuilder().setOrderLines(OrderLineMapper.makeOrderLineDTO(findOrderLines))
            .setTotalAmount(orderDO.getTotalAmount()).setId(orderDO.getId());
        return confirmedOrderDTOBuilder.createConfirmedOrderDTO();
    }

}
