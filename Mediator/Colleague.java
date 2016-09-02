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
