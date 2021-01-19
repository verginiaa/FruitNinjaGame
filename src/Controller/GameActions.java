package Controller;

import Model.Fruits.GameObject;

public interface GameActions {

	public int getScore();

	public void ResetGame();
	
	public void setLevelType(String levelType);
	
	public void updateScore();
	
	public int updateLives();


}
