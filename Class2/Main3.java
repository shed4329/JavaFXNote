package Class2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main3 extends Application{
    public static void main(String[] args) {
        Application.launch(Main2.class,args);//启动方法2，要求Main2继承Application
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
