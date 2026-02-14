package IteratorPattern.productdemo.repositories;


import IteratorPattern.productdemo.core.InMemoryDatabase;
import IteratorPattern.productdemo.models.Product;

import java.util.List;

public class ProductRepository implements PaginatableRepository<Product>{

    private final InMemoryDatabase db;

    public ProductRepository(InMemoryDatabase db){
        this.db = db;
    }

    @Override
    public List<Product> fetchData(int limit, int offset) throws Exception {
        return db.getProducts(offset, limit);
    }

    @Override
    public int totalCount() {
        return db.getCount();
    }
}
