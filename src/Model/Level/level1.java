package Model.Level;

import java.util.ArrayList;
import java.util.Random;

import Model.Fruits.DangerousBombs;
import Model.Fruits.GameObject;
import Model.Fruits.GameObjectFactory;
import Model.Fruits.Pineapple;
import Model.Fruits.Pomegranate;
import Model.Fruits.Strawberry;
import Model.Fruits.Watermelon;

public class level1 implements GameStrategy {
	ArrayList<GameObject> fruitsGeneration = new ArrayList<GameObject>();
	GameObjectFactory factory = new GameObjectFactory();

	@Override
	public ArrayList<GameObject> getArrayList() {
		GameObject pineapple = factory.getInstance("pineapple");
		GameObject pomegranate = factory.getInstance("pomegranate");
		GameObject strawberry = factory.getInstance("strawberry");
		GameObject watermelon = factory.getInstance("watermelon");
		GameObject dangerousBombs = factory.getInstance("dangerousbombs");
		fruitsGeneration.add(dangerousBombs);
		fruitsGeneration.add(watermelon);
		fruitsGeneration.add(strawberry);
		fruitsGeneration.add(pomegranate);
		fruitsGeneration.add(pineapple);

		return fruitsGeneration;
	}

	@Override
	public String getInstuctions() {

		return "1) Don't lose a fruit, by doing that you lose a life \r\n3)Don't click on a dangerous bomb, \r\nby doing that you will lose a life";
	}

	@Override
	public void removeFruit(GameObject object) {
		fruitsGeneration.remove(object);

	}

	@Override
	public void addFruit() {
		Random r = new Random();
		int x = r.nextInt(5);
		if (x == 0)
			fruitsGeneration.add(new Watermelon());
		if (x == 1)
			fruitsGeneration.add(new Strawberry());
		if (x == 2)
			fruitsGeneration.add(new DangerousBombs());
		if (x == 3)
			fruitsGeneration.add(new Pineapple());
		if (x == 4)
			fruitsGeneration.add(new Pomegranate());

		int y = fruitsGeneration.size() - 1;

	}

}
