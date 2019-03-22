package org.autodatacorp.orchestration.models.miscellaneous.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by nurico on 2016-03-22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthStatus implements Serializable {
    private static final long serialVersionUID = -3135303552422728469L;
    private String id;
    private String description;
    private String upTime;
    private String endpointUri;

    public HealthStatus() {
    }

    public HealthStatus(String id, String description, String upTime, String endpointUri) {
        this.id = id;
        this.description = description;
        this.upTime = upTime;
        this.endpointUri = endpointUri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getEndpointUri() {
        return endpointUri;
    }

    public void setEndpointUri(String endpointUri) {
        this.endpointUri = endpointUri;
    }
}
