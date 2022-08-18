package Class5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名字"+Thread.currentThread().getName());//其他线程可以用这个更新组件，因为fx有线程安全，所以只能在ui线程内更新
                int i=1;
                while (i<=10){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("i="+i);
                    i++;
                }
            }
        });
        System.out.println("114514");//比runLater先
    }
}
