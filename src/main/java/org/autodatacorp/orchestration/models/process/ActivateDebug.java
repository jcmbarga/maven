package org.autodatacorp.orchestration.models.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
//import org.apache.camel.http.common.HttpMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nurico on 2016-04-06.
 */
public class ActivateDebug implements Processor {
    public static final String DEBUG = "debug";
    private static final String CTE = "CamelToEndpoint";
	//public static final String DEBUG_HEADER = "debugHeader";
    
	public void process(Exchange exchange) {

		/* changes to implement debug through header only */
		/*
		 * String debug =
		 * exchange.getIn(HttpMessage.class).getRequest().getHeader(DEBUG);
		 * exchange.setProperty(DEBUG_HEADER, debug);
		 */
		try {
			// if ((exchange.getProperty(DEBUG_HEADER) != null &&
			// exchange.getProperty(DEBUG_HEADER).equals(ActivateSupport.TRUE))
			// ||
			// (exchange.getProperty(ActivateSupport.SUPPORT_HEADER).equals(ActivateSupport.TRUE)))
			// {

			if ((exchange.getIn().getHeader("debug", boolean.class) == true)
					|| (exchange.getProperty(ActivateSupport.SUPPORT) != null)) {
				exchange.setProperty("debug", new ArrayList<String>());
			}
		} catch (Exception e) {
		}
	}

	public static void routeLog(Exchange exchange, String data) {
		try {
			// if ((exchange.getProperty(DEBUG_HEADER) != null &&
			// exchange.getProperty(DEBUG_HEADER).equals(ActivateSupport.TRUE))||
			// (exchange.getProperty(ActivateSupport.SUPPORT_HEADER).equals(ActivateSupport.TRUE)))
			// {

			if ((exchange.getProperty(DEBUG) != null)
					|| (exchange.getProperty(ActivateSupport.SUPPORT) != null)) {
				List<String> debug = (List<String>) exchange.getProperty(DEBUG);
				if (exchange.getProperty(CTE) != null) {
					data += " for " + exchange.getProperty(CTE, String.class);
				}
				debug.add(data);
			}
		} catch (Exception e) {
		}
	}

	public static void routeLogSimple(Exchange exchange, String data) {
		try {
				// if ((exchange.getProperty(DEBUG_HEADER) != null &&
				// exchange.getProperty(DEBUG_HEADER).equals(ActivateSupport.TRUE))||
				// (exchange.getProperty(ActivateSupport.SUPPORT_HEADER).equals(ActivateSupport.TRUE)))
				// {

			if ((exchange.getProperty(DEBUG) != null)
					|| (exchange.getProperty(ActivateSupport.SUPPORT )!=null)) {
				List<String> debug = (List<String>) exchange.getProperty(DEBUG);
				debug.add(data);
			}
		} catch (Exception e) {
		}
	}
}
 