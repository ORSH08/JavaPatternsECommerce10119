package orGalProject;

public class Action2 implements Observer {

	@Override
	public void update(MyButton button) {
		System.out.println("Action2 received: " + button.getMsg());

	}

}
