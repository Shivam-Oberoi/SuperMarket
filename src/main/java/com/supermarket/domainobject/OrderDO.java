package com.supermarket.domainobject;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Data Access Object for Order with list of all orderlines.
 * <p/>
 */
@Entity
@Table(name = "order_table")
public class OrderDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime createdTime = ZonedDateTime.now();

    @Column()
    private String customerName;

    @Column()
    private String customerPhoneNo;

    @Column(nullable = false)
    private Long totalAmount;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineDO> orderLines;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public ZonedDateTime getCreatedTime()
    {
        return createdTime;
    }


    public void setCreatedTime(ZonedDateTime createdTime)
    {
        this.createdTime = createdTime;
    }


    public String getCustomerName()
    {
        return customerName;
    }


    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }


    public String getCustomerPhoneNo()
    {
        return customerPhoneNo;
    }


    public void setCustomerPhoneNo(String customerPhoneNo)
    {
        this.customerPhoneNo = customerPhoneNo;
    }


    public Long getTotalAmount()
    {
        return totalAmount;
    }


    public void setTotalAmount(Long totalAmount)
    {
        this.totalAmount = totalAmount;
    }


    public List<OrderLineDO> getOrderLine()
    {
        return orderLines;
    }


    public void setOrderLine(List<OrderLineDO> orderLines)
    {
        this.orderLines = orderLines;
    }
}
