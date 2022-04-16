package com.jiker.service.infrastructure.exception;

public class ServiceException extends NestedRuntimeException{
	
	private String serviceMsg;
	
	public ServiceException() {
        super();
    }

	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(String msg,String serviceMsg) {
		super(msg);
		this.serviceMsg = serviceMsg;
	}

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public String getServiceMsg() {
		return serviceMsg;
	}

	public void setServiceMsg(String serviceMsg) {
		this.serviceMsg = serviceMsg;
	}
}
