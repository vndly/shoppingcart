package com.mauriciotogneri.shoppinglist.activities;

import android.content.Intent;
import android.widget.Toast;

import com.mauriciotogneri.shoppinglist.base.BaseActivity;
import com.mauriciotogneri.shoppinglist.model.Product;
import com.mauriciotogneri.shoppinglist.model.Products;
import com.mauriciotogneri.shoppinglist.utils.Analytics;
import com.mauriciotogneri.shoppinglist.views.CartView;
import com.mauriciotogneri.shoppinglist.views.CartView.CartViewObserver;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends BaseActivity<CartView> implements CartViewObserver
{
    @Override
    protected void initialize()
    {
        Analytics analytics = new Analytics(this);
        analytics.appLaunched();

        List<Product> products = new ArrayList<>();
        products.add(Products.Beer);
        products.add(Products.Coffee);
        products.add(Products.IceTea);
        products.add(Products.Soda);
        products.add(Products.Water);
        view.updateList(products);
    }

    @Override
    public void onProduceSelected(Product product)
    {
        product.toggleSelection();
        view.updateList();
    }

    @Override
    public void onShare()
    {
        Toast.makeText(this, "SHARE", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddProduct()
    {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    @Override
    protected CartView view()
    {
        return new CartView(this);
    }
}