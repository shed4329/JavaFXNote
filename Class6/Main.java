package Class6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Screen screen = Screen.getPrimary();//获取主屏幕
        Rectangle2D rectangle2D1 =screen.getBounds();//全部屏幕范围
        Rectangle2D rectangle2D2 =screen.getVisualBounds();//屏幕可视范围
        double dpi = screen.getDpi();
        System.out.println("当前屏幕dpi="+dpi);
        //全部屏幕
        System.out.println("全部屏幕");
        System.out.println("左上角坐标:("+rectangle2D1.getMinX()+","+rectangle2D1.getMinY()+")");
        System.out.println("右下角坐标:("+rectangle2D1.getMaxX()+","+rectangle2D1.getMaxY()+")");
        System.out.println("宽度="+rectangle2D1.getWidth()+"高度="+rectangle2D1.getHeight());
        //可视屏幕（就是除了任务栏的区域）
        System.out.println("可视屏幕");
        System.out.println("左上角坐标:("+rectangle2D2.getMinX()+","+rectangle2D2.getMinY()+")");
        System.out.println("右下角坐标:("+rectangle2D2.getMaxX()+","+rectangle2D2.getMaxY()+")");
        System.out.println("宽度="+rectangle2D2.getWidth()+"高度="+rectangle2D2.getHeight());
        Platform.exit();
    }
}
