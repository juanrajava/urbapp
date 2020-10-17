package exceptions;

import io.netty.handler.codec.http.HttpResponseStatus;

public class UnexpectedException extends BackendException {
	public UnexpectedException(String message) {
		super(ErrorCodes.UNEXPECTED_EXCEPTION_CODE.getCode(), ErrorCodes.UNEXPECTED_EXCEPTION_CODE.getStatus(), ErrorCodes.UNEXPECTED_EXCEPTION_CODE.getDescription(), message, HttpResponseStatus.INTERNAL_SERVER_ERROR.code());
	}
}
