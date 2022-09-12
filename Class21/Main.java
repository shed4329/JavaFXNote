package Class21;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
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

        TilePane tilePane = new TilePane();//瓦片布局
        tilePane.setStyle("-fx-background-color:#EE6AA7");
        tilePane.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7,button8);
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(10));
        tilePane.setAlignment(Pos.BOTTOM_RIGHT);
        TilePane.setMargin(button1,new Insets(40));//TilePane和FlowPane不同的地方
        TilePane.setAlignment(button2,Pos.BOTTOM_CENTER);

        Scene scene = new Scene(tilePane);
        stage.setScene(scene);
        stage.show();
    }
}
