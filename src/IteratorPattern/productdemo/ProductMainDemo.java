package IteratorPattern.productdemo;

import IteratorPattern.productdemo.core.InMemoryDatabase;
import IteratorPattern.productdemo.iterators.PageIterator;
import IteratorPattern.productdemo.models.Product;
import IteratorPattern.productdemo.repositories.PaginatableRepository;
import IteratorPattern.productdemo.repositories.ProductRepository;

import java.util.List;

public class ProductMainDemo {
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        ProductRepository productRepo = new ProductRepository(db);

        PageIterator<Product> iterator = new PageIterator<>(productRepo, 10);

        Runnable task = () -> {
            while(iterator.hasNext()){
                List<Product> batch = iterator.next();
                // Print detailed status
                System.out.printf("[%s] Progress: %.1f%% | ETR: %s | Batch Size: %d\n",
                        Thread.currentThread().getName(),
                        iterator.getProgressPercentage(),
                        iterator.getTimeRemaining(),
                        batch.size()
                );

                // This loop prints every single product inside that batch
                for (Product p : batch) {
                    System.out.printf("   [%s] Processing -> ID: %d | Name: %s\n",
                            Thread.currentThread().getName(), p.id(), p.name());
                }

                try { Thread.sleep(300); } catch (InterruptedException e) {}
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        t1.start();
        t2.start();
    }
}


//
//When a worker calls iterator.next(), they "step into the truck." Because of the synchronized keyword, only one worker can be in the truck at a time. This prevents them from grabbing the same box (product).
//
//Worker-1 grabs Products 1–10.
//
//Worker-2 waits for 1 millisecond.
//
//        Worker-1 steps out.
//
//Worker-2 steps in and grabs Products 11–20.