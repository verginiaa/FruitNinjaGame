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

public class PrepareBananaX2 implements Preparation{
	Game game= Game.getInstance();
	Lives live = Lives.getinstance();
	 Group root = new Group();
	 Scene Scene2;
	 Button BananaX2;
	 ImageView BananaX2View;
	 ImageView BananaX2SlicedView;
	 boolean isSliced = false;

	 public PrepareBananaX2(Group root,Scene scene2) {
		 this.root=root;
		 this.Scene2=scene2;
		 
	 }
	 
	@Override
	public void prepare() {
		BananaX2View= new ImageView("file:images/Score_2x_Banana.PNG");
		BananaX2View.setFitWidth(100);
		BananaX2View.setFitHeight(100);
        Button BananaX2= new Button();
        BananaX2.setGraphic(BananaX2View);
        BananaX2.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(BananaX2);
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
	        transition.setNode(BananaX2);
	        transition.setDuration(Duration.seconds(4));
	        transition.setPath(line);
	        transition.setCycleCount(2);
	        transition.setAutoReverse(true);
	        transition.play();
	        BananaX2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
				    isSliced=true;
				game.setFruitRecived("BananaX2");
					game.Notify();
					BananaX2.setDisable(true);
					String musicFile = "Bonus Sound Effects-[AudioTrimmer.com].mp3";
			        Media sound = new Media((new File(musicFile)).toURI().toString());
			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
			        mediaPlayer.setVolume(800D);
			        mediaPlayer.seek(mediaPlayer.getStartTime());
			        mediaPlayer.setAutoPlay(true);
			        MediaView mediaView = new MediaView(mediaPlayer);
			        root.getChildren().add(mediaView);
	               transition.pause();
					
	               BananaX2SlicedView = new ImageView("file:images/20+_burned.PNG");
	               BananaX2SlicedView.setFitWidth(200);
	               BananaX2SlicedView.setFitHeight(200);
					
	               BananaX2.setGraphic(BananaX2SlicedView);
				transition.play();
					
				}
			});
	    	transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					if( isSliced==false)
					{
						live.CheckLives();
					}
				}
			});

	        
		
	}
	

}
