package Class4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED);//默认
        s1.show();
        Stage s2 = new Stage();
        s2.setTitle("s2");
        //s2.setScene(new Scene(new Group()));//s2设置了布局和s3设置了布局一样
        s2.initStyle(StageStyle.TRANSPARENT);//透明窗口
        s2.show();
        Stage s3 = new Stage();
        s3.setTitle("s3");
        s3.setScene(new Scene(new Group()));
        s3.initStyle(StageStyle.UNDECORATED);//无标题，白色背景，没有装饰，要s3设置场景图才有效，否者和s2效果一样
        s3.show();
        Stage s4 = new Stage();
        s4.setTitle("s4");
        s4.initStyle(StageStyle.UNIFIED);//就是去掉标题栏的颜色吧
        s4.show();
        Stage s5 = new Stage();
        s5.setTitle("s5");
        s5.initStyle(StageStyle.UTILITY);//没有最大最小化按钮
        s5.show();

        Platform.exit();//一键关闭所有窗口和虚拟机
    }
}
