package Class8;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    int i =10;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Group group = new Group();
        //group.getChildren().add(b1);//添加方式一
        group.getChildren().addAll(b1,b2,b3);//添加方式2
        b1.setLayoutX(0);//设置位置
        b1.setLayoutY(0);
        b1.prefWidth(50);
        b1.prefHeight(50);//组件自己设置大小
        b2.setLayoutX(200);
        b2.setLayoutY(0);
        b3.setLayoutX(400);
        b3.setLayoutY(0);
        group.getChildren().remove(0);//移除b1
        //group.contains(0,0);//某个坐标上是否有组件，只能检测组件左上角
        //group.getChildren().clear();//全部清除
        //group.setAutoSizeChildren(false);//设置自动组件宽高，false的话组件宽高为0
        //group.setOpacity(0.5);//设置组件透明度
        Object[] obj = group.getChildren().toArray();//将所有组件放到一个数组中
        for(Object o:obj){
            Button button = (Button)o;
            button.setPrefWidth(100);
        }
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> change) {
                System.out.println("当前元素个数="+change.getList().size());
            }
        });//元素个数监听
        b2.setOnAction(actionEvent -> {//按钮监听
            Button b4 = new Button("b4");
            group.getChildren().add(b4);
            b4.setLayoutY(i);
            i+=10;
        });
        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
    }
}
