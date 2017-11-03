package com.supermarket.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Data Access Object for OrderLine with an OrderId and Product Details purchased.
 * <p/>
 */
@Entity
@Table(name = "orderline")
public class OrderLineDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Product Id cannot be null")
    private Long productid;

    @Column(nullable = false)
    @NotNull(message = "Product Id cannot be null")
    private int quantity;

    @Column(nullable = false)
    @NotNull(message = "Unit Price cannot be null")
    private Long unitPrice;

    @Column(nullable = true)
    private Long specialPrice;

    @Column(nullable = false)
    private Long Amount;

    @ManyToOne()
    @JoinColumn(name = "orderid")
    private OrderDO order;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public Long getProductid()
    {
        return productid;
    }


    public void setProductid(Long productid)
    {
        this.productid = productid;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    public Long getUnitPrice()
    {
        return unitPrice;
    }


    public void setUnitPrice(Long unitPrice)
    {
        this.unitPrice = unitPrice;
    }


    public Long getSpecialPrice()
    {
        return specialPrice;
    }


    public void setSpecialPrice(Long specialPrice)
    {
        this.specialPrice = specialPrice;
    }


    public Long getAmount()
    {
        return Amount;
    }


    public void setAmount(Long amount)
    {
        Amount = amount;
    }


    public OrderDO getOrder()
    {
        return order;
    }


    public void setOrder(OrderDO order)
    {
        this.order = order;
    }

}
