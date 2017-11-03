package com.supermarket.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class ProductDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PRODUCTNAME", nullable = false)
    @NotNull(message = "Product name cannot be null")
    private String productName;

    @Column(name = "UNITPRICE", nullable = false)
    @NotNull(message = "Unit Price cannot be null")
    private Long unitPrice;

    @OneToOne
    @JoinColumn(name = "SPECIAL_PRICE_ID")
    private SpecialPriceDO specialPrice;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getProductName()
    {
        return productName;
    }


    public void setProductName(String productName)
    {
        this.productName = productName;
    }


    public Long getUnitPrice()
    {
        return unitPrice;
    }


    public void setUnitPrice(Long unitPrice)
    {
        this.unitPrice = unitPrice;
    }


    public SpecialPriceDO getSpecialPrice()
    {
        return specialPrice;
    }


    public void setSpecialPrice(SpecialPriceDO specialPrice)
    {
        this.specialPrice = specialPrice;
    }
}
