package org.autodatacorp.orchestration.models;

import java.util.Map;

public class SupportResponse {

	private String url;
	private Object request;
	private Object response;
	private Map additional;

	public SupportResponse() {
		//default Constructor
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Map getAdditional() {
		return additional;
	}

	public void setAdditional(Map additional) {
		this.additional = additional;
	}

}
