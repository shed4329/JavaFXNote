package Class15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    static boolean isManaged = false;
    static boolean isVisible = false;
    static double  opacityValue = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        Button button5 = new Button("Button3.setManaged(false)");//脱离管理，还在hBox中,但位置会被顶替
        Button button6 = new Button("Button3.setVisible(false)");//不可见，但位置还在，点击不了
        Button button7 = new Button("Button3.setOpacity(0)");//不可见，位置还在，可以触发点击事件

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#ffffff");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1,button2,button3,button4);
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(button5,button6,button7);

        AnchorPane.setTopAnchor(vBox,100.0);
        AnchorPane.setLeftAnchor(vBox,20.0);
        anchorPane.getChildren().addAll(hBox,vBox);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();

        button5.setOnAction(new EventHandler<ActionEvent>() {//虽然已经脱离托管，但
            @Override
            public void handle(ActionEvent actionEvent) {
                button3.setManaged(isManaged);
                new Print(hBox);
                isManaged = !isManaged;
                button5.setText("Button3.setManaged("+isManaged+")");
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button3.setVisible(isVisible);
                new Print(hBox);
                isVisible = !isVisible;
                button6.setText("Button3.setVisible("+isVisible+")");
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button3.setOpacity(opacityValue);
                new Print(hBox);
                opacityValue = 1.0-opacityValue;
                button7.setText("Button3.setOpacity("+opacityValue+")");
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("button3");
            }
        });
    }
}

class Print{
    Print(HBox hBox){
        System.out.println("当前HBox组件数量="+hBox.getChildren().size());
    }
}
