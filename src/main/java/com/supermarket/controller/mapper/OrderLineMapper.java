package com.supermarket.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import com.supermarket.datatransferobject.OrderLineDTO;
import com.supermarket.datatransferobject.ProductQuantityDTO;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;

public class OrderLineMapper
{

    public static OrderLineDTO makeOrderLineDTO(OrderLineDO orderLineDO)
    {

        OrderLineDTO.OrderLineDTOBuilder OrderLineDTOBuilder = OrderLineDTO.newBuilder().setId(orderLineDO.getId())
            .setProductId(orderLineDO.getProductid()).setOrderId(orderLineDO.getOrder().getId()).setQuantity(orderLineDO.getQuantity())
            .setAmount(orderLineDO.getAmount()).setSpecialPrice(orderLineDO.getSpecialPrice()).setUnitPrice(orderLineDO.getUnitPrice())
            .setTotalAmount(orderLineDO.getOrder().getTotalAmount());

        return OrderLineDTOBuilder.createOrderLineDTO();
    }


    public static OrderLineDO makeOrderLineDO(OrderLineDTO orderLineDTO)
    {
        OrderLineDO OrderLineDO = new OrderLineDO();
        OrderLineDO.setId(orderLineDTO.getId());
        OrderLineDO.setProductid(orderLineDTO.getProductid());
        OrderLineDO.setQuantity(orderLineDTO.getQuantity());
        OrderDO order = new OrderDO();
        order.setId(orderLineDTO.getOrderId());
        OrderLineDO.setOrder(order);
        OrderLineDO.setUnitPrice(orderLineDTO.getUnitPrice());
        OrderLineDO.setSpecialPrice(orderLineDTO.getSpecialPrice());
        OrderLineDO.setAmount(orderLineDTO.getAmount());
        return OrderLineDO;
    }


    public static OrderLineDO makeOrderLineDO(ProductQuantityDTO productQuantityDTO)
    {
        OrderLineDO OrderLineDO = new OrderLineDO();
        OrderLineDO.setProductid(productQuantityDTO.getProductid());
        OrderLineDO.setQuantity(productQuantityDTO.getQuantity());
        return OrderLineDO;
    }


    public static List<OrderLineDTO> makeOrderLineDTO(List<OrderLineDO> orderLineDOList)
    {
        List<OrderLineDTO> orderLineDTOList = new ArrayList<>();
        orderLineDOList.forEach(orderLineDO -> orderLineDTOList.add(OrderLineDTO.newBuilder().setId(orderLineDO.getId())
            .setProductId(orderLineDO.getProductid()).setQuantity(orderLineDO.getQuantity())
            .setAmount(orderLineDO.getAmount()).setSpecialPrice(orderLineDO.getSpecialPrice()).setUnitPrice(orderLineDO.getUnitPrice())
            .createOrderLineDTO()));
        return orderLineDTOList;
    }
}
