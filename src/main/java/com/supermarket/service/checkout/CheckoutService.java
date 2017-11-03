package com.supermarket.service.checkout;

import com.supermarket.domainobject.OrderLineDO;

public interface CheckoutService
{
    OrderLineDO createOrderLine(final OrderLineDO orderLineDO, final Long orderId);
}
