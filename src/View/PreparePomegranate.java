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

public class PreparePomegranate implements Preparation {
	Game game= Game.getInstance();
	 Group root = new Group();
	 Scene Scene1;
	 Button Pomegranate;
	 ImageView pomeSlicedView;
	 ImageView PomegranateView; 
		Lives obj = Lives.getinstance();
boolean isSliced=false;
	 public PreparePomegranate(Group root2, Scene scene12) {
		 this.root=root2;
			this.Scene1=scene12;
	 }

	 
	@Override
	public void prepare() {
			PomegranateView= new ImageView("file:images/pomegranate.PNG");
			PomegranateView.setFitWidth(100);
			PomegranateView.setFitHeight(100);
			Pomegranate= new Button();
			Pomegranate.setGraphic(PomegranateView);
	        Pomegranate.setStyle("-fx-background-color: transparent;");
			root.getChildren().add(Pomegranate);
			Line line = new Line();
			line.setStartX(new Random().nextInt(1480));
			line.setStartY(840);
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
		        transition.setNode(Pomegranate);
		        transition.setDuration(Duration.seconds(4));
		        transition.setPath(line);
		        transition.setCycleCount(2);
		        transition.setAutoReverse(true);
		        transition.play();
		        Pomegranate.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
			
						isSliced=true;
						game.Notify();
						//ShowScore();
						Pomegranate.setDisable(true);
						String musicFile = "fruit cut.mp3";
				        Media sound = new Media((new File(musicFile)).toURI().toString());
				        MediaPlayer mediaPlayer = new MediaPlayer(sound);
				        mediaPlayer.setVolume(800D);
				        mediaPlayer.seek(mediaPlayer.getStartTime());
				        mediaPlayer.setAutoPlay(true);
				        MediaView mediaView = new MediaView(mediaPlayer);
				        root.getChildren().add(mediaView);
						transition.pause();
						pomeSlicedView = new ImageView("file:images/pomegranatecut.PNG");
						pomeSlicedView.setFitWidth(300);
						pomeSlicedView.setFitHeight(300);
						Pomegranate.setGraphic(pomeSlicedView);
						PomegranateView.setVisible(false);
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
