package org.chaipoint.exceptions;

import org.chaipoint.shared.Messages;

public class OrderUnavailableException extends Exception  {

	private static final long serialVersionUID = 2L;

	public String toString() { 
		return ( Messages.ERROR + "\n" + Messages.UNAVAILABLE ) ;
	}

}
