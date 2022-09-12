package Class22;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("点击显示窗口");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button);
        AnchorPane.setTopAnchor(button,100.0);
        AnchorPane.setLeftAnchor(button,100.0);
        anchorPane.setStyle("-fx-background-color:#ffffff");

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();

        button.setOnAction(actionEvent -> {
            //真正的对话框是Alert和Dialog
            DialogPane dialogPane = new DialogPane();
            dialogPane.getButtonTypes().add(ButtonType.APPLY);
            dialogPane.getButtonTypes().add(ButtonType.CANCEL);
            dialogPane.setHeaderText("HeaderText");
            dialogPane.setContentText("ContentText");
            dialogPane.setExpandableContent(new Text("扩展内容"));
            //dialogPane.setExpanded(true);//默认开启

            //可以用dialogPane.setGraphic();//可以加载控件
            ImageView imageView = new ImageView("Class22\\icon\\icon.png");
            dialogPane.setGraphic(imageView);

            Button apply =(Button)dialogPane.lookupButton(ButtonType.APPLY);
            apply.setOnAction(actionEvent1 -> {
                System.out.println("应用");
            });
            Button cancel =(Button)dialogPane.lookupButton(ButtonType.CANCEL);
            cancel.setOnAction(actionEvent1 -> {
                System.out.println("关闭");
            });

            Scene scene1 = new Scene(dialogPane);
            Stage stage1 = new Stage();
            stage1.setScene(scene1);
            stage1.initStyle(StageStyle.UTILITY);
            stage1.initOwner(stage);
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.setAlwaysOnTop(true);
            stage1.setTitle("这是弹出的窗口");
            stage1.setResizable(false);
            stage1.show();

            myScheduledService my = new myScheduledService(dialogPane,stage1);
            my.setDelay(Duration.millis(0));//0秒后开始
            my.setPeriod(Duration.millis(1000));//一秒运行一次
            my.start();
        });
    }
}

class myScheduledService extends ScheduledService<Integer> {
    private DialogPane dialogPane = null;
    private Stage stage = null;
    int i = 0;
    public myScheduledService(DialogPane dialogPane,Stage stage){
        this.dialogPane = dialogPane;
        this.stage =stage;
    }
    protected Task<Integer> createTask(){
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call"+Thread.currentThread().getName());
                return i=i+1;//返回给updateValue
            }

            @Override
            protected void updateValue(Integer value) {
                System.out.println("updateValue"+Thread.currentThread().getName());
                System.out.println("updateValue的值="+value);
                if (value<11){
                    myScheduledService.this.dialogPane.setContentText(String.valueOf(value));
                }else{
                    myScheduledService.this.stage.close();
                    myScheduledService.this.cancel();//内部类任务取消
                }
            }
        };
    }

}
