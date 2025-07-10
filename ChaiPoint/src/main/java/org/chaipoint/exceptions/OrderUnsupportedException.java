package org.chaipoint.exceptions;

import org.chaipoint.shared.Messages;

public class OrderUnsupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public String toString(){ 
		return ( Messages.ERROR + "\n" + Messages.MODE ) ;
	}

}
