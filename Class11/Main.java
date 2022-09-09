package Class11;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("button");
        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();

        button.setOnAction(actionEvent -> System.out.println("button"));
        //第一种，用的比较的，可能出现问题，可能win7和win10不一样
        KeyCombination keyCombination1 = new KeyCodeCombination(KeyCode.K,KeyCombination.ALT_DOWN,KeyCombination.CONTROL_DOWN);//ctrl+alt+k
        Mnemonic mnemonic1= new Mnemonic(button,keyCombination1);
        scene.addMnemonic(mnemonic1);//执行button单击事件

        //第二种,用的比较少
        KeyCombination keyCombination2 = new KeyCharacterCombination("M",KeyCombination.ALT_DOWN);//alt+m 好像三个就不起作用
        Mnemonic mnemonic2= new Mnemonic(button,keyCombination2);
        scene.addMnemonic(mnemonic2);//执行button单击事件

        //第三种，用的很少
        KeyCombination keyCombination3 = new KeyCodeCombination(KeyCode.P,KeyCombination.SHIFT_DOWN);//shift+a，好像没作用
        Mnemonic mnemonic3 = new Mnemonic(button,keyCombination3);
        scene.addMnemonic(mnemonic3);

        //第四种,用的比较多
        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.Y,KeyCombination.SHORTCUT_DOWN);//shortcut=ctrl（windows）/meta(mac) (idea on mac meta=command)
        scene.getAccelerators().put(keyCombination, new Runnable() {
            @Override
            public void run() {//ui线程
                System.out.println(Thread.currentThread().getName());
                //button.fire();//button的单击事件,以后再说，不会可以封装一个方法
            }
        });
    }
}
