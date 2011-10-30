package se.chalmers.johanbr.helloworld;

public interface INet {
	public void send(IMessage m);
	public IMessage receive();
}
