package com.supermarket.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object for product scan with productid and quantity.
 * <p/>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductQuantityDTO
{

    private Long productid;

    private int quantity;


    public ProductQuantityDTO()
    {

    }


    public ProductQuantityDTO(Long productid, int quantity)
    {
        this.productid = productid;
        this.quantity = quantity;
    }


    public Long getProductid()
    {
        return productid;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public static ProductQuantityDTOBuilder newBuilder()
    {
        return new ProductQuantityDTOBuilder();
    }

    public static class ProductQuantityDTOBuilder
    {

        private Long productid;

        private int quantity;


        public ProductQuantityDTOBuilder setProductId(Long productid)
        {
            this.productid = productid;
            return this;
        }


        public ProductQuantityDTOBuilder setQuantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }


        public ProductQuantityDTO createProductQuantityDTO()
        {
            return new ProductQuantityDTO(productid, quantity);
        }

    }
}
