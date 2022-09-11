package Class13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#585eaa");

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setStyle("-fx-background-color:#a3cf62");
        anchorPane2.getChildren().add(button1);
        AnchorPane.setRightAnchor(button1,0.0);
        AnchorPane.setBottomAnchor(button1,0.0);
        //button1.setManaged(false);//失去管理
        //button1.setVisible(false);//设置不可见
        //button1.setOpacity(1);//设置透明度
        anchorPane.getChildren().add(anchorPane2);

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();

        AnchorPane.setTopAnchor(anchorPane2,0.0);
        AnchorPane.setLeftAnchor(anchorPane2,0.0);
        AnchorPane.setRightAnchor(anchorPane2,anchorPane.getWidth()/2);//show后anchorPane才有宽高
        AnchorPane.setBottomAnchor(anchorPane2,anchorPane.getHeight()/2);
        //设置宽高始终为一半
        anchorPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                AnchorPane.setBottomAnchor(anchorPane2,anchorPane.getHeight()/2);
            }
        });
        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                AnchorPane.setRightAnchor(anchorPane2,anchorPane.getWidth()/2);//show后anchorPane才有宽高
            }
        });
        //为什么不监听窗口
        //因为窗口还要算边框，标题栏等
    }
}
