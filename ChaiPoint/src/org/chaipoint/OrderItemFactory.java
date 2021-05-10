package org.chaipoint;

import org.chaipoint.recipe.Coffee;
import org.chaipoint.recipe.ElaichiTea;
import org.chaipoint.recipe.GingerTea;
import org.chaipoint.recipe.Milk;
import org.chaipoint.recipe.Water;
import org.chaipoint.shared.Menu;

public class OrderItemFactory {

	public OrderItemFactory() {
	}
	
	public OrderItem orderItem( Menu menu ) {
		
		switch( menu ) {
			case GINGER_TEA:
				return new GingerTea();
			case ELAICHI_TEA:
				return new ElaichiTea();
			case COFFEE:
				return new Coffee();
			case MILK:
				return new Milk();
			case WATER:
				return new Water();
			default:
				System.out.println( "Menu item not available.\nPlease selet the correct option" );
				return null;
		}
	}
}

