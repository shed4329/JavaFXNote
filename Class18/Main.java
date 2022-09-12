package Class18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        Button button7 = new Button("Button7");
        Button button8 = new Button("Button8");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color:#EE6AA7");
        //网格布局
        gridPane.add(button1,0,0);//第0列，第0行
        gridPane.add(button2,1,0);
        gridPane.add(button3,2,0);
        gridPane.add(button4,3,0);
        gridPane.add(button5,0,1);
        gridPane.add(button6,1,1);
        gridPane.add(button7,2,1);
        gridPane.add(button8,3,1);
        //也可以用这种方式添加，一个组件只能用一种方式加载一次
        //GridPane.setConstraints(button1,1,1);
        //也可以这样
        //GridPane.setRowIndex(button1,0);//第0行
        //GridPane.setColumnIndex(button1,1);//第一列
        //gridPane.getChildren().addAll(button1);
        //gridPane.getColumnConstraints().add(new ColumnConstraints(10));//单独设置第一列边距
        gridPane.setHgap(10);//水平间距
        gridPane.setVgap(10);//垂直间距
        gridPane.setPadding(new Insets(10));//内边距
        GridPane.setMargin(button1,new Insets(10));//外边距
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}
