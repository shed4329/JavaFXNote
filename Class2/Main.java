package Class2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("这是第一个javafx程序");//设置标题
        stage.show();//窗口出现
    }
}
