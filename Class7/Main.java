package Class7;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //小知识2 打开网站
        HostServices hostServices = getHostServices();
        hostServices.showDocument("https://www.baidu.com");
        Button button = new Button("Button");
        button.setCursor(Cursor.E_RESIZE);
        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);//传null值报错,控件跟随面板大小变换，自己设置不管用
        //小知识1设置鼠标
        //scene.setCursor(Cursor.WAIT);//设置鼠标
        URL url = getClass().getClassLoader().getResource("Class7\\icon\\icon.png");
        String path = url.toExternalForm();
        scene.setCursor(Cursor.cursor(path));
        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.setHeight(800);
        stage.setWidth(800);
        stage.show();
    }
}
