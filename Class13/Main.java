package Class13;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        //锚点布局，指定组件位置
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#abc88b");
        //有效，anchorPane是布局，group是组件容器，不是布局
        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("anchorPane");
            }
        });

        //button1.setLayoutY(100);//可以组件自己设置宽高
        AnchorPane.setTopAnchor(button1,100.0);//可以这样管理组件位置，这种管理优先于组件自己设置，这样setLayoutX无效
        anchorPane.setPadding(new Insets(10));//面板设置内边距，组件如果用了setTopAnchor之类的，好像会叠加（不确定）
        Group group1 = new Group();
        Button button = new Button("button");
        group1.getChildren().add(button);//设置位置相对于父控件
        Group group2 = new Group();
        anchorPane.getChildren().addAll(button1,button2,group1,group2);
        //如果只有一个组件，会自适应大小
        /*Group group = new Group();
        group.setStyle("-fx-background-color:#abc88b");
        group.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("sss");
            }
        });//可能是因为group没有宽高
         */
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
