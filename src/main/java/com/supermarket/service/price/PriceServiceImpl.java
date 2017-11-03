package com.supermarket.service.price;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.supermarket.domainobject.ProductDO;
import com.supermarket.domainobject.SpecialPriceDO;
import com.supermarket.exception.InvalidOfferException;
import com.supermarket.service.checkout.CheckoutServiceImpl;

/**
 * Service to get the price of a product according to the quantity and offer if valid.
 * 
 * <p/>
 */
@Service
public class PriceServiceImpl implements PriceService
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(CheckoutServiceImpl.class);


    /**
     * Calculate price of a product if has offer or not.
     *
     * @param productDO
     * @param quantity
     * @throws InvalidOfferException if offer is in wrong format.
     **/
    @Override
    public Long calculatePrice(ProductDO productDO, int quantity)
    {
        SpecialPriceDO specialPriceDO = productDO.getSpecialPrice();
        Long unitPrice = productDO.getUnitPrice();
        Long amount = quantity * unitPrice;
        if (specialPriceDO != null)
        {
            String offer = specialPriceDO.getOffer();
            LOG.debug("Offer is" + offer);
            Integer offerQuantity;
            Long offerValue;
            try
            {
                offerQuantity = Integer.parseInt(offer.split("\\s")[0]);
                offerValue = Long.parseLong(offer.split("\\s")[2]);
            }
            catch (NumberFormatException e)
            {
                LOG.error("Error while getting the price", e);
                throw new InvalidOfferException("Offer is not in correct format" + offer);
            }

            if (quantity >= offerQuantity)
            {
                amount = (quantity / offerQuantity) * offerValue + (quantity % offerQuantity) * unitPrice;
            }
        }
        LOG.debug("Getting the Amount" + amount);
        return amount;
    }
}
