package Model.Level;

import java.util.ArrayList;
import java.util.Random;

import Model.Fruits.BananaX2;
import Model.Fruits.DangerousBombs;
import Model.Fruits.FatalBombs;
import Model.Fruits.GameObject;
import Model.Fruits.GameObjectFactory;
import Model.Fruits.Pineapple;
import Model.Fruits.Pomegranate;
import Model.Fruits.Strawberry;
import Model.Fruits.Watermelon;

public class level2 implements GameStrategy {
	ArrayList<GameObject> fruitsGeneration = new ArrayList<GameObject>();
	GameObjectFactory factory = new GameObjectFactory();

	@Override
	public ArrayList<GameObject> getArrayList() {
		GameObject pineapple = factory.getInstance("pineapple");
		GameObject pomegranate = factory.getInstance("pomegranate");
		GameObject strawberry = factory.getInstance("strawberry");
		GameObject watermelon = factory.getInstance("watermelon");
		GameObject fatalbomb = factory.getInstance("fatalBomb");
		GameObject BananaX2 = factory.getInstance("BananaX2");
		fruitsGeneration.add(fatalbomb);
		fruitsGeneration.add(watermelon);
		fruitsGeneration.add(strawberry);
		fruitsGeneration.add(pomegranate);
		fruitsGeneration.add(pineapple);
		fruitsGeneration.add(BananaX2);

		return fruitsGeneration;

	}

	@Override
	public String getInstuctions() {

		return "1)Don't lose a fruit ,or you will miss a life \r\n 2)Don't click on a Fatal Bomb \r\n,or you will lose the whole level.";
	}

	@Override
	public void removeFruit(GameObject object) {
		fruitsGeneration.remove(object);

	}

	@Override
	public void addFruit() {
		Random r = new Random();
		int x = r.nextInt(6);
		if (x == 0)
			fruitsGeneration.add(new Watermelon());
		if (x == 1)
			fruitsGeneration.add(new Strawberry());
		if (x == 2)
			fruitsGeneration.add(new FatalBombs());
		if (x == 3)
			fruitsGeneration.add(new Pineapple());
		if (x == 4)
			fruitsGeneration.add(new Pomegranate());
		if (x == 5)
			fruitsGeneration.add(new BananaX2());
	}

}
