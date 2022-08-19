package Class9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button();

        b1.setText("这是按钮");
        b1.setLayoutX(100);
        b1.setLayoutY(100);
        b1.setPrefWidth(400);
        b1.setPrefHeight(200);
        b1.setFont(Font.font("sans-serif",40));//设置字体

        /*以下方法有点复杂，已被CSS替代
        BackgroundFill backgroundFill = new BackgroundFill(Paint.valueOf("#8FBC8F"),new CornerRadii(20),new Insets(10,5,20,5));//外边距，可分别指定,Insert.Empty为无边距
        Background background = new Background(backgroundFill);
        b1.setBackground(background);

        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#8A2BE2"),BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10));//颜色，样式，圆角，粗细
        // *BorderStrokeStyle.SOLID;//实线
        //BorderStrokeStyle.DASHED;//虚线
        //BorderStrokeStyle.DOTTED;//点

        Border border = new Border(borderStroke);
        b1.setBorder(border);
        b1.setTextFill(Paint.valueOf("#CD0000"));//设置字体颜色
        //颜色是支持RGBA的，透明度
         */
        b1.setStyle(//fx的css
                "-fx-background-color:#7CCD7C;"+
                "-fx-background-radius:20;"+
                "-fx-text-fill:#5CACEE"
        );//style只有最后设置的一次有效,多行拼接时记得打分号
        /*常用的FXStyle
        button1.setStyle(
                "-fx-background-color: #1169EE20;"+ 背景颜色
                "-fx-text-fill: #50ff23;"+ 文本颜色
                "-fx-border-color: #EE1169;"+ 边框颜色
                "-fx-border-radius: 5;"+ 边框圆角
                "-fx-background-radius: 5;"+ 背景圆角
                "-fx-background-insets: 0;"+ 边框到背景的距离
                "-fx-font-size: 15;"+ 字体大小
                "-fx-font-family: 'Segoe Print';"+ 字体
                "-fx-border-style: dotted;"+ 边框样式
                "-fx-border-width: 2;" 边框宽度
        );
         */
        b1.setOnAction(new EventHandler<ActionEvent>() {//b1的单击事件
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button)actionEvent.getSource();//获得事件源（b1），强制转换为button
                System.out.println(button.getText());
                System.out.println("114514");
            }
        });
        Group root = new Group();
        root.getChildren().addAll(b1);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
    }
}
