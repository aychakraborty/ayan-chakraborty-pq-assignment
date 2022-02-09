package com.payconiq.stocks.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.payconiq.stocks.entities.Stock;

/**
 * This class extends from the Spring PagingAndSortingRepository interface and
 * inherits its superclass method to paginate data
 * 
 * @author Chakraborty, Ayan (ayan.avi@gmail.com)
 */
@Repository
public interface StockDao extends PagingAndSortingRepository<Stock, Long> {

}
