package com.payconiq.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.stocks.entities.Stock;
import com.payconiq.stocks.handler.StockHandler;

/**
 * This RestController class holds all the API end-points related to stocks
 * 
 * @author Chakraborty, Ayan (ayan.avi@gmail.com)
 */
@RestController
public class StockController {

	@Autowired
	StockHandler handler;

	/**
	 * This API fetches a list of stocks based on number of stocks per page
	 * 
	 * @param pageable Pageable
	 * @return Page<Stock>
	 */
	@GetMapping(value = "/api/stocks")
	public Page<Stock> fetchPageableStockList(Pageable pageable) {
		return handler.fetchPageableStockList(pageable);
	}

	/**
	 * This API creates new stock
	 */
	@PostMapping(value = "/api/stocks")
	public void createStock() {
		// TODO
	}

	/**
	 * This API fetches single stock from the list of stocks
	 */
	@GetMapping(value = "/api/stocks/1")
	public void fetchSingleStockFromStockList() {
		// TODO
	}

	/**
	 * This API updates price of single stock
	 */
	@PutMapping(value = "/api/stocks/1")
	public void updateSingleStockPrice() {
		// TODO
	}

	/**
	 * This API deletes single stock
	 */
	@DeleteMapping(value = "/api/stocks/1")
	public void deleteSingleStock() {
		// TODO
	}
}
