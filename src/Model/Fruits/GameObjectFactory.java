package Model.Fruits;

public class GameObjectFactory {
	public GameObject getInstance (String gameObject) {
		if(gameObject==null)
			return null;
		if(gameObject.equalsIgnoreCase("BananaX2"))
		return new BananaX2();
		if(gameObject.equalsIgnoreCase("DangerousBombs"))
			return new DangerousBombs();
		if(gameObject.equalsIgnoreCase("fatalBomb"))
			return new FatalBombs();
		if(gameObject.equalsIgnoreCase("Dragonfruit"))
			return new DragonFruit();
		if(gameObject.equalsIgnoreCase("pineapple"))
			return new Pineapple();
		if(gameObject.equalsIgnoreCase("pomegranate"))
			return new Pomegranate();
		if (gameObject.equalsIgnoreCase("strawberry"))
			return new Strawberry();
		if(gameObject.equalsIgnoreCase("watermelon"))
			return new Watermelon();
		return null;
		
	}

}
