package com.payconiq.stocks.handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.payconiq.stocks.entities.Stock;
import com.payconiq.stocks.repository.StockDao;

/**
 * JUnit Test Cases - StockHandler.java
 * 
 * @author Chakraborty, Ayan (ayan.avi@gmail.com)
 */
@SpringBootTest
public class TestStockHandler {
	
	@InjectMocks
	StockHandler handler;
	
	@Mock
	StockDao dao;
	
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
		Mockito.when(dao.findAll(pageable)).thenReturn(page);
		Assert.assertNotNull(this.handler.fetchPageableStockList(pageable));
	}
	
	/**
	 * Exception Flow Testing
	 */
	@org.junit.Test(expected = DataAccessResourceFailureException.class)
	public void fetchPageableStockListExceptionTest() {
		Pageable pageable = PageRequest.of(0, 8);
		Mockito.when(dao.findAll(pageable)).thenThrow(NullPointerException.class);
		Assert.assertNotNull(this.handler.fetchPageableStockList(pageable));
	}

}
