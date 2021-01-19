package View;

import javafx.application.*;
import javafx.stage.Stage;

public class Main extends Application {
	 starting x = new starting(new Stage());
	
	 public void start(Stage primaryStage) {
		
		
		 starting obj = new starting(primaryStage);
		 obj.PrepareScene();
		
		 
	 }
	 
	public static void main(String[] args) {
		 launch(args);
	}
	
}
