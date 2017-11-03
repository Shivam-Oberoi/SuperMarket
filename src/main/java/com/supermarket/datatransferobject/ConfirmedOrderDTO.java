package com.supermarket.datatransferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object for All OrderLines of an order and total amount of an order.
 * <p/>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmedOrderDTO
{
    private Long id;
    private List<OrderLineDTO> orderLines;

    private String customerName;

    private String customerPhoneNo;

    private Long totalAmount;


    public ConfirmedOrderDTO()
    {

    }


    public ConfirmedOrderDTO(Long id, List<OrderLineDTO> orderLines, String customerName, String customerPhoneNo, Long totalAmount)
    {
        this.id = id;
        this.orderLines = orderLines;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.totalAmount = totalAmount;
    }


    public Long getId()
    {
        return id;
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


    public List<OrderLineDTO> getOrderLines()
    {
        return orderLines;
    }


    public static ConfirmedOrderDTOBuilder newBuilder()
    {
        return new ConfirmedOrderDTOBuilder();
    }

    public static class ConfirmedOrderDTOBuilder
    {
        private Long id;

        private List<OrderLineDTO> orderLines;

        private String customerName;

        private String customerPhoneNo;

        private Long totalAmount;


        public ConfirmedOrderDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public ConfirmedOrderDTOBuilder setOrderLines(List<OrderLineDTO> orderLines)
        {
            this.orderLines = orderLines;
            return this;
        }


        public ConfirmedOrderDTOBuilder setCustomerName(String customerName)
        {
            this.customerName = customerName;
            return this;
        }


        public ConfirmedOrderDTOBuilder setCustomerPhoneNo(String customerPhoneNo)
        {
            this.customerPhoneNo = customerPhoneNo;
            return this;
        }


        public ConfirmedOrderDTOBuilder setTotalAmount(Long totalAmount)
        {
            this.totalAmount = totalAmount;
            return this;
        }


        public ConfirmedOrderDTO createConfirmedOrderDTO()
        {
            return new ConfirmedOrderDTO(id, orderLines, customerName, customerPhoneNo, totalAmount);
        }

    }
}
