package Class5;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Platform.setImplicitExit(false);//关了窗口，程序不退出，默认是true,用Platform.exit();关闭程序
        System.out.println("3D支持："+ Platform.isSupported(ConditionalFeature.SCENE3D));
        System.out.println("FXML支持："+ Platform.isSupported(ConditionalFeature.FXML));
        System.out.println("Swing嵌入支持："+ Platform.isSupported(ConditionalFeature.SWING));
        System.out.println("swt支持："+ Platform.isSupported(ConditionalFeature.SWT));
        System.out.println("媒体支持："+ Platform.isSupported(ConditionalFeature.MEDIA));
    }
}
