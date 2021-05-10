package org.chaipoint.recipe;

import org.chaipoint.OrderItem;
import org.chaipoint.shared.Items;

public class Coffee extends OrderItem {
	
	public Coffee() {
		populateRecipeList();
	}
	
	public void populateRecipeList() {

		recipeList.put( Items.HOT_WATER, 50 );
		recipeList.put( Items.HOT_MILK, 10 );
		recipeList.put( Items.COFFEE_SYRUP, 10 );
		recipeList.put( Items.SUGAR_SYRUP, 10 );
	}
}
