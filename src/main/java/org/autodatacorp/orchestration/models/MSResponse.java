package org.autodatacorp.orchestration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nurico on 2016-10-25.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MSResponse<T> implements Serializable {

    private static final long serialVersionUID = 2667045704417529414L;

    private Date serverTime;
    private String serverTimeString ;
    private String serverName ;
    private String message;
    private Long executionTimeMS;
    private T result;

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public String getServerTimeString() {
        return serverTimeString;
    }

    public void setServerTimeString(String serverTimeString) {
        this.serverTimeString = serverTimeString;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getExecutionTimeMS() {
        return executionTimeMS;
    }

    public void setExecutionTimeMS(Long executionTimeMS) {
        this.executionTimeMS = executionTimeMS;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
