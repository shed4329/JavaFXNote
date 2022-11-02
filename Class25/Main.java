package Class25;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();

        Hyperlink hyperlink = new Hyperlink("www.baidu.com",new Button("网址"));//也可以用加node，点node也可以跳转
        hyperlink.setOnAction(actionEvent -> {
            HostServices hostServices =Main.this.getHostServices();
            hostServices.showDocument(hyperlink.getText());
        });
        box.getChildren().add(hyperlink);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setHeight(200);
        stage.setWidth(200);
        stage.show();
    }
}
