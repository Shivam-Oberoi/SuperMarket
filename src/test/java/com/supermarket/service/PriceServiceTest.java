package com.supermarket.service;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.supermarket.DummyDataTest;
import com.supermarket.domainobject.ProductDO;
import com.supermarket.exception.InvalidOfferException;
import com.supermarket.service.price.PriceServiceImpl;

public class PriceServiceTest extends DummyDataTest
{

    @InjectMocks
    PriceServiceImpl priceService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(PriceServiceImpl.class);
    }


    @Test
    public void calculateOfferPriceTest() throws InvalidOfferException
    {
        ProductDO productDO = getProduct1();
        Long amount = priceService.calculatePrice(productDO, 4);
        assertEquals(amount, 170L, 0L);
    }


    @Test
    public void calculateNonOfferPriceTest() throws InvalidOfferException
    {
        ProductDO productDO = getProduct1();
        Long amount = priceService.calculatePrice(productDO, 2);
        assertEquals(amount, 200L, 0L);
    }
    
    @Test(expected=InvalidOfferException.class)
    public void InvalidOfferPriceTest() throws InvalidOfferException
    {
        ProductDO productDO = getInvalidOfferProduct();
        Long amount = priceService.calculatePrice(productDO, 2);
        assertEquals(amount, 200L, 0L);
    }
}
