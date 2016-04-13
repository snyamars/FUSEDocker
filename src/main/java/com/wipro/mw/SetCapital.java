package com.wipro.mw;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.camel.Exchange;

/**
 * Bean that generates and process NewTopic.
 */
public class SetCapital {

	private Random ran = new Random();

	/**
	 * Generates a new topic structured as a {@link Map}
	 */
	public Map<String, Object> setNewCapital(Exchange exchange) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("country", exchange.getIn().getHeader("CamelInfinispanKey"));
		return map;
	}

}