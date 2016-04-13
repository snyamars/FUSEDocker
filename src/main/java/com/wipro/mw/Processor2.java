package com.wipro.mw;

import java.util.ArrayList;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class Processor2 implements Processor {
	public void process(Exchange exchange) throws Exception {

		Message msg = exchange.getIn();
		ArrayList<Map<String, String>> xx = new ArrayList<Map<String, String>>();
		xx = (ArrayList<Map<String, String>>) msg.getBody();
		
		String capital = xx.get(0).get("capital");
		exchange.getIn().setBody(capital);
		exchange.getIn().setHeader("sessionMessageId", exchange.getIn().getMessageId().substring(exchange.getIn().getMessageId().length()-2));
		exchange.getIn().setHeader("CamelInfinispanOperation", "CamelInfinispanOperationPut");
		exchange.getIn().setHeader("CamelInfinispanValue", capital);
		
		System.out.println("MESSAGE_ID"+exchange.getIn().getMessageId());
		System.out.println("CamelInfinispanOperation"+exchange.getIn().getHeader("CamelInfinispanOperation"));
		System.out.println("CamelInfinispanValue"+exchange.getIn().getHeader("CamelInfinispanValue"));
		System.out.println("CamelInfinispanKey"+exchange.getIn().getHeader("CamelInfinispanKey"));
		System.out.println("sessionMessageId"+exchange.getIn().getMessageId().substring(exchange.getIn().getMessageId().length()-2));
	
	}

}
