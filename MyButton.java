package orGalProject;

import java.util.HashSet;
import java.util.Set;

public class MyButton {
	private String msg;
	private Set<Observer> set = new HashSet<>();

	public MyButton() {

	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	// addListener
	public void attach(Observer o) {
		set.add(o);
	}

	public void click() {
		myNotify();
	}

	public void detach(Observer o) {
		set.remove(o);
	}

	public void myNotify() {
		for (Observer o : set)
			o.update(this);
	}
}
