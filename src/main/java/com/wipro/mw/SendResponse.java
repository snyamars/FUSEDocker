package com.wipro.mw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class SendResponse {
	
	public void processBody(Exchange body) throws JAXBException, FileNotFoundException {
    	
    	
    			String x = body.getIn().toString();
    			//Message msg = body.getIn();
    			body.getOut().setBody(x);
    		
    		
  
    	
    	
    }
}
