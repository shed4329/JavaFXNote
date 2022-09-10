package Class12;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //输入框
        TextField textField = new TextField();
        //注：textField的setOnAction是回车时触发的，不是单击文本框
        //textField.setText("这是文本");
        textField.setPrefWidth(100);
        textField.setPrefHeight(100);//宽高
        textField.setFont(Font.font(14));//设置字体
        //css略
        //组件提示，小使用技巧，这其实是一个窗口
        Tooltip tooltip = new Tooltip("文本框提示");
        tooltip.setFont(Font.font(40));//老年化字体
        textField.setTooltip(tooltip);//node都有

        textField.setPromptText("请输入七个字以下的字符");//相当于placeholder，一行灰色的小字，点上去就没了
        textField.setFocusTraversable(false);//取消焦点

        //密码框,和文本框大概相同
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(300);
        passwordField.setLayoutY(100);

        Label label = new Label("我是标签");
        label.setTextFill(Paint.valueOf("red"));
        Group group = new Group();
        group.getChildren().addAll(textField,passwordField,label);//可以分三次add
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        Scene scene =  new Scene(group);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
        //输入监听，限制七个字以下,很实用
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {//s = old value,t1=new value
                if (t1.length() > 7){
                    textField.setText(s);
                }
            }
        });
        //获取选中的文字
        textField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //s= old value,t1=new value
                System.out.println(t1);
            }
        });
        //注：textField的setOnAction是回车时触发的，不是单击文本框
        textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("click");
            }
        });
        passwordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("密码是:"+t1);
            }
        });
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {//没有过滤右键，中键
                System.out.println("label单击事件");
            }
        });
    }
}
