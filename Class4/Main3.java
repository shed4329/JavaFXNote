package Class4;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.show();



        Stage s3 = new Stage();
        s3.initModality(Modality.APPLICATION_MODAL);//设置模态化窗口,不必设置父窗口，只对之前show的窗口有作用，之后的没作用，只有音效，不会闪
        s3.setTitle("s3");
        s3.show();

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initModality(Modality.WINDOW_MODAL);//对s1模态有效，会闪烁，要求s1先显示
        s2.initOwner(s1);
        s2.show();
    }
}
