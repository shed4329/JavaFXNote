package Class4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setOpacity(0.5);//设置透明度，0=完全透明，1=完全不透明，也可以设置0.8888888（狗头）
        stage.setAlwaysOnTop(true);//窗口置顶
        stage.setX(20);
        stage.setY(20);//离屏幕左上角位置
        stage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("窗口x坐标="+t1);//窗口的左上角来算
            }
        });
        stage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("窗口y坐标"+t1);
            }
        });

        stage.show();
    }
}
