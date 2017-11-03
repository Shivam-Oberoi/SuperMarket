package com.supermarket.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.supermarket.DummyDataTest;
import com.supermarket.dataaccessobject.OrderLineRepository;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.domainobject.ProductDO;
import com.supermarket.exception.InvalidOfferException;
import com.supermarket.exception.OrderNotFoundException;
import com.supermarket.service.checkout.CheckoutServiceImpl;
import com.supermarket.service.order.OrderService;
import com.supermarket.service.price.PriceService;
import com.supermarket.service.product.ProductService;

public class CheckoutServiceTest extends DummyDataTest
{

    @Mock
    private OrderLineRepository orderLineRepository;

    @Mock
    private OrderService orderService;

    @Mock
    private ProductService productService;

    @Mock
    private PriceService priceService;

    @InjectMocks
    CheckoutServiceImpl checkoutServiceImpl;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CheckoutServiceImpl.class);
    }


    @Test
    public void scanProductTest() throws com.supermarket.exception.ProductNotFoundException, InvalidOfferException, OrderNotFoundException
    {
        OrderLineDO orderLineDO = getProductAndQuantity();
        OrderDO firstOrder = newOrderDO();
        OrderLineDO createdOrderLineDO = getOrderLineDO();
        ProductDO product = getProduct1();
        OrderDO createdOrder = getOrderDO();
        when(orderService.findOrder(any(Long.class))).thenReturn(firstOrder);
        when(productService.getProduct(any(Long.class))).thenReturn(product);
        when(priceService.calculatePrice(product, 4)).thenReturn(170L);
        when(orderService.createOrder(any(OrderDO.class))).thenReturn(createdOrder);
        when(orderLineRepository.save(any(OrderLineDO.class))).thenReturn(createdOrderLineDO);
        OrderLineDO actual = checkoutServiceImpl.createOrderLine(orderLineDO, 1L);
        assertEquals(actual.getAmount(), 170L, 0L);
        verify(orderService, times(1)).findOrder(1L);
        verify(orderService, times(1)).findOrder(1L);
        verify(orderService, times(1)).findOrder(any(Long.class));
        verify(orderLineRepository, times(1)).save(any(OrderLineDO.class));
    }

}
