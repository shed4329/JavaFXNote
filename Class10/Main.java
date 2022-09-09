package Class10;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("b1");
        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();
        button.setOnAction(actionEvent -> {//左键有效
            System.out.println("b1的点击事件");
        });
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {//点击事件
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("鼠标按键="+mouseEvent.getButton().name());//按键名字 PriMary=右，Secondary=左，middle=中
                if(mouseEvent.getClickCount()==2&&mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name())){//左键
                    System.out.println("双击b1");
                }

            }
        });
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {//按键检测
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("按下 "+keyEvent.getCode().getName());
                if (keyEvent.getCode().getName().equals(KeyCode.A.getName())){//过滤按键
                    System.out.println("按了A键");
                }
            }
        });
        button.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("释放"+keyEvent.getCode().getName());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
