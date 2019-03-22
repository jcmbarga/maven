package org.autodatacorp.orchestration.models.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.autodatacorp.orchestration.models.SupportResponse;
import org.autodatacorp.orchestration.models.exception.GeneralException;
import org.autodatacorp.orchestration.models.process.ActivateSupport;

import java.util.List;

/**
 * Created by nurico on 2017-03-02.
 */
public class SupportHelper {
	
	
	private static final String TRUE = "true";
	private static ObjectMapper objectMapper;

	public static void routeLog(Exchange exchange, Object request, Object response) {
		try {
			if (exchange.getProperty(ActivateSupport.SUPPORT) != null) {

				List<SupportResponse> supportList = (List<SupportResponse>) exchange
						.getProperty(ActivateSupport.SUPPORT);
				SupportResponse supportResponse = new SupportResponse();
				Map nameValues = new HashMap();
				String url = null;
				if (exchange.getProperty("CamelToEndpoint") != null) {
					url = exchange.getProperty("CamelToEndpoint", String.class);
					supportResponse.setUrl(url);
				}

				supportResponse.setRequest(request);
				supportResponse.setResponse(response);
				supportResponse.setAdditional(nameValues);
				supportList.add(supportResponse);
			}

		} catch (Exception e) {

			throw new GeneralException(e.getMessage());
		}
	}

	public static void routeLogAdditional(Exchange exchange, Object name, Object value) {
		try {
			if (exchange.getProperty(ActivateSupport.SUPPORT) != null) {

				List<SupportResponse> supportList = (List<SupportResponse>) exchange
						.getProperty(ActivateSupport.SUPPORT);
				supportList.get(supportList.size() - 1).getAdditional().put(name, value);
			}
		} catch (Exception e) {

			throw new GeneralException(e.getMessage());
		}
	}
}
