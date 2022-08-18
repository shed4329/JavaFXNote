package Class3;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Stage primaryStage = new Stage();
        //primaryStage.show();可以自己new个窗口出来
        stage.getIcons().add(new Image("ClassThree\\icon\\icon.png"));
        //stage.setIconified(true);//设置最小化
        //stage.setMaximized(true);//设置最大化
        stage.setWidth(500);//设置宽度
        stage.setHeight(500);//设置高度
        //stage.setResizable(false);//设置无法调节窗口大小
        stage.setMaxWidth(800);//设置最大宽度
        stage.setMaxHeight(800);//设置最大高度
        stage.setMinWidth(300);//设置最小宽度
        stage.setMinHeight(300);//设置最小高度
        stage.setTitle("JavaFX");//设置标题
        //stage.setFullScreen(true);//设置全屏，必须先设置场景图，按Esc退出全屏
        stage.setScene(new Scene(new Group()));//设置场景图
        stage.show();//窗口显示
        System.out.println("窗口宽度="+stage.getWidth());//如果没有设定宽高，要在show()后面写
        System.out.println("窗口宽度="+stage.getHeight());
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("当前宽度="+t1);//t1:new value
            }
        });//宽度监听
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("当前高度="+t1);//t1:new value
            }//可以做自动适应，其实用绑定好点
        });//高度监听
        //stage.close();//关闭窗口
    }
}
