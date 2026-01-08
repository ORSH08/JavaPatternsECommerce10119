package orGalProject;

public class Action1 implements Observer {

	@Override
	public void update(MyButton button) {
		System.out.println("Action1 received: " + button.getMsg());

	}

}
