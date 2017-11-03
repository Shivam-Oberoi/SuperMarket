package com.supermarket.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.supermarket.datatransferobject.ProductQuantityDTO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.service.checkout.CheckoutService;

public class CheckoutControllerTest extends DummyDataTest
{

    private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private CheckoutService checkoutService;

    @InjectMocks
    private CheckoutController checkoutController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CheckoutController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(checkoutController).dispatchOptions(true).build();
    }


    @Test
    public void scanProductTest() throws Exception 
    {
        OrderLineDO orderLineDO = getOrderLineDO();
        ProductQuantityDTO productQuantityDTO = getProductQuantity();
        String jsonInString = mapper.writeValueAsString(productQuantityDTO);
        doReturn(orderLineDO).when(checkoutService).createOrderLine(any(OrderLineDO.class), any(Long.class));
        checkoutController.scanProduct(productQuantityDTO, 1L);
        MvcResult result = mvc
            .perform(post("/v1/checkout/{orderId}", 1L).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonInString))
            .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("170"));
    }
}
