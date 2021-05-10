package org.chaipoint.recipe;

import org.chaipoint.OrderItem;
import org.chaipoint.shared.Items;

public class GingerTea extends OrderItem {
	
	public GingerTea() {
		populateRecipeList();
	}
	
	public void populateRecipeList() {
		recipeList.put( Items.HOT_WATER, 50 );
		recipeList.put( Items.HOT_MILK, 10 );
		recipeList.put( Items.TEA_LEAVES, 10 );
		recipeList.put( Items.GINGER_SYRUP, 5 );
		recipeList.put( Items.SUGAR_SYRUP, 10 );
	}
}
