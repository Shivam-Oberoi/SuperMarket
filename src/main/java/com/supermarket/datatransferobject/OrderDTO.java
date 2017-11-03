package com.supermarket.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object for Order with total amount of an order and customer details.
 * <p/>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO
{
    private Long id;

    private String customerName;

    private String customerPhoneNo;

    private Long totalAmount;


    public OrderDTO()
    {

    }


    public OrderDTO(Long id, String customerName, String customerPhoneNo, Long totalAmount)
    {
        this.id = id;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.totalAmount = totalAmount;
    }


    public String getCustomerName()
    {
        return customerName;
    }


    public String getCustomerPhoneNo()
    {
        return customerPhoneNo;
    }


    public Long getTotalAmount()
    {
        return totalAmount;
    }


    public Long getId()
    {
        return id;
    }


    public static OrderDTOBuilder newBuilder()
    {
        return new OrderDTOBuilder();
    }

    public static class OrderDTOBuilder
    {
        private Long id;

        private String customerName;

        private String customerPhoneNo;

        private Long totalAmount;


        public OrderDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public OrderDTOBuilder setCustomerName(String customerName)
        {
            this.customerName = customerName;
            return this;
        }


        public OrderDTOBuilder setCustomerPhoneNo(String customerPhoneNo)
        {
            this.customerPhoneNo = customerPhoneNo;
            return this;
        }


        public OrderDTOBuilder setTotalAmount(Long totalAmount)
        {
            this.totalAmount = totalAmount;
            return this;
        }


        public OrderDTO createOrderDTO()
        {
            return new OrderDTO(id, customerName, customerPhoneNo, totalAmount);
        }

    }
}
