package org.chaipoint;

import java.util.HashMap;
import java.util.Map;

import org.chaipoint.shared.Items;


public class Inventory {
	private static Inventory single_instance = null; 

    public static Inventory getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Inventory(); 
  
        return single_instance; 
    } 
    
	public Map < Items, InventoryInfo > itemData = null;
	
	public Inventory() {	
		itemData = new HashMap <>();
		InventoryInfo info = new InventoryInfo( 100 );

		for( Items i : Items.values() ) {
			itemData.put( i, info );
		}
		
	}
	
    public boolean isPresent( Items i, int quantity ) {
    	return getQuantity( i ) >= quantity;
    }
    
	public boolean getItem( Items i, int quantity ) {
		if( isPresent( i, quantity) ) {
			itemData.put( i, 
				new InventoryInfo( itemData.get( i ).quantity - quantity ) ); 
			return true;
		}
		return false;
	}
 	

	public void refillItem( Items i, int quantity ) {
		itemData.put( i ,
				new InventoryInfo( itemData.get( i ).quantity + quantity ) );
	}
	
	public int getQuantity( Items i ) {
		return itemData.get( i ).quantity;
	}
	
	public void displayInventory( ) {
		for( Items item : Items.values() ) {
			System.out.println( item + " -> " + getQuantity(item));
		}
	}
}