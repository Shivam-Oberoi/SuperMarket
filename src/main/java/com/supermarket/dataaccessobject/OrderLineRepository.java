package com.supermarket.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.domainobject.OrderLineDO;

/**
 * Database Access Object for OrderLine table which has OrderId and Product purchased details.
 * <p/>
 */
@Repository
public interface OrderLineRepository extends CrudRepository<OrderLineDO, Long>
{

}
