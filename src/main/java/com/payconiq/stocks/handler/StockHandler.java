package com.payconiq.stocks.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payconiq.stocks.entities.Stock;
import com.payconiq.stocks.repository.StockDao;

/**
 * This service/handler class is used for writing the business logics
 * 
 * @author Chakraborty, Ayan (ayan.avi@gmail.com)
 */
@Service
public class StockHandler {

	@Autowired
	StockDao dao;

	/**
	 * Calls repository for fetching stocks based on number of stocks per page
	 * 
	 * @param pageable Pageable
	 * @return Page<Stock>
	 */
	public Page<Stock> fetchPageableStockList(Pageable pageable) {
		// Call PagingAndSortingRepository's super class method findAll() for pagination
		try {
			return dao.findAll(pageable);
		} catch(Exception e) {
			throw new DataAccessResourceFailureException("Failed while fetching data from database:: "+e.getMessage());
		}
	}
}
