package com.supermarket.service.product;

import com.supermarket.domainobject.ProductDO;
import com.supermarket.exception.ProductNotFoundException;

public interface ProductService
{
    ProductDO getProduct(Long id) throws ProductNotFoundException;
}
