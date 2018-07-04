package simulation;

public interface Event<S> {
	
	public void invoke(S simulation);

}
