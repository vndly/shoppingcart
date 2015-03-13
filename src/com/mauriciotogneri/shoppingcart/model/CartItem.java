package com.mauriciotogneri.shoppingcart.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public class CartItem extends Model
{
	@Column(name = "product")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "selected")
	private boolean selected;
	
	public CartItem()
	{
	}
	
	public CartItem(Product product, int quantity, boolean selected)
	{
		this.product = product;
		this.quantity = quantity;
		this.selected = selected;
	}
	
	public String getName()
	{
		return this.product.getName();
	}
	
	public byte[] getImage()
	{
		return this.product.getImage();
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public boolean isSelected()
	{
		return this.selected;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	public void invertSelection()
	{
		this.selected = !this.selected;
	}
}