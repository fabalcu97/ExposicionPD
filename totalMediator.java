public interface Mediator {
	public void send(String message, Colleague colleague);
}

public class ApplicationMediator implements Mediator {

	private ArrayList<Colleague> colleagues;

	public ApplicationMediator() {
		colleagues = new ArrayList<Colleague>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	public void send(String message, Colleague originator) {
		for(Colleague colleague: colleagues) {
			if(colleague != originator) {
				colleague.receive(message);
			}
		}
	}
}

public abstract class Colleague{

	private Mediator mMediator;

	public Colleague(Mediator m) {
		mMediator = m;
	}

	public void send(String message) {
		mMediator.send(message, this);
	}

	public Mediator getMediator() {
		return mMediator;
	}

	public abstract void receive(String message);
}

public class ConcreteColleague extends Colleague {

	public ConcreteColleague(Mediator m){
		super(m);
	}

	public void receive(String message) {
		System.out.println("Colleague Received: " + message);
	}
}

public class MobileColleague extends Colleague {

	public MobileColleague(Mediator m){
		super(m);
	}

	public void receive(String message) {
		System.out.println("Mobile Received: " + message);
	}
}

public class MediatorPatternDemo {

	public static void main() {

		ApplicationMediator mediator = new ApplicationMediator();

		ConcreteColleague desktop = new ConcreteColleague(mediator);
		MobileColleague mobile1 = new MobileColleague(mediator);
		MobileColleague mobile2 = new MobileColleague(mediator);
		MobileColleague mobile3 = new MobileColleague(mediator);

		mediator.addColleague(desktop);
		mediator.addColleague(mobile1);
		mediator.addColleague(mobile2);
		mediator.addColleague(mobile3);

		desktop.send("Hello World");
		mobile1.send("Hello");

	}
}
