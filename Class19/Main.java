package Class19;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        StackPane stackPane =  new StackPane();//图层面板，最后放的在最上面
        stackPane.setStyle("-fx-background-color:#EE6AA7");
        stackPane.getChildren().addAll(button1,button2,button3,button4,button5);
        stackPane.setPadding(new Insets(10));//内边距
        stackPane.setAlignment(Pos.BASELINE_LEFT);
        StackPane.setMargin(button1,new Insets(100));//外边距
        stackPane.getChildren().forEach(node -> {//forEach，相当于增强for循环，可以用lambda表达式
            Button button = (Button)node;
            System.out.println(button.getText());
        });

        Scene scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.show();
    }
}
