package org.autodatacorp.orchestration.models.process;

import java.util.ArrayList;
import java.util.List;



import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMessage;
import org.autodatacorp.orchestration.models.SupportResponse;
import org.autodatacorp.orchestration.models.exception.GeneralException;



public class ActivateSupport implements Processor {
    public static final String SUPPORT = "support";
    private static final String CTE = "CamelToEndpoint";
	public static final String TRUE = "true";
	public static final String SUPPORT_HEADER = "supportHeader";

 
    public void process(Exchange exchange) {
    	String support= exchange.getIn(HttpMessage.class).getRequest().getHeader(ActivateSupport.SUPPORT);
    	exchange.setProperty(SUPPORT_HEADER, support);
        try {
			if (exchange.getProperty(ActivateSupport.SUPPORT_HEADER) != null
					&& exchange.getProperty(SUPPORT_HEADER).equals(TRUE)) {
                exchange.setProperty(SUPPORT, new ArrayList<SupportResponse>());
                
                      }
        } catch (Exception e) {
            
        }

    }

	// this function targeted for removal as not used in current implementation
	// of support functionality in business services , we are keeping it because
	// we are not sure if it can be use in further implementations in different BS. 
	 public static void routeLog(Exchange exchange, String request, String response) {
    	try {
			if ((exchange.getProperty(ActivateSupport.SUPPORT) != null)) {

				List<SupportResponse> supportList = (List<SupportResponse>) exchange
						.getProperty(ActivateSupport.SUPPORT);
				SupportResponse supportResponse = new SupportResponse();
				String url = null;
				if (exchange.getProperty("CamelToEndpoint") != null) {
					url = exchange.getProperty("CamelToEndpoint", String.class);
					supportResponse.setUrl(url);
				}

				supportResponse.setRequest(request);
				supportResponse.setResponse(response);
				supportList.add(supportResponse);
			}

		} catch (Exception e) {

			throw new GeneralException(e.getMessage());
		}
}
}
