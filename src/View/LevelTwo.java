package View;

import Controller.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LevelTwo implements Observer {
	Game game = Game.getInstance();
	private Stage stage;
	Group root = new Group();
	Scene Scene2;
	int score;
	int Live;
	Timeline timeline;

	public LevelTwo(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void update() {
		score = game.getScore();
		ShowScore();
	}

	public void ShowInstructions() {
		ImageView instructionView = new ImageView("file:images/instructions_burned.PNG");
		instructionView.setLayoutX(450);
		instructionView.setLayoutY(200);
		instructionView.setFitWidth(470);
		Text info = new Text(game.level.getInstuctions());
		info.setLayoutX(480);
		info.setLayoutY(450);
		info.setFont(Font.font(Font.getFontNames().get(0), FontWeight.EXTRA_BOLD, 22));
		ImageView exitView = new ImageView("file:images/exitLabel-removebg.png");
		Button exitButton = new Button();
		exitButton.setGraphic(exitView);
		exitButton.setLayoutX(490);
		exitButton.setLayoutY(220);
		exitView.setFitWidth(50);
		exitView.setFitHeight(50);
		exitButton.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(instructionView);
		root.getChildren().add(info);
		root.getChildren().add(exitButton);
		instructionView.setVisible(true);
		info.setVisible(true);
		exitButton.setVisible(true);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				timeline.play();

				timer timer = new timer();
				timer.start(stage, Scene2, root);
				timer.button.fire();
				instructionView.setVisible(false);
				info.setVisible(false);
				exitButton.setVisible(false);

			}
		});

	}

	public void prepareReset() {

		ImageView exitView = new ImageView("file:images/RESET.png");
		Button exitButton = new Button();
		exitButton.setGraphic(exitView);
		exitButton.setLayoutX(800);
		exitView.setFitWidth(50);
		exitView.setFitHeight(50);
		exitButton.setStyle("-fx-background-color: transparent;");
		root.getChildren().add(exitButton);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				timeline.stop();
				game.getWriter().writeScore(game.getScore());
				starting back = new starting(stage);
				game.setScore(0);
				back.PrepareScene();
			}
		});

	}

	public void ShowScore() {
		ImageView board = new ImageView("file:images/score board.PNG");
		board.setFitWidth(200);
		board.setFitHeight(200);
		board.setLayoutX(200);
		board.setLayoutY(-30);
		root.getChildren().add(board);
		int x = game.getScore();
		Text score = new Text("Score " + x);
		score.setLayoutX(250);
		score.setLayoutY(120);
		score.setFont(Font.font(Font.getFontNames().get(0), FontWeight.EXTRA_BOLD, 40));
		root.getChildren().add(score);

	}

	public void PrepareLevelTwo() {
		ImageView background = new ImageView("file:images/background-scene---image.PNG");
		background.setFitHeight(800);
		background.setFitWidth(1400);
		root.getChildren().add(background);
		Scene2 = new Scene(root, 1400, 800);
		game.setLives(3);
		Lives object = Lives.getinstance();
		object.Lives = 3;
		ShowInstructions();
		ShowScore();
		prepareReset();
		timeline = new Timeline(new KeyFrame(Duration.seconds(3), (event -> {
			int i = 0;
			if (i < game.level.getArrayList().size()) {

				if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("Pomegranate")) {

					PreparePomegranate obj4 = new PreparePomegranate(root, Scene2);
					obj4.prepare();
					prepareReset();
				} else if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("Watermelon")) {
					PrepareWatermelon obj1 = new PrepareWatermelon(root, Scene2);

					obj1.prepare();
					prepareReset();
				} else if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("Pineapple")) {

					PreparePineapple obj2 = new PreparePineapple(root, Scene2);
					obj2.prepare();
					prepareReset();
				} else if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("Strawberry")) {

					PrepareStrawberry obj3 = new PrepareStrawberry(root, Scene2);
					obj3.prepare();
					prepareReset();
				} else if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("FatalBombs")) {
					PrepareFatalBomb obj4 = new PrepareFatalBomb(root, Scene2);
					obj4.prepare();
					prepareReset();
				} else if (game.level.getArrayList().get(i).getFruitName().equalsIgnoreCase("BananaX2")) {

					PrepareBananaX2 obj5 = new PrepareBananaX2(root, Scene2);
					obj5.prepare();
					prepareReset();
				}
				game.level.removeFruit(game.level.getArrayList().get(i));
				game.level.addFruit();
				i++;

			}
		}

		)));
		timeline.setCycleCount(Animation.INDEFINITE);
		ImageView life1 = new ImageView("file:images/lives.png");
		life1.setFitWidth(60);
		life1.setFitHeight(60);
		life1.setLayoutX(1300);
		ImageView life2 = new ImageView("file:images/lives.png");
		life2.setFitWidth(60);
		life2.setFitHeight(60);
		life2.setLayoutX(1300 - 50);
		ImageView life3 = new ImageView("file:images/lives.png");
		life3.setFitWidth(60);
		life3.setFitHeight(60);
		life3.setLayoutX(1300 - 50 - 50);
		root.getChildren().add(life1);
		root.getChildren().add(life2);
		root.getChildren().add(life3);
		object.setlives(life1, life2, life3, Live, timeline, root);
		stage.setScene(Scene2);
		stage.show();
	}

}
