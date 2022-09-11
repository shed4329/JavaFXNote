package Class14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("button1");//组件设置x,y无效
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        HBox hBox = new HBox();//水平布局（hBox），垂直布局（vBox），一模一样，略，VBox vBox = new VBox();
        hBox.setStyle("-fx-background-color:#E066FF");
        hBox.setPadding(new Insets(10));//设置内边距
        hBox.setSpacing(10);//控件距离
        HBox.setMargin(button1,new Insets(10));//组件外边距
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPrefWidth(400);
        hBox.setPrefHeight(400);
        hBox.getChildren().addAll(button1,button2,button3);

        AnchorPane anchorPane = new AnchorPane(hBox);
        anchorPane.setStyle("-fx-background-color:#AEEEEE");
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
