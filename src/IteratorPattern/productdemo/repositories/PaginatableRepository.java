package IteratorPattern.productdemo.repositories;

import java.util.List;

public interface PaginatableRepository<T> {
    List<T> fetchData(int limit, int offset) throws Exception;
    int totalCount();
}
