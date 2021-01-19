package Model.Level;

import java.util.ArrayList;

import Model.Fruits.GameObject;

public class Strategy {
	GameStrategy strategy;

	public Strategy(GameStrategy strategy) {
		this.strategy = strategy;
	}

	public String getInstuctions() {
		return this.strategy.getInstuctions();
	}

	public ArrayList<GameObject> getArrayList() {
		return this.strategy.getArrayList();

	}

	public void removeFruit(GameObject object) {
		this.strategy.removeFruit(object);
	}

	public void addFruit() {
		this.strategy.addFruit();
	}
}
