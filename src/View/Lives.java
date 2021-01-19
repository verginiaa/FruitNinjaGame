package View;

import Controller.Game;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Lives {
	ImageView life1;
	ImageView life2;
	ImageView life3;
	Game game = Game.getInstance();
	public int Lives = 3;
	private static Lives instance;
	int live;
	Timeline timeline = new Timeline();
	Group root;

	private Lives() {

	}

	public static Lives getinstance() {

		if (instance == null)

			instance = new Lives();

		return instance;
	}

	public void setlives(ImageView life1, ImageView life2, ImageView life3, int live, Timeline timeline, Group root) {
		this.life1 = life1;
		this.life2 = life2;
		this.life3 = life3;
		this.live = live;
		this.timeline = timeline;
		this.root = root;
	}

	public void CheckLives() {
		System.out.println("gwa check lives");
		System.out.println(Lives);
		System.out.println(game.getLives());
		game.setLives(Lives -= 1);
		if (game.getLives() == 2) {
			life1.setVisible(false);
		}
		if (game.getLives() == 1) {
			life1.setVisible(false);
			life2.setVisible(false);
		}
		if (game.getLives() == 0) {
			life1.setVisible(false);
			life2.setVisible(false);
			life3.setVisible(false);
			GameOver();
		}

	}

	public void GameOver() {
		ImageView txt = new ImageView("file:images/txt.png");
		txt.setLayoutX(200);
		txt.setLayoutY(100);
		root.getChildren().add(txt);
		timeline.stop();
		game.getWriter().writeScore(game.getScore());
	}

}
