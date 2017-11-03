package com.supermarket.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.supermarket.dataaccessobject.ProductRepository;
import com.supermarket.domainobject.ProductDO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest
{
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void findAllProductTest()
    {

        List<ProductDO> products = (List<ProductDO>) productRepository.findAll();
        assertEquals(products.size(), 3.0, 0.0);
    }
}
