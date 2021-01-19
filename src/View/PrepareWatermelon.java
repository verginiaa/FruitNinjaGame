package View;

import java.io.File;
import java.util.Random;

import Controller.Game;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class PrepareWatermelon implements Preparation {
	Group root = new Group();
	Scene Scene1;
	Button Watermelon;
	ImageView WatermelonView;
	ImageView WatermelonSlicedView;
	ImageView life1;
	ImageView life2;
	ImageView life3;
	Game game = Game.getInstance();
	Lives obj = Lives.getinstance();
boolean isSliced = false;
	
	
	


	public PrepareWatermelon(Group root2, Scene scene12) {
		this.root=root2;
		this.Scene1=scene12;	
		}






	public void prepare() {		
		WatermelonView= new ImageView("file:images/watermelon.PNG");
		WatermelonView.setFitWidth(100);
		WatermelonView.setFitHeight(100);
		Button Watermelon= new Button();
		Watermelon.setGraphic(WatermelonView);
		Watermelon.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(Watermelon);
		Line line = new Line();
		line.setStartX(new Random().nextInt(1480));
		line.setStartY(820);
		String musicFile = "fruit appear.mp3";
        Media sound = new Media((new File(musicFile)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(800D);
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().add(mediaView);
		line.setEndX(new Random().nextInt(1300));
		line.setEndY(new Random().nextInt(300));
		 PathTransition transition = new PathTransition();
	        transition.setNode(Watermelon);
	        transition.setDuration(Duration.seconds(4));
	        transition.setPath(line);
	        transition.setCycleCount(2);
	        transition.setAutoReverse(true);
	        transition.play();
			Watermelon.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					 
game.setFruitRecived("watermelon");
isSliced=true;
					game.Notify();
					Watermelon.setDisable(true);
					String musicFile = "fruit cut.mp3";
			        Media sound = new Media((new File(musicFile)).toURI().toString());
			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
			        mediaPlayer.setVolume(800D);
			        mediaPlayer.seek(mediaPlayer.getStartTime());
			        mediaPlayer.setAutoPlay(true);
			        MediaView mediaView = new MediaView(mediaPlayer);
			        root.getChildren().add(mediaView);					
					WatermelonSlicedView = new ImageView("file:images/watermeloncut.PNG");
					WatermelonSlicedView.setFitWidth(100);
					WatermelonSlicedView.setFitHeight(100);
					
					Watermelon.setGraphic(WatermelonSlicedView);
WatermelonView.setVisible(false);
				
					
				}
			});
			
			transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					if(isSliced==false)
					{
						obj.CheckLives();
					}
				}
				
			});

	
}
	}


