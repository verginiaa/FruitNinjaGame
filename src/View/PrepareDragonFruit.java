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

public class PrepareDragonFruit implements Preparation {

	Game game= Game.getInstance();
	 Group root = new Group();
	 Scene Scene3;
     Button DragonFruit;
	 ImageView DragonFruitView;
	 ImageView DragonSlicedView;
	 boolean isSliced =false;
		Lives live = Lives.getinstance();


	 public PrepareDragonFruit(Group root,Scene scene3) {
		 this.root=root;
		 this.Scene3=scene3;
		 
	 }
	 
	@Override
	public void prepare() {
		DragonFruitView= new ImageView("file:images/Dragonfruit.PNG");
   		DragonFruitView.setFitWidth(100);
   		DragonFruitView.setFitHeight(100);
           Button DragonFruit= new Button();
           DragonFruit.setGraphic(DragonFruitView);
           DragonFruit.setStyle("-fx-background-color: transparent;");
   		root.getChildren().add(DragonFruit);
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
   	        transition.setNode(DragonFruit);
   	        transition.setDuration(Duration.seconds(4));
   	        transition.setPath(line);
   	        transition.setCycleCount(2);
   	        transition.setAutoReverse(true);
   	        transition.play();
   	     DragonFruit.setOnAction(new EventHandler<ActionEvent>() {

   				@Override
   				public void handle(ActionEvent event) {
   				     isSliced=false;
   				game.setFruitRecived("Dragonfruit");
   					game.Notify();
   					//ShowScore();
   					DragonFruit.setDisable(true);
   					String musicFile = "Bonus Sound Effects-[AudioTrimmer.com].mp3";
   			        Media sound = new Media((new File(musicFile)).toURI().toString());
   			        MediaPlayer mediaPlayer = new MediaPlayer(sound);
   			        mediaPlayer.setVolume(800D);
   			        mediaPlayer.seek(mediaPlayer.getStartTime());
   			        mediaPlayer.setAutoPlay(true);
   			        MediaView mediaView = new MediaView(mediaPlayer);
   			        root.getChildren().add(mediaView);
   	               transition.pause();
   	
   	               DragonSlicedView = new ImageView("file:images/50+_burned.PNG");
   	               DragonSlicedView.setFitWidth(200);
   	               DragonSlicedView.setFitHeight(200);
   					
   	               DragonFruit.setGraphic(DragonSlicedView);
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
