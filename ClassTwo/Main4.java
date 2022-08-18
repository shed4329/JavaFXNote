package ClassTwo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application {
    /*
    main()=main
    init()被调用，线程名:JavaFX-Launcher
    start方法被调用，线程名:JavaFX Application Thread(ui线程)
    stop()被调用，线程名:JavaFX Application Thread
     */
    public static void main(String[] args) {
        System.out.println("main()="+Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init()被调用，线程名:"+Thread.currentThread().getName());//顺序：init-start-stop
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //start必须写，init,stop不一定
        System.out.println("start方法被调用，线程名:"+Thread.currentThread().getName());
        stage.show();//要有窗口关闭才会调用stop();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop()被调用，线程名:"+Thread.currentThread().getName());
        start(new Stage());
        super.stop();
    }
}
