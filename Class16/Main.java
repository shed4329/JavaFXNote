package Class16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefWidth(100);
        anchorPane1.setPrefHeight(100);
        anchorPane1.setStyle("-fx-background-color:#EE6AA7");
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefWidth(100);
        anchorPane2.setPrefHeight(100);
        anchorPane2.setStyle("-fx-background-color:#98FB98");
        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setPrefWidth(100);
        anchorPane3.setPrefHeight(100);
        anchorPane3.setStyle("-fx-background-color:#A0522D");
        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setPrefWidth(100);
        anchorPane4.setPrefHeight(100);
        anchorPane4.setStyle("-fx-background-color:#1E90FF");
        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.setStyle("-fx-background-color:#EEEE00");//当上下左右没有宽高时，中间默认填充窗口

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color:#B23AEE");
        borderPane.setTop(anchorPane1);//getChildren.add()好像无效
        borderPane.setBottom(anchorPane2);//可以套娃达到想要的效果
        borderPane.setLeft(anchorPane3);
        borderPane.setRight(anchorPane4);
        borderPane.setCenter(anchorPane5);
        borderPane.setPadding(new Insets(10));//内边距为10
        BorderPane.setMargin(anchorPane1,new Insets(10));//anchorPane1外边距10
        BorderPane.setAlignment(anchorPane1, Pos.BOTTOM_CENTER);//对齐方式,填充满了区域设置无效


        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
