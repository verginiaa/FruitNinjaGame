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

public class PreparePineapple implements Preparation{

	Game game= Game.getInstance();
	 Group root = new Group();
	 Scene Scene1;
	 Button Pinapple;
	 ImageView PineappleView;
	 ImageView PinappleSlicedView;
		Lives obj = Lives.getinstance();
boolean isSliced = false;
	 
	 public PreparePineapple(Group root2, Scene scene12) {
		 this.root=root2;
			this.Scene1=scene12;
	 }
	 
	 
	@Override
	public void prepare() {
        PineappleView= new ImageView("file:images/pineapple.PNG");
        PineappleView.setFitWidth(100);
        PineappleView.setFitHeight(100);
	    Button Pinapple= new Button();
		Pinapple.setGraphic(PineappleView);
		Pinapple.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(Pinapple);
		Line line = new Line();
		line.setStartX(new Random().nextInt(1480));
		line.setStartY(800);
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
	        transition.setNode(Pinapple);
	        transition.setDuration(Duration.seconds(4));
	        transition.setPath(line);
	        transition.setCycleCount(2);
	        transition.setAutoReverse(true);
	        transition.play();
			Pinapple.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
				
game.setFruitRecived("pineapple");
					game.Notify();
					Pinapple.setDisable(true);
					PineappleView.setVisible(false);
					String musicFile = "fruit cut.mp3";
			        Media sound = new Media((new File(musicFile)).toURI().toString());
			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
			        mediaPlayer.setVolume(800D);
			        mediaPlayer.seek(mediaPlayer.getStartTime());
			        mediaPlayer.setAutoPlay(true);
			        MediaView mediaView = new MediaView(mediaPlayer);
			        root.getChildren().add(mediaView);
	               transition.pause();
					
	               PinappleSlicedView = new ImageView("file:images/pineapplecut.PNG");
	               PinappleSlicedView.setFitWidth(200);
	               PinappleSlicedView.setFitHeight(200);
					
	             
	            
	              Pinapple.setGraphic(PinappleSlicedView );
	              PineappleView.setVisible(false);
	              transition.play();
					
				}
			});

			
			transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {


					if( isSliced==false)
					{
						obj.CheckLives();

					}
					
				}
			});
		
	
	
	}

}
