package org.chaipoint;

import java.util.Scanner;

import org.chaipoint.exceptions.OrderUnavailableException;
import org.chaipoint.exceptions.OrderUnsupportedException;

public class ParallelOrderExec {

	public ParallelOrderExec( Scanner scanner ) {
		Order order = Order.getInstance();
		Thread object = new Thread() {

			public void run() {
				boolean processed = false;
				while( !processed ) {
					try {
						order.getOrder( scanner);
						processed = true;
					} catch (OrderUnsupportedException e) {
						System.out.println( e );
						processed = false;
					} catch (OrderUnavailableException e) {
						System.out.println( e );

						processed = true;
					}
				}
			};
		};
		object.start();

	}
}
