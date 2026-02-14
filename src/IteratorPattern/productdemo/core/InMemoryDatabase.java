package IteratorPattern.productdemo.core;

import IteratorPattern.productdemo.models.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {

    private final List<Product> products = new ArrayList<>();

    public InMemoryDatabase(){
        seeder();
    }

    public void seeder(){
        for(int i=1; i<200; i++){
            products.add(new Product(i, "Product "+i, Math.random() * 100));
        }
    }

    public List<Product> getProducts(int offset, int limit) throws Exception {
        if(Math.random() < 0.1) throw new Exception("Database timeout");

        if(offset >= products.size()) return List.of();

        return products.subList(offset, Math.min(offset + limit, products.size()));
    }

    public int getCount(){
        return products.size();
    }
}
