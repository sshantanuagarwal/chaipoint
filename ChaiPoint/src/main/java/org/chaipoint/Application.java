package org.chaipoint;

import java.util.Scanner;

import org.chaipoint.exceptions.OrderUnsupportedException;
import org.chaipoint.shared.Items;
import org.chaipoint.shared.Messages;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws OrderUnsupportedException {
		Scanner scanner =  new Scanner(System.in);
		System.out.println( Messages.MODE );
		boolean validMode = false;
		while( !validMode ) {
			int mode = scanner.nextInt(); 
			if( mode == 1 ) {
				// Admin Mode
				Inventory inventory =  Inventory.getInstance();
				inventory.displayInventory();
	
				System.out.println( Messages.NUM_REFILLS );
				int n = scanner.nextInt();
				while( n-- > 0 ) {
					System.out.println( n + ") " + Messages.ENTER_ITEM_NUMBER );
					Items item = Items.values()[ scanner.nextInt() - 1 ];
					System.out.println( Messages.ENTER_QUANTITY );
					int quantity = scanner.nextInt();
	
					inventory.refillItem(item, quantity);
				}
	
				inventory.displayInventory();
				
				validMode = true;
			} else if( mode == 2 ) {
				// User mode
				System.out.println( Messages.NUM_ORDERS );
				int numOrders = scanner.nextInt();
	
				System.out.println( Messages.NUM_PARALLEL_ORDERS );
				int numParallelOrder = scanner.nextInt();
	
				while( true ) {
					for( int i = 0; i < numParallelOrder && i < numOrders; i++ ) {
						new ParallelOrderExec( scanner );
					}
					if( numOrders < numParallelOrder )
						break;
					else
						numOrders -= numParallelOrder;
				}
				validMode = true;
			} else {
				// Invalid Mode
				try {
					throw new OrderUnsupportedException();
				} catch ( OrderUnsupportedException ex ) {
					System.out.println( ex.toString());
				}
				
			}
		}
		System.out.println( Messages.END );
	}
}
