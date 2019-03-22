package org.autodatacorp.orchestration.models.util;

import java.util.List;

import org.apache.camel.Exchange;
import org.autodatacorp.orchestration.models.MSResponse;
import org.autodatacorp.orchestration.models.WSResponse;
import org.autodatacorp.orchestration.models.exception.GeneralException;
import org.autodatacorp.orchestration.models.process.ActivateDebug;
import org.autodatacorp.orchestration.models.process.ActivateSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by nurico on 2017-03-02.
 */
public class ProcessorHelper {
    public static void CheckForSuccessfulResponse(Exchange exchange, String msg) throws GeneralException {
        if (exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, int.class) != 200) {
            exchange.setProperty("hasErrors", true);

            String errorMsg = msg;
            try {
                String extra = exchange.getIn().getBody(String.class);
                MSResponse msResponse = new ObjectMapper().readValue(extra, MSResponse.class);
                errorMsg = msg + " -> " + msResponse.getMessage();
            } catch (Exception e) {
            }

            throw new GeneralException(errorMsg);
        }
    }

    public static void CheckForSuccessfulResponse(Exchange exchange, String response, String msg)
            throws GeneralException {
        if (exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, int.class) != 200) {
            exchange.setProperty("hasErrors", true);

            String errorMsg = msg;
            String errorReason = "";
            try {
                WSResponse<?> msResponse = new ObjectMapper().readValue(response, WSResponse.class);

                errorReason = msResponse.getMessage();
                errorMsg = msg + " -> " + errorReason;
            } catch (Exception e) {
                /** do nothing */
            }

            throw new GeneralException(errorMsg, errorReason);
        }
    }

    public static void routeLog(Exchange exchange, String data) {
        /* changes to implement the debug through header only */
        // if ((exchange.getProperty(ActivateDebug.DEBUG_HEADER) != null &&
        // exchange.getProperty(ActivateDebug.DEBUG_HEADER).equals(ActivateSupport.TRUE))||
        // (exchange.getProperty(ActivateSupport.SUPPORT_HEADER).equals(ActivateSupport.TRUE)))
        // {

        if ((exchange.getProperty(ActivateDebug.DEBUG) != null)
                || (exchange.getProperty(ActivateSupport.SUPPORT) != null)) {
            List<String> debug = (List<String>) exchange.getProperty(ActivateDebug.DEBUG);
            if (exchange.getProperty("CamelToEndpoint") != null) {
                data += " for " + exchange.getProperty("CamelToEndpoint", String.class);
            }
            debug.add(data);
        }
    }

    public static void routeLogSimple(Exchange exchange, String data) {
        /* changes to implement the debug through header only */
        // if ((exchange.getProperty(ActivateDebug.DEBUG_HEADER) != null &&
        // exchange.getProperty(ActivateDebug.DEBUG_HEADER).equals(ActivateSupport.TRUE))||
        // (exchange.getProperty(ActivateSupport.SUPPORT_HEADER).equals(ActivateSupport.TRUE)))
        // {

        if ((exchange.getProperty(ActivateDebug.DEBUG) != null)
                || (exchange.getProperty(ActivateSupport.SUPPORT) != null)) {
            List<String> debug = (List<String>) exchange.getProperty(ActivateDebug.DEBUG);
            debug.add(data);
        }
    }

}
