package cz.karan.jba.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cz.karan.jba.entity.Item;
import cz.karan.jba.exception.RssException;

public class RssServiceTest {

	private RssService rssService;
	
	@Before
	public void setUp() throws Exception {
		rssService= new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems("http://feeds.feedburner.com/javavids?format=xml");
		assertEquals(10, items.size());
		Item firstitem= items.get(0);
		assertEquals("How to solve Source not found error during debug in Eclipse",firstitem.getTitle());
	}
		


	
}
