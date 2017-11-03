package com.supermarket.service.price;

import com.supermarket.domainobject.ProductDO;

public interface PriceService
{
    Long calculatePrice(ProductDO productDO, int quantity) ;
}
