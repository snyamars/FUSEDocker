package com.wipro.mw;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class Processor1 implements Processor {
	public void process(Exchange exchange) throws Exception {
		// do something...

		Message msg = exchange.getIn();
		String country = msg.getBody().toString();
		country = country.substring(1, country.length() - 1);
		System.out.println("country name :" + country);
		
		exchange.getIn()
				.setHeader("messageId", exchange.getIn().getMessageId());
		exchange.getIn().setHeader("country", exchange.getIn().getBody());
		exchange.getIn().setHeader("CamelInfinispanKey", country);
		System.out.println("message id" + exchange.getIn().getMessageId());
		System.out.println("processor header set country"
				+ exchange.getIn().getHeader("country"));
	}

}
