package com.supermarket.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.domainobject.ProductDO;

/**
 * Database Access Object for Product table.
 * <p/>
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductDO, Long>
{

}
