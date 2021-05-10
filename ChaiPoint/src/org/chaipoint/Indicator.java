package org.chaipoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.chaipoint.shared.Items;
import org.chaipoint.shared.Messages;


public class Indicator {

	Inventory inventory;
	List <Items > needRefillItems;
	
	
	public Indicator() {
		this.inventory = Inventory.getInstance();
		needRefillItems = new ArrayList<>();
	}
	
	public void indicateInventory( Items item ) {
		needRefillItems.add( item );
		//System.out.println( item );
	}
	
	public void doYouWantToRefill() {
		for( Items item : needRefillItems ) {

			System.out.println( Messages.REFILL + item );
			System.out.println( Messages.REFILL_QUERY );
			System.out.println( Messages.YES_OR_NO );
			Scanner scanner = new Scanner( System.in );
			String yesOrNo = scanner.next();
			
			if( yesOrNo.equalsIgnoreCase( Messages.YES ) ||
				yesOrNo.equalsIgnoreCase( Messages.Y ) ) {
				System.out.println( Messages.REFILL_AMOUNT );
				int quantity = scanner.nextInt();
				inventory.refillItem( item, quantity );
			}
			
			scanner.close();
		}
	}
}
