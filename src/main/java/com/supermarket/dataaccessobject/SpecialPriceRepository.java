package com.supermarket.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.domainobject.SpecialPriceDO;

/**
 * Database Access Object for SpecialPrice/Offers table.
 * <p/>
 */
@Repository
public interface SpecialPriceRepository extends CrudRepository<SpecialPriceDO, Long>
{

}
