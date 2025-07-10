package org.chaipoint;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.chaipoint.exceptions.OrderUnavailableException;
import org.chaipoint.exceptions.OrderUnsupportedException;
import org.chaipoint.shared.Menu;
import org.chaipoint.shared.Messages;

public class Order {

	private static Order single_instance = null; 

    public static Order getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Order(); 
  
        return single_instance; 
    } 
    
	Queue<Menu> q;
	OrderItemFactory  orderItemFactory;

	public Order() {
		q = new LinkedList<Menu> ();
		orderItemFactory = new OrderItemFactory();
	}

	public synchronized void getOrder( Scanner scanner ) throws OrderUnsupportedException, OrderUnavailableException {
		System.out.println();
		System.out.println( Messages.WELCOME );
		System.out.println( Messages.OFFER );
		int count = 1;
		for( Menu m : Menu.values() ) {
			System.out.println( count++ + ") " + m );
		}
		int numMenuItems = Menu.values().length;
		
		System.out.println( Messages.PREFERENCE );
		System.out.println( Messages.ENTER_NUMBER );	
		
		int a = scanner.nextInt();
		if( a > 0 && a <= numMenuItems ) {
			Menu item = Menu.values()[ a - 1];
			
			OrderItem orderItem = orderItemFactory.orderItem( item );
			System.out.println();
			System.out.println( Messages.PREPARING + item );
			orderItem.populateRecipeList();
			orderItem.construct();
			System.out.println( Messages.VISIT_AGAIN );
		} else {
			throw new OrderUnsupportedException();
		}

	}

}
