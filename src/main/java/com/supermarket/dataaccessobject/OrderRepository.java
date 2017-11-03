package com.supermarket.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.domainobject.OrderDO;

/**
 * Database Access Object for Order table.
 * <p/>
 */
public interface OrderRepository extends CrudRepository<OrderDO, Long>
{

}
