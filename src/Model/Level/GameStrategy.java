package Model.Level;

import java.util.ArrayList;

import Model.Fruits.GameObject;

public interface GameStrategy {
	
	public ArrayList<GameObject> getArrayList ();
	
	public String getInstuctions ();
	
	public void removeFruit(GameObject object);
	
	public void addFruit();

}
