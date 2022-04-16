package com.jiker.service.infrastructure.exception;


public abstract class NestedRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 200010000L;

	
	public NestedRuntimeException(){
		super();
	}


	public NestedRuntimeException(String msg) {
		super(msg);
	}

	public NestedRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	@Override
	public String getMessage() {
		return buildMessage(super.getMessage(), getCause());
	}
	
	protected String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			StringBuilder sb = new StringBuilder();
			if (message != null) {
				sb.append(message).append("; ");
			}
			sb.append("exception is ").append(cause);
			return sb.toString();
		}
		else {
			return message;
		}
	}

	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof NestedRuntimeException) {
			return ((NestedRuntimeException) cause).contains(exType);
		}
		else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}
}
