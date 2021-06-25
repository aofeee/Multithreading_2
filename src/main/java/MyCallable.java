import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    int num;
    String name;

    public MyCallable(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= num; i++) {
            System.out.println("Сообщение номер " + i + " задачи с именем " + name);
            Thread.sleep(1500);
        }
        System.out.println("Задача " + name + " вывела все свои сообщения!");
        return num;
    }
}