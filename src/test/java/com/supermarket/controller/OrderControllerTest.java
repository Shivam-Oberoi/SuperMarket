package com.supermarket.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.DummyDataTest;
import com.supermarket.controller.OrderController;
import com.supermarket.datatransferobject.OrderDTO;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.service.order.OrderService;

public class OrderControllerTest extends DummyDataTest
{

    private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(OrderController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(orderController).dispatchOptions(true).build();
    }


    @Test
    public void orderCreationTest() throws Exception
    {
        OrderDO orderDO = newOrderDO();
        doReturn(orderDO).when(orderService).createNewOrder();
        orderController.createNewOrder();
        MvcResult result = mvc
            .perform(post("/v1/order/newOrder").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("1"));
    }


    @Test
    public void getOrderLinesTest() throws Exception
    {
        OrderDO orderDO = getOrderDO();
        List<OrderLineDO> orderLines = getOrderLines();
        doReturn(orderLines).when(orderService).findOrderLines(any(Long.class));
        doReturn(orderDO).when(orderService).findOrder((any(Long.class)));
        orderController.getOrderLines(1L);
        MvcResult result = mvc.perform(get("/v1/order/orderLines/{orderId}", 1L))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("170"));
    }
}
