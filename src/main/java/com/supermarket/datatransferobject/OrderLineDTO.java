package com.supermarket.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object for OrderLine product details.
 * <p/>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineDTO
{
    private Long id;

    private Long productid;

    private int quantity;

    private Long unitPrice;

    private Long specialPrice;

    private Long Amount;

    private Long orderId;

    private Long totalAmount;


    public OrderLineDTO()
    {

    }


    public OrderLineDTO(Long id, Long productid, int quantity, Long unitPrice, Long specialPrice, Long Amount,
        Long orderId, Long totalAmount)
    {
        this.id = id;
        this.productid = productid;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
        this.Amount = Amount;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }


    public OrderLineDTO(Long productid, int quantity)
    {
        this.productid = productid;
        this.quantity = quantity;
    }


    public Long getId()
    {
        return id;
    }


    public Long getProductid()
    {
        return productid;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public Long getUnitPrice()
    {
        return unitPrice;
    }


    public Long getSpecialPrice()
    {
        return specialPrice;
    }


    public Long getAmount()
    {
        return Amount;
    }


    public Long getOrderId()
    {
        return orderId;
    }


    public Long getTotalAmount()
    {
        return totalAmount;
    }


    public static OrderLineDTOBuilder newBuilder()
    {
        return new OrderLineDTOBuilder();
    }

    public static class OrderLineDTOBuilder
    {
        private Long id;

        private Long productid;

        private int quantity;

        private Long unitPrice;

        private Long specialPrice;

        private Long Amount;

        private Long orderId;

        private Long totalAmount;


        public OrderLineDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public OrderLineDTOBuilder setProductId(Long productid)
        {
            this.productid = productid;
            return this;
        }


        public OrderLineDTOBuilder setQuantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }


        public OrderLineDTOBuilder setUnitPrice(Long unitPrice)
        {
            this.unitPrice = unitPrice;
            return this;
        }


        public OrderLineDTOBuilder setSpecialPrice(Long specialPrice)
        {
            this.specialPrice = specialPrice;
            return this;
        }


        public OrderLineDTOBuilder setAmount(Long Amount)
        {
            this.Amount = Amount;
            return this;
        }


        public OrderLineDTOBuilder setOrderId(Long orderId)
        {
            this.orderId = orderId;
            return this;
        }


        public OrderLineDTOBuilder setTotalAmount(Long totalAmount)
        {
            this.totalAmount = totalAmount;
            return this;
        }


        public OrderLineDTO createOrderLineDTO()
        {
            return new OrderLineDTO(id, productid, quantity, unitPrice, specialPrice, Amount, orderId, totalAmount);
        }

    }
}
