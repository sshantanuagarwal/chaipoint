package org.chaipoint.exceptions;

import org.chaipoint.shared.Messages;

public class ModeUnsupportedException extends Exception {

	private static final long serialVersionUID = 3L;

	public String toString() { 
		return ( Messages.ERROR + "\n" + Messages.MODE ) ;
	}
}
