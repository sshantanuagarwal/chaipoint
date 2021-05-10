package org.chaipoint.recipe;

import org.chaipoint.OrderItem;
import org.chaipoint.shared.Items;

public class Water extends OrderItem {
	
	public Water() {
		populateRecipeList();
	}
	public void populateRecipeList() {

		recipeList.put( Items.HOT_WATER, 50 );
	}
}
