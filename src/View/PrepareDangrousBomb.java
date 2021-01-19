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

public class PrepareDangrousBomb implements Preparation {
	Game game= Game.getInstance();
	Lives obj = Lives.getinstance();

	 Group root = new Group();
	 Scene Scene1;
	 Button DangerBomb;
	 ImageView DangerousView;
	 ImageView bombSlicedView;
	 boolean isSliced =false;
	 
	
	public PrepareDangrousBomb(Group root2, Scene scene1) {
this.root=root2;
this.Scene1=scene1;
}



	@Override
	public void prepare() {
		DangerousView= new ImageView("file:images/bomb.PNG");
		DangerousView.setFitWidth(100);
		DangerousView.setFitHeight(100);
		 Button DangerBomb= new Button();
		DangerBomb.setGraphic(DangerousView);
		DangerBomb.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(DangerBomb);
		Line line = new Line();
		line.setStartX(new Random().nextInt(1480));
		line.setStartY(820);
		line.setEndX(new Random().nextInt(1300));
		line.setEndY(new Random().nextInt(300));
		 PathTransition transition = new PathTransition();
	        transition.setNode(DangerBomb);
	        transition.setDuration(Duration.seconds(4));
	        transition.setPath(line);
	        transition.setCycleCount(2);
	        transition.setAutoReverse(true);
	        transition.play();
	       // prepareReset();
			DangerBomb.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					game.setFruitRecived("DangerousBombs");
DangerBomb.setDisable(true);
					String musicFile = "bombing.mp3";
				        Media sound = new Media((new File(musicFile)).toURI().toString());
				        MediaPlayer mediaPlayer = new MediaPlayer(sound);
				        mediaPlayer.setVolume(800D);
				        //  mediaPlayer.setStopTime(Duration.minutes(2.36D));
				        mediaPlayer.seek(mediaPlayer.getStartTime());
				        mediaPlayer.setAutoPlay(true);
				        MediaView mediaView = new MediaView(mediaPlayer);
				        root.getChildren().add(mediaView);
	               transition.pause();
					obj.CheckLives();
					bombSlicedView = new ImageView("file:images/bombcut.PNG");
					bombSlicedView.setFitWidth(300);
					bombSlicedView.setFitHeight(300);
					
					DangerBomb.setGraphic(bombSlicedView);
				transition.play();
					
				}
			});		
	}
	

}
