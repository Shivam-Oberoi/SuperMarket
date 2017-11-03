package com.supermarket.service.checkout;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dataaccessobject.OrderLineRepository;
import com.supermarket.domainobject.OrderDO;
import com.supermarket.domainobject.OrderLineDO;
import com.supermarket.domainobject.ProductDO;
import com.supermarket.exception.InvalidOfferException;
import com.supermarket.exception.OrderNotFoundException;
import com.supermarket.exception.ProductNotFoundException;
import com.supermarket.service.order.OrderService;
import com.supermarket.service.price.PriceService;
import com.supermarket.service.product.ProductService;

/**
 * Service to scan the product and create an OrderLine.
 * 
 * <p/>
 */
@Service
public class CheckoutServiceImpl implements CheckoutService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private final OrderLineRepository orderLineRepository;

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final PriceService priceService;


    public CheckoutServiceImpl(final OrderLineRepository orderLineRepository, final OrderService orderService,
        final ProductService productService, final PriceService priceService)
    {
        this.orderLineRepository = orderLineRepository;
        this.orderService = orderService;
        this.productService = productService;
        this.priceService = priceService;

    }


    /**
     * Scan a product and create an OrderLine against a new or existing Order.
     *
     * @param orderLineDO
     * @param orderId
     * @throws ProductNotFoundException if no product with the given id was found.
     * @throws InvalidOfferException if no valid offer.
     * @throws OrderNotFoundException if no order with the given id found.
     **/
    @Override
    public OrderLineDO createOrderLine(final OrderLineDO orderLineDO, final Long orderId)
    {
        OrderDO orderDO = orderService.findOrder(orderId);
        Long productId = orderLineDO.getProductid();
        int quantity = orderLineDO.getQuantity();
        ProductDO productDO = productService.getProduct(productId);
        Long unitPrice = productDO.getUnitPrice();
        Long amount = priceService.calculatePrice(productDO, quantity);
        orderLineDO.setProductid(productId);
        orderLineDO.setQuantity(quantity);
        orderLineDO.setAmount(amount);
        orderLineDO.setUnitPrice(unitPrice);
        orderDO.setTotalAmount(amount + orderDO.getTotalAmount());
        OrderDO savedOrder = orderService.createOrder(orderDO);
        LOG.info("An order with id" + orderId + "is created");
        orderLineDO.setOrder(savedOrder);
        return orderLineRepository.save(orderLineDO);
    }
}
