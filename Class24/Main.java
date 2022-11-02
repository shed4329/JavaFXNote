package Class24;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label labelName = new Label("账号");
        labelName.setFont(Font.font(14));
        Label labelPassword = new Label("密码");

        TextField textFieldName = new TextField();
        textFieldName.setUserData("114514");
        textFieldName.setTooltip(new Tooltip("请输入用户名"));
        PasswordField passwordFieldPassword = new PasswordField();
        passwordFieldPassword.setUserData("123456");//设置用户数据
        passwordFieldPassword.setTooltip(new Tooltip("请输入密码"));
        /*passwordFieldPassword.getProperties().put("a","b");
        System.out.println(passwordFieldPassword.getProperties().get("a"));
        //简化键值对
         */

        Button login = new Button("登录");
        Button clear = new Button("清除");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color:#FFF5EE");
        gridPane.add(labelName,0,0);
        gridPane.add(textFieldName,1,0);
        gridPane.add(labelPassword,0,1);
        gridPane.add(passwordFieldPassword,1,1);
        gridPane.add(clear,0,2);
        gridPane.add(login,1,2);

        gridPane.setHgap(10);
        gridPane.setVgap(17);
        gridPane.setAlignment(Pos.CENTER);
        GridPane.setMargin(login,new Insets(0,0,0,120));
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();

        clear.setOnAction(actionEvent -> {
            textFieldName.setText("");
            passwordFieldPassword.setText("");
        });
        login.setOnAction(actionEvent -> {
            String s0 = textFieldName.getText();
            String s1 = passwordFieldPassword.getText();
            if (s0!=null&&!s0.isEmpty()&&s0.equals(textFieldName.getUserData())){
                if (s1!=null&&!s1.isEmpty()&&s1.equals(passwordFieldPassword.getUserData())){
                    System.out.println("登录成功");
                    MyWindow myWindow = new MyWindow();
                    stage.close();
                }else{
                    System.out.println("登录失败");
                    stage.setTitle("Failed");
                    FadeTransition fadeTransition = new FadeTransition();//动画
                    fadeTransition.setDuration(Duration.seconds(0.1));
                    fadeTransition.setNode(gridPane);
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);
                    labelName.setTextFill(Color.RED);
                    labelPassword.setTextFill(Color.RED);
                    fadeTransition.play();

                }
            }else{
                System.out.println("登录失败");
                stage.setTitle("Failed");
                FadeTransition fadeTransition = new FadeTransition();//动画
                fadeTransition.setDuration(Duration.seconds(0.1));
                fadeTransition.setNode(gridPane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                labelName.setTextFill(Color.RED);
                labelPassword.setTextFill(Color.RED);
                fadeTransition.play();
            }

        });
    }
}

class MyWindow{
    private final Stage stage = new Stage();
    public  MyWindow() {
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setTitle("login success");
        stage.show();
    }
}
