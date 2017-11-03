package com.supermarket.service.product;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.supermarket.dataaccessobject.ProductRepository;
import com.supermarket.domainobject.ProductDO;
import com.supermarket.exception.ProductNotFoundException;

/**
 * Service to get the product.
 * 
 * <p/>
 */
@Service
public class ProductServiceImpl implements ProductService
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;


    public ProductServiceImpl(final ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


    /**
     * Get the Product using the productId.
     *
     * @param id
     * @throws ProductNotFoundException if no product with the given id was found.
     **/
    @Override
    public ProductDO getProduct(Long id) throws ProductNotFoundException
    {
        ProductDO product;
        product = productRepository.findOne(id);
        LOG.debug("Getting the product using" + id + " " + product);
        if (product == null)
        {
            throw new ProductNotFoundException("No Product found for this id" + id);
        }
        return product;
    }
}
