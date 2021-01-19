package Model.Fruits;

public class BananaX2 implements GameObject {

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
		return "BananaX2";
	}

}
