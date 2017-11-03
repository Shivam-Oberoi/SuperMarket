package com.supermarket.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialprice")
public class SpecialPriceDO
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "OFFER", nullable = false)
    private String offer;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getOffer()
    {
        return offer;
    }


    public void setOffer(String offer)
    {
        this.offer = offer;
    }
}
