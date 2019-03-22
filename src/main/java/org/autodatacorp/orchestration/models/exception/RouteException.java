package org.autodatacorp.orchestration.models.exception;

import java.io.Serializable;

/**
 * Created by nurico on 2016-06-16.
 */
public class RouteException implements Serializable {

    private static final long serialVersionUID = 5138140131892763216L;
    private String routeID;
    private String endpoint;
    private String message;
    private String reason;

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
