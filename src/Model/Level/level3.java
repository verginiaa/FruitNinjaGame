package Model.Level;

import java.util.ArrayList;
import java.util.Random;

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

public class level3 implements GameStrategy {
	ArrayList<GameObject> fruitsGeneration = new ArrayList<GameObject>();
	GameObjectFactory factory = new GameObjectFactory();

	@Override
	public ArrayList<GameObject> getArrayList() {
		GameObject pineapple = factory.getInstance("pineapple");
		GameObject pomegranate = factory.getInstance("pomegranate");
		GameObject strawberry = factory.getInstance("strawberry");
		GameObject watermelon = factory.getInstance("watermelon");
		GameObject fatalbomb = factory.getInstance("fatalBomb");
		GameObject DragonFruit = factory.getInstance("DragonFruit");
		GameObject bananaX2 = factory.getInstance("bananaX2");
		GameObject dangerousbomb = factory.getInstance("dangerousbombs");
		fruitsGeneration.add(fatalbomb);
		fruitsGeneration.add(watermelon);
		fruitsGeneration.add(strawberry);
		fruitsGeneration.add(pomegranate);
		fruitsGeneration.add(pineapple);
		fruitsGeneration.add(DragonFruit);
		fruitsGeneration.add(dangerousbomb);
		fruitsGeneration.add(bananaX2);
		return fruitsGeneration;

	}

	@Override
	public String getInstuctions() {
		// TODO Auto-generated method stub
		return "  In this level there are fatal and dangerous bombs \r\n"
				+ "                                 Watch out ;) ";
	}

	@Override
	public void removeFruit(GameObject object) {
		fruitsGeneration.remove(object);

	}

	@Override
	public void addFruit() {
		Random r = new Random();
		int x = r.nextInt(8);
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
			fruitsGeneration.add(new DragonFruit());
		if (x == 6)
			fruitsGeneration.add(new DangerousBombs());
		if (x == 7)
			fruitsGeneration.add(new BananaX2());

	}

}
