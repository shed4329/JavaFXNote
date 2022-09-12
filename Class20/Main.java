package Class20;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("这是JavaFX\n");//\n换行
        Text text2 = new Text("JavaFX还好");
        Text text3 = new Text("hello,world");
        text.setFont(Font.font(20));//大小
        text.setFill(Paint.valueOf("#FF82AB"));//设置颜色
        //text.setStyle("-fx-fill:red");//css设置文本颜色

        text2.setFont(Font.font("Helvetica", FontPosture.ITALIC,40));
        TextFlow textFlow = new TextFlow();//文本的流式布局
        textFlow.setStyle("-fx-background-color:#EECFA1");
        textFlow.getChildren().addAll(text,text2,text3);//也可以往里面加Button
        textFlow.setPadding(new Insets(10));
        textFlow.setTextAlignment(TextAlignment.RIGHT);
        textFlow.setLineSpacing(30);//行间距

        Scene scene = new Scene(textFlow);
        stage.setScene(scene);
        stage.show();
    }
}
