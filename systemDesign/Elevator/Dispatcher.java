import java.util.*;
public abstract class Dispatcher {
	public abstract Cabin dispatch(List<Cabin> cabins, List<Request> requests);
}

class SectorDispatcher extends Dispatcher{
	
	@Override
	public Cabin dispatch(List<Cabin> cabins, List<Request> requests) {
		return null;
	}
}
