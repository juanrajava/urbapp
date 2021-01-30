package com.urbapp.core.exceptions;

import com.urbapp.core.domain.ErrorDto;

public class BackendException extends RuntimeException {
	private static final long serialVersionUID = 3693361283689960190L;
	private ErrorDto errorDto;
	private int httpCode;

	protected BackendException(String code, String status, String msg, String detailMsg, int httpCode) {
		super(detailMsg);
		this.errorDto = new ErrorDto(code, status, msg, detailMsg);
		this.httpCode = httpCode;
	}

	public ErrorDto getErrorDto() {
		return this.errorDto;
	}

	public void setErrorDto(ErrorDto errorDto) {
		this.errorDto = errorDto;
	}

	public int getHttpCode() {
		return this.httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
}
