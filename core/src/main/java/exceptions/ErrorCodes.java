package exceptions;

public enum ErrorCodes {
	BAD_GATEWAY_EXCEPTION_CODE("0016", "BAD_GATEWAY", "Bad Gateway"),
	BAD_REQUEST_EXCEPTION_CODE("0015", "BAD_REQUEST", "Bad Request"),
	CONFLICT_EXCEPTION_CODE("0014", "CONFLICT", "Conflict"),
	INTERNAL_SERVER_ERROR_CODE("0013", "INTERNAL_SERVER_ERROR", "Internal Server Error"),
	MEDIA_TYPE_EXCEPTION_CODE("0012", "UNSUPPORTED_MEDIA_TYPE", "Unsupported Media Type"),
	METHOD_NOT_ALLOWED_EXCEPTION_CODE("0011", "METHOD_NOT_ALLOWED", "Method Not Allowed"),
	FORBIDDEN_EXCEPTION_CODE("0010", "FORBIDDEN", "Forbidden"),
	RANGE_NOT_SATISFIABLE_EXCEPTION_CODE("0009", "REQUESTED_RANGE_NOT_SATISFIABLE", "Requested range not satisfiable"),
	SERVICE_DOWN_EXCEPTION_CODE("0008", "SERVICE_UNAVAILABLE", "Service Unavailable"),
	REQUEST_TIMEOUT_EXCEPTION_CODE("0007", "REQUEST_TIMEOUT", "Request Timeout"),
	RATE_LIMIT_EXCEEDED_EXCEPTION_CODE("0006", "RATE_LIMIT_EXCEEDED", "rate limit exceeded"),
	PRECONDITION_FAILED_EXCEPTION_CODE("0005", "PRECONDITION_FAILED", "Precondition Failed"),
	NOT_ACCEPTABLE_EXCEPTION_CODE("0004", "NOT_ACCEPTABLE", "Not Acceptable"),
	UNAUTHORIZED_EXCEPTION_CODE("0003", "UNAUTHORIZED", "Unauthorized"),
	UNEXPECTED_EXCEPTION_CODE("0002", "UNEXPECTED", "Unexpected error"),
	RESOURCE_NOT_FOUND("0001", "NOT_FOUND", "Resource Not Found");

	private final String code;
	private final String status;
	private final String description;

	private ErrorCodes(String code, String status, String description) {
		this.code = code;
		this.status = status;
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public String getDescription() {
		return this.description;
	}

	public String getCode() {
		return this.code;
	}
}
