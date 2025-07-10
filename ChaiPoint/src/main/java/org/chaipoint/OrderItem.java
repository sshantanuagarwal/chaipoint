package org.chaipoint;
import java.util.HashMap;
import java.util.Map;

import org.chaipoint.exceptions.OrderUnavailableException;
import org.chaipoint.shared.Items;
import org.chaipoint.shared.Messages;

abstract public class OrderItem {

	Inventory inventory;
	protected Map <Items, Integer > recipeList = null;
	
	public OrderItem() {
		this.recipeList = new HashMap<>();
		this.inventory = Inventory.getInstance();
	}	
	
	public abstract void populateRecipeList();
	
	
	private boolean checkInventory() {
		boolean canConstruct = true;
		for( Map.Entry<Items, Integer > entry : recipeList.entrySet() ) {
			Items item = entry.getKey();
			int quantity = entry.getValue();
			boolean isPresent = inventory.isPresent( item, quantity );
			if( !isPresent ) {
				Indicator indicate = new Indicator();
				indicate.indicateInventory( item );
				
				canConstruct = false;
			}	
		}
		return canConstruct;
	}
	
	
	public boolean construct() throws OrderUnavailableException {
		boolean canConstruct = checkInventory();
		if( canConstruct ) {
			for( Map.Entry<Items, Integer > entry : recipeList.entrySet() ) {
				Items item = entry.getKey();
				int quantity = entry.getValue();
				inventory.getItem( item, quantity );
			}
			System.out.println( Messages.ENJOY );
		} else {
			//inventory.displayInventory();
			throw new OrderUnavailableException();
		}
		return canConstruct;
	}
}
