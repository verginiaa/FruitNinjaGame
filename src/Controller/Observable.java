package Controller;

import View.Observer;

public interface Observable {
	public void add(Observer o);

	public void Notify();
}
