import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {



        MyCallable callable1 = new MyCallable(5);
        callable1.setName("Погрузка");

        MyCallable callable2 = new MyCallable(6);
        callable2.setName("Отправка");

        MyCallable callable3 = new MyCallable(3);
        callable3.setName("Вывоз");

        MyCallable callable4 = new MyCallable(8);
        callable4.setName("Приемка");


        Collection<MyCallable> collection = new ArrayList<>();

        collection.add(callable1);
        collection.add(callable2);
        collection.add(callable3);
        collection.add(callable4);


        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            int result = threadPool.invokeAny(collection);
            System.out.println("Номер самого быстрого: " + result);
            threadPool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}