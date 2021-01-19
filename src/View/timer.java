package View;

import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.animation.KeyFrame;

import javafx.scene.control.Label;

public class timer {
	Stage primaryStage;
	Scene scene;
	Group root;
	private static final Integer STARTTIME = 0;
	private Timeline timeline;
	private Label timerLabel = new Label();
	private Integer timeSeconds = STARTTIME;
	private Timeline timeline2;
	private Label timerLabel2 = new Label();
	private Integer timeSeconds2 = STARTTIME;
	Button button;

	public void start(Stage primaryStage, Scene scene, Group root) {
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.root = root;
		this.primaryStage.setTitle("FX Timer");

		GridPane gridPane = new GridPane();
		this.scene.setRoot(root);

		timerLabel.setText(timeSeconds.toString());
		timerLabel2.setText(timeSeconds.toString());
		Label labelbrdu = new Label("0");
		labelbrdu.setFont(Font.font(50));
		button = new Button();
		button.setText("Start Timer");
		button.setVisible(false);
		button.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {

				timeSeconds = STARTTIME;
				timeSeconds2 = STARTTIME;
				// update timerLabel
				timerLabel.setText(timeSeconds.toString());
				timerLabel2.setText(timeSeconds.toString());
				timeline = new Timeline();
				timeline2 = new Timeline();
				timeline.setCycleCount(Timeline.INDEFINITE);// 3shan y3ml count down
				timeline2.setCycleCount(Timeline.INDEFINITE);// 3shan y3ml count down

				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler() {

					@Override
					public void handle(Event event) {
						timeSeconds++;
						// update timerLabel

						if (timeSeconds >= 10) {
							timerLabel.setVisible(false);
							if (timeSeconds == 60) {
								timeSeconds = 0;

								timeSeconds2++;

							}
							labelbrdu.setText(Integer.toString(timeSeconds));

						}

						else {
							labelbrdu.setText("0");
							timerLabel.setVisible(true);
						}
						timerLabel.setText(timeSeconds.toString());
						timerLabel2.setText(timeSeconds2.toString());
					}

				}));
				timeline.playFromStart();
			}
		});

		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setPrefWidth(scene.getWidth());
		gridPane.add(button, 0, 1);
		Label label = new Label(":");
		gridPane.add(label, 41, 2);
		timerLabel.setFont(Font.font(50));
		timerLabel2.setFont(Font.font(50));

		label.setFont(Font.font(50));
		gridPane.add(timerLabel2, 40, 2);
		gridPane.add(labelbrdu, 42, 2);

		gridPane.add(timerLabel, 43, 2);
		timerLabel.setLayoutX(42);
		timerLabel2.setLayoutX(39);
		label.setLayoutX(40);
		labelbrdu.setLayoutX(41);
		root.getChildren().add(gridPane);

	}

}