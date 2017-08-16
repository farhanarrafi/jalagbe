package com.jalagbe.app.model;

import java.util.Map;

public class JalagbeResponse<T> {
    private T responseModel;
    private int responseCode;
    private Map<String, ?> responseBody;
    private Map<String, ?> responseHeader;
    private String contentType;
    private String responseString;
    

    public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public T getResponseModel() {
        return responseModel;
    }

    public void setResponseModel(T responseModel) {
        this.responseModel = responseModel;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Map<String, ?> getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Map<String, ?> responseBody) {
		this.responseBody = responseBody;
	}

	public Map<String, ?> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Map<String, ?> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
