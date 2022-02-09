package com.payconiq.stocks.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.payconiq.stocks.entities.Stock;
import com.payconiq.stocks.handler.StockHandler;

/**
 * JUnit Test Cases - StockController.java
 * 
 * @author Chakraborty, Ayan (ayan.avi@gmail.com)
 */
@SpringBootTest
public class TestStockController {

	@InjectMocks
	StockController controller;
	
	@Mock
	StockHandler handler;
	
	@Mock
	Page<Stock> page;
	
	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Success Flow Testing
	 */
	@Test
	@org.junit.Test
	public void fetchPageableStockListTest() {
		Pageable pageable = PageRequest.of(0, 8);
		Mockito.when(this.handler.fetchPageableStockList(pageable)).thenReturn(page);
		Assert.assertNotNull(this.controller.fetchPageableStockList(pageable));
	}
}
