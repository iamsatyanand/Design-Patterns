package IteratorPattern.productdemo.iterators;

import IteratorPattern.productdemo.models.Product;
import IteratorPattern.productdemo.repositories.PaginatableRepository;

import java.util.List;

public class PageIterator<T> implements Iterator<List<T>>{

    private final PaginatableRepository<T> repository;
    private  int offset = 0;
    private final int limit;
    private List<T> currentBatch;
    private final int totalItems;

    private final long startTime;
    private final int MAX_RETRIES = 3;

    public PageIterator(PaginatableRepository<T> repository, int limit) {
        this.repository = repository;
        this.limit = limit;
        this.totalItems = repository.totalCount();
        this.startTime = System.currentTimeMillis();
        this.currentBatch = loadWithRetry();
    }

    private synchronized List<T> loadWithRetry(){
        int attempt = 0;
        while(attempt < MAX_RETRIES){
            try {
                return repository.fetchData(limit, offset);
            }
            catch (Exception exception){
                attempt ++;
                System.out.println("Thread "+Thread.currentThread().getName()+ " - Retry "+ attempt);
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException ignored){ }
            }
        }
            return List.of();
    }

    @Override
    public synchronized boolean hasNext() {
        return currentBatch != null && !currentBatch.isEmpty();
    }

    @Override
    public synchronized List<T> next() {
        List<T> result = currentBatch;
        this.offset += limit;
        this.currentBatch = loadWithRetry();
        return result;
    }

    public synchronized void reset(){
        this.offset = 0;
        this.currentBatch = loadWithRetry();
    }

    public synchronized double getProgressPercentage(){
        return Math.min(100.0, (double)offset/totalItems * 100);
    }

    public synchronized String getTimeRemaining() {
        if (offset == 0) return "Calculating...";

        long elapsed = System.currentTimeMillis() - startTime;
        double itemsPerMs = (double) offset / elapsed;
        int remainingItems = totalItems - offset;

        if (remainingItems <= 0) return "0s";

        long remainingMs = (long) (remainingItems / itemsPerMs);
        return (remainingMs / 1000) + "s";
    }
}


