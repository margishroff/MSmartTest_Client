package com.sjsu.Exceptions;

import java.io.Serializable;

public class ServiceUnavailableException extends Exception implements Serializable 
{
	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException() 
	{
	}

	public String toString()
	{
		return "Service is currently unavailable.Please try again later.";
	}
}
