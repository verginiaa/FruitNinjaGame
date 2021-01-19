package Controller;

import java.util.ArrayList;
import Model.Fruits.BananaX2;
import Model.Fruits.DangerousBombs;
import Model.Fruits.DragonFruit;
import Model.Fruits.FatalBombs;
import Model.Fruits.GameObject;
import Model.Fruits.GameObjectFactory;
import Model.Fruits.Pineapple;
import Model.Fruits.Pomegranate;
import Model.Fruits.Strawberry;
import Model.Fruits.Watermelon;
import Model.Level.Strategy;
import Model.Level.level1;
import Model.Level.level2;
import Model.Level.level3;
import View.Observer;

public class Game implements GameActions, Observable {

	// singelton
	private static Game instance;

	private Game() {

	}

	public static Game getInstance() {

		if (instance == null)

			instance = new Game();

		return instance;

	}

	Observer O;
	public Strategy level;
	String levelType;
	private ArrayList<GameObject> fruitsGeneration = new ArrayList<GameObject>();
	GameObject FruitRecived;
	int Score = 0;
	int Lives = 3;
	GameObjectFactory factory = new GameObjectFactory();
	Model.Level.writer writer = new Model.Level.writer();
	Model.Level.reader reader = new Model.Level.reader();

	public void setScore(int score) {
		Score = score;
	}

	public Model.Level.writer getWriter() {
		return writer;
	}

	public Model.Level.reader getReader() {
		return reader;
	}

	public int getLives() {
		return Lives;
	}

	public void setLives(int lives) {
		Lives = lives;
	}

	public int getScore() {
		return Score;
	}
	public void setFruitRecived(String fruitRecived) {
		FruitRecived = factory.getInstance(fruitRecived);
	}

	public ArrayList<GameObject> getFruitsGeneration() {
		return fruitsGeneration;
	}

	// applying strategy and setting arraylist for the first time
	public void setLevelType(String levelType) {

		this.levelType = levelType;
		if (levelType.equalsIgnoreCase("level one")) {
			level = new Strategy(new level1());
			fruitsGeneration = level.getArrayList();
		} else if (levelType.equalsIgnoreCase("level two")) {
			level = new Strategy(new level2());
			fruitsGeneration = level.getArrayList();
		} else {
			level = new Strategy(new level3());
			fruitsGeneration = level.getArrayList();
		}
	}


	@Override
	public void ResetGame() {
		Lives=3;
		Score=0;
	}

	@Override
	public void Notify() {
		updateScore();
		O.update();
	}

	@Override
	public void add(Observer o) {
		this.O = o;
	}

	

	public void updateScore() {
		
		if (FruitRecived instanceof BananaX2) {
			Score = Score + 20;
		} else if (FruitRecived instanceof Watermelon || FruitRecived instanceof Strawberry
				|| FruitRecived instanceof Pomegranate || FruitRecived instanceof Pineapple) {
			Score = Score + 10;
		} else if (FruitRecived instanceof DragonFruit) {
			Score = Score + 50;
		}
	}

	public int updateLives() {
		if (FruitRecived instanceof FatalBombs)
			Lives = 0;
		else if (FruitRecived instanceof DangerousBombs)
			Lives--;
		else if (FruitRecived.isSliced() == false) {
			Lives--;
		}
		return Lives;
	}

}
