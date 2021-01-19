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

public class PrepareFatalBomb implements Preparation{

	Game game= Game.getInstance();
	Lives lives = Lives.getinstance();
	 Group root = new Group();
	 Button FatalBomb;
	 ImageView FatalView;
	 ImageView FatalSlicedView;
	 Scene Scene2;


	 public PrepareFatalBomb(Group root,Scene scene2)
	 {
		 this.root=root;
		this.Scene2=scene2;
		 
	 }
	 
	@Override
	public void prepare() {
		FatalView= new ImageView("file:images/fatal bomb.PNG");
		FatalView.setFitWidth(100);
		FatalView.setFitHeight(100);
		Button fatalBomb= new Button();
		fatalBomb.setGraphic(FatalView);
		fatalBomb.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(fatalBomb);
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
	        transition.setNode(fatalBomb);
	        transition.setDuration(Duration.seconds(4));
	        transition.setPath(line);
	        transition.setCycleCount(2);
	        transition.setAutoReverse(true);
	        transition.play();
	        fatalBomb.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
							
                lives.GameOver();
				game.setFruitRecived("fatalBomb");	
                fatalBomb.setDisable(true);
					game.setLives(0);
					String musicFile = "bombing.mp3";
			        Media sound = new Media((new File(musicFile)).toURI().toString());
			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
			        mediaPlayer.setVolume(800D);
			        mediaPlayer.seek(mediaPlayer.getStartTime());
			        mediaPlayer.setAutoPlay(true);
			        MediaView mediaView = new MediaView(mediaPlayer);
			        root.getChildren().add(mediaView);
	               transition.pause();
					
	               FatalSlicedView = new ImageView("file:images/bombcut.PNG");
	               FatalSlicedView.setFitWidth(200);
	               FatalSlicedView.setFitHeight(200);
					
	               fatalBomb.setGraphic(FatalSlicedView);
				transition.play();
					
				}
			});
	    	

	}
		
	}


