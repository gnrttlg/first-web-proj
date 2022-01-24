package com.tc.web01.service.exception;

public class ServiceException extends Exception{
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
