
package org.chaipoint;

public class InventoryInfo {
	int quantity;
	int cost;
	
	public InventoryInfo( int q ) {
		this.quantity = q;
	}
	
	public InventoryInfo( int q, int c ) {
		this.quantity = q;
		this.cost = c;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
