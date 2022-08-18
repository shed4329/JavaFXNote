package Class1;

import javafx.stage.Stage;
import javafx.application.Application;

public class HelloFX extends Application{
	public static void main(String[] args){
		System.out.println("Hello World!");
		launch(args);
	}

	public void start(Stage stage){
		stage.show();
	}
}