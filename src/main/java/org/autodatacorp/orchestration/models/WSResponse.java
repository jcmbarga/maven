package org.autodatacorp.orchestration.models;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.autodatacorp.orchestration.models.swagger.SwaggerDescriptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by nurico on 2016-03-22.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WSResponse<T> implements Serializable, SwaggerDescriptions {

    private static final long serialVersionUID = 7888092442102745984L;

    @ApiModelProperty(value=WS_RESPONSE_ID, example = "ID-LNOC-DVCP-XWS1-autodatacorp-org-47171-1476984449005-0-16")
    private String id;

    @ApiModelProperty(value = WS_DATE_TIME)
    private String serverTime = new Date().toString();

    @ApiModelProperty(value = WS_MESSAGE)
    private String message;

    @ApiModelProperty(value = WS_ERROR)
    private boolean error = false;

    @ApiModelProperty(value = EXECUTION_TIME)
    private Long executionTimeMS;

    @ApiModelProperty(value = WS_DEBUG_INFO)
    private List<String> debug = null;
    
    @ApiModelProperty(value = WS_SUPPORT_INFO)
    private List<SupportResponse> support = null;

	@ApiModelProperty(value = WS_EXECUTION_DETAILS)
    private Map<String, Object> executionDetails = null;
    
    @ApiModelProperty(value = WS_COPYRIGHT)
    private String copyright = "Copyright "+ Year.now().getValue() +" Chrome Data";
    
    @ApiModelProperty(value = WS_RESULT)
    private T result;

    public WSResponse(String id, Date startTime, T result) {
        this.id = id;
        this.executionTimeMS = new Date().getTime() - startTime.getTime();
        this.result = result;
    }

    public WSResponse(String id, Date startTime) {
        this.id = id;
        this.executionTimeMS = new Date().getTime() - startTime.getTime();
    }

    public WSResponse() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<String> getDebug() {
        return debug;
    }

    public void setDebug(List<String> debug) {
        this.debug = debug;
    }

    public List<SupportResponse> getSupport() {
		return support;
	}

	public void setSupport(List<SupportResponse> support) {
		this.support = support;
	}

    public Map<String, Object> getExecutionDetails() {
        return executionDetails;
    }

    public void setExecutionDetails(Map<String, Object> executionDetails) {
        this.executionDetails = executionDetails;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     *
     * We are using a string builder to manually building a JSON representation of this object.
     * Only time we should use be using this method is when working with RAW WS Responses
     * Its simple and faster than using library to do it.
     *
     * @param data contains JSON string which is added as data value of object
     * @return Representation of object as JSON string
     *
     */
    public String createManualJSON(String data) {

        StringBuilder result = new StringBuilder("{");
        result.append("\"id\": \"").append(this.id).append("\",");
        result.append("\"serverTime\": \"").append(this.serverTime).append("\",");
        if (this.message != null){
            result.append("\"message\": \"").append(this.message).append("\",");
        }
        result.append("\"executionTimeMS\": ").append(this.executionTimeMS).append(",");
        result.append("\"executionDetails\": ").append(this.executionDetails).append(",");
        result.append("\"copyright\": \"").append(this.copyright).append("\",");
        result.append("\"result\": ");
        result.append(data);
        result.append("}");
        
        return result.toString();
    }
}
