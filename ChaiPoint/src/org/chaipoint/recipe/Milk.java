package org.chaipoint.recipe;

import org.chaipoint.OrderItem;
import org.chaipoint.shared.Items;

public class Milk extends OrderItem {
	
	public Milk() {
		populateRecipeList();
	}
	
	public void populateRecipeList() {
		recipeList.put( Items.HOT_MILK, 50 );
	}
}
