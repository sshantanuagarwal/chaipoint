package org.chaipoint.test;

import org.chaipoint.Inventory;
import org.chaipoint.InventoryInfo;
import org.chaipoint.OrderItem;
import org.chaipoint.OrderItemFactory;
import org.chaipoint.exceptions.OrderUnavailableException;
import org.chaipoint.shared.Items;
import org.chaipoint.shared.Menu;
import org.junit.jupiter.api.Test;

class NullTest {

	@Test
	void test() throws OrderUnavailableException {
		Inventory inventory = Inventory.getInstance();
		
		InventoryInfo info = new InventoryInfo( 0 );
		for( Items item : Items.values() ) {
			inventory.itemData.put( item, info );
		}
		
		OrderItemFactory orderItemFactory = new OrderItemFactory();
		
		int numExceptions = 0;
		for( Menu item : Menu.values() ) {
			OrderItem orderItem = orderItemFactory.orderItem(item);
			orderItem.populateRecipeList();
			
			try {
				orderItem.construct();
				assert( false );
			} catch(  OrderUnavailableException e ) {
				System.out.println(e);
				numExceptions ++;
			}
		}
		System.out.println( "All items asserting" );
		assert numExceptions == Menu.values().length;
		
	}

}
