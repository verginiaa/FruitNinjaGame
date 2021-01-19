package View;

import java.awt.Canvas;

import Controller.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class starting {
	Game game=Game.getInstance();
	private Stage stage;

	public starting(Stage stage) {
        this.stage = stage;
    }
	
public void PrepareScene() {
	  Group root = new Group();
	  Canvas canvas = new Canvas();
	    ImageView background = new ImageView("file:images/background-scene---image.PNG");
	    background.setFitHeight(800);
	    background.setFitWidth(1400);
	    ImageView LogoView = new ImageView("file:images/FruitNinja_logo.PNG");
	    LogoView.setLayoutX(400);
	    LogoView.setLayoutY(50);
	    LogoView.setFitHeight(300);
	    LogoView.setFitWidth(500);
	    Button level1b = new Button();
	    ImageView choice1 = new ImageView("file:images/level1.png");
	    level1b.setGraphic(choice1);
	    level1b.setStyle("-fx-background-color: transparent;");
	    choice1.setFitWidth(100);
	    choice1.setFitHeight(100);
	    level1b.setLayoutX(350);
	    level1b.setLayoutY(250*2);
	    
	    Button level2b = new Button();
	    ImageView choice2 = new ImageView("file:images/level2.png");
	    level2b.setGraphic(choice2);
	    level2b.setStyle("-fx-background-color: transparent;");
	    choice2.setFitWidth(100);
	    choice2.setFitHeight(100);
	    level2b.setLayoutX(550);
	    level2b.setLayoutY(250*2);
	    
	    Button level3b = new Button();
	    ImageView choice3 = new ImageView("file:images/level3.png");
	    level3b.setGraphic(choice3);
	    level3b.setStyle("-fx-background-color: transparent;");
	    choice3.setFitWidth(100);
	    choice3.setFitHeight(100);
	    level3b.setLayoutX(750);
	    level3b.setLayoutY(250*2);

	   root.getChildren().add(background);
	    root.getChildren().add(LogoView);
	    root.getChildren().add(level1b);
	    root.getChildren().add(level2b);
	    root.getChildren().add(level3b);

	  

	    Scene StartingScene = new Scene(root, 1400, 800);
	    stage.setScene(StartingScene);
	    stage.show();
	    level1b.setOnAction(new EventHandler<ActionEvent>()  {

			@Override
			public void handle(ActionEvent event) {
				game.setLevelType("level one");				 
				Levelone level1 = new Levelone(stage);
				game.add(level1);
				level1.PrepareLevelOne();
							
			}
		});
	    level2b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			game.setLevelType("level two");
		    LevelTwo level2 = new LevelTwo(stage);
		    game.add(level2);
		    level2.PrepareLevelTwo();
			}
		});
	    level3b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				game.setLevelType("level three");
			    LevelThree level3 = new LevelThree(stage);
			    game.add(level3);
			    level3.PrepareLevelThree();				
			}
		});
}

}
