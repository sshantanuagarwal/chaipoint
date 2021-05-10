package org.chaipoint.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.chaipoint.Inventory;
import org.chaipoint.OrderItem;
import org.chaipoint.OrderItemFactory;
import org.chaipoint.exceptions.OrderUnavailableException;
import org.chaipoint.shared.Menu;
import org.junit.jupiter.api.Test;

class CompleteTest {

	@Test
	void test() {
		Inventory inventory = Inventory.getInstance();
		
		OrderItemFactory orderItemFactory = new OrderItemFactory();
		
		int numExceptions = 0;
		for( Menu item : Menu.values() ) {
			OrderItem orderItem = orderItemFactory.orderItem(item);
			orderItem.populateRecipeList();

			System.out.println();
			inventory.displayInventory();
			try {
				orderItem.construct();
			} catch(  OrderUnavailableException e ) {
				e.getStackTrace();
				numExceptions++;
			}
		}
		System.out.println( "Some items asserting" );
		assert numExceptions == 2;
	}

}
