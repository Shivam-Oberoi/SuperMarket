package com.supermarket;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.supermarket.datatransferobject.ConfirmedOrderDTO;
import com.supermarket.datatransferobject.OrderDTO;
import com.supermarket.datatransferobject.OrderLineDTO;
import com.supermarket.datatransferobject.ProductQuantityDTO;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.domainobject.ProductDO;
import com.supermarket.domainobject.SpecialPriceDO;

@RunWith(MockitoJUnitRunner.class)
public abstract class DummyDataTest
{

    public ProductDO getProduct1()
    {
        ProductDO product = new ProductDO();
        product.setId(1L);
        product.setProductName("CornFlakes");
        product.setUnitPrice(100L);
        SpecialPriceDO specialPrice = new SpecialPriceDO();
        specialPrice.setId(1L);
        specialPrice.setOffer("3 for 70");
        product.setSpecialPrice(specialPrice);
        return product;
    }


    public ProductDO getInvalidOfferProduct()
    {
        ProductDO product = new ProductDO();
        product.setId(1L);
        product.setProductName("CornFlakes");
        product.setUnitPrice(100L);
        SpecialPriceDO specialPrice = new SpecialPriceDO();
        specialPrice.setId(1L);
        specialPrice.setOffer("three for 70");
        product.setSpecialPrice(specialPrice);
        return product;
    }


    public ProductDO getProduct2()
    {
        ProductDO product = new ProductDO();
        product.setId(2L);
        product.setProductName("AppleJuice");
        product.setUnitPrice(60L);
        SpecialPriceDO specialPrice = new SpecialPriceDO();
        specialPrice.setId(1L);
        specialPrice.setOffer("3 for 70");
        product.setSpecialPrice(specialPrice);
        return product;
    }


    public OrderDO getOrderDO()
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        OrderLineDO orderLine1 = new OrderLineDO();
        orderLine1.setId(1L);
        orderLine1.setProductid(1L);
        orderLine1.setQuantity(4);
        orderLine1.setAmount(170L);
        orderDO.setId(1L);
        OrderLineDO orderLine2 = new OrderLineDO();
        orderLine2.setId(1L);
        orderLine2.setProductid(1L);
        orderLine2.setQuantity(4);
        orderLine2.setAmount(170L);
        List<OrderLineDO> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        orderDO.setOrderLine(orderLines);
        orderDO.setTotalAmount(300L);
        return orderDO;
    }


    public OrderDO newOrderDO()
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        orderDO.setTotalAmount(0L);
        return orderDO;
    }


    public OrderLineDO getOrderLineDO()
    {
        OrderLineDO orderLine1 = new OrderLineDO();
        orderLine1.setProductid(1L);
        orderLine1.setQuantity(4);
        orderLine1.setUnitPrice(100L);
        orderLine1.setAmount(170L);
        orderLine1.setId(1L);
        List<OrderLineDO> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        orderDO.setOrderLine(orderLines);
        orderLine1.setOrder(orderDO);
        return orderLine1;
    }


    public ProductQuantityDTO getProductQuantity()
    {
        ProductQuantityDTO productQuantity = ProductQuantityDTO.newBuilder().setProductId(1L).setQuantity(4).createProductQuantityDTO();
        return productQuantity;
    }


    public OrderLineDO getProductAndQuantity()
    {
        OrderLineDO orderLine1 = new OrderLineDO();
        orderLine1.setProductid(1L);
        orderLine1.setQuantity(4);
        orderLine1.setId(1L);
        return orderLine1;
    }


    public List<OrderLineDTO> getOrderLinesDTO()
    {
        List<OrderLineDTO> orderLines = new ArrayList<>();
        OrderLineDTO orderLineDTO1 = OrderLineDTO.newBuilder().setId(1L).setProductId(1L).setQuantity(4).setAmount(170L).setTotalAmount(170L).createOrderLineDTO();
        OrderLineDTO orderLineDTO2 = OrderLineDTO.newBuilder().setId(2L).setProductId(2L).setQuantity(4).setAmount(130L).setTotalAmount(300L).createOrderLineDTO();
        orderLines.add(orderLineDTO1);
        orderLines.add(orderLineDTO2);
        return orderLines;
    }


    public List<OrderLineDO> getOrderLinesDO()
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        OrderLineDO orderLine1 = new OrderLineDO();
        orderLine1.setId(1L);
        orderLine1.setProductid(1L);
        orderLine1.setQuantity(4);
        orderLine1.setAmount(170L);
        OrderLineDO orderLine2 = new OrderLineDO();
        orderLine2.setId(2L);
        orderLine2.setProductid(2L);
        orderLine2.setQuantity(4);
        orderLine2.setAmount(130L);
        List<OrderLineDO> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        orderDO.setOrderLine(orderLines);
        orderDO.setTotalAmount(300L);
        return orderLines;
    }


    public OrderLineDTO getOrderLine()
    {
        OrderLineDTO orderLineDTO1 = OrderLineDTO.newBuilder().setId(1L).setProductId(1L).setQuantity(4).setAmount(170L).setTotalAmount(170L).setOrderId(1L).createOrderLineDTO();
        return orderLineDTO1;
    }


    public OrderDTO getOrderDTO()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = OrderDTO.newBuilder().setId(1L).setTotalAmount(17L).createOrderDTO();
        return orderDTO;
    }


    public ConfirmedOrderDTO getConfirmedOrderDTO()
    {
        OrderLineDTO orderLineDTO1 = OrderLineDTO.newBuilder().setId(1L).setProductId(1L).setQuantity(4).setAmount(170L).setTotalAmount(170L).setOrderId(1L).createOrderLineDTO();
        OrderLineDTO orderLineDTO2 = OrderLineDTO.newBuilder().setId(1L).setProductId(2L).setQuantity(4).setAmount(170L).setTotalAmount(170L).setOrderId(1L).createOrderLineDTO();
        List<OrderLineDTO> orderLinesDTO = new ArrayList<>();
        orderLinesDTO.add(orderLineDTO1);
        orderLinesDTO.add(orderLineDTO2);
        return ConfirmedOrderDTO.newBuilder().setId(1L).setOrderLines(orderLinesDTO).createConfirmedOrderDTO();
    }


    public List<OrderLineDO> getOrderLines()
    {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(1L);
        OrderLineDO orderLine1 = new OrderLineDO();
        orderLine1.setId(1L);
        orderLine1.setProductid(1L);
        orderLine1.setQuantity(4);
        orderLine1.setAmount(170L);
        OrderLineDO orderLine2 = new OrderLineDO();
        orderLine2.setId(2L);
        orderLine2.setProductid(2L);
        orderLine2.setQuantity(4);
        orderLine2.setAmount(130L);
        List<OrderLineDO> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        orderDO.setTotalAmount(300L);
        return orderLines;
    }
}
