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
