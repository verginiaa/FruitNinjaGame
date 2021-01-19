package Model.Fruits;

public class Watermelon implements GameObject {
	private boolean isSliced = false;

	@Override
	public boolean isSliced() {
		// TODO Auto-generated method stub
		return isSliced;
	}

	@Override
	public void setisSliced(boolean isSliced) {
		this.isSliced = isSliced;
	}

	@Override
	public String getFruitName() {
		// TODO Auto-generated method stub
		return "Watermelon";
	}

}
