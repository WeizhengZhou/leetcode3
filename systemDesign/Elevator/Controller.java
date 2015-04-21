import java.util.*;
public class Controller {
	private static final Controller controller = new Controller();
	private Dispatcher dispatcher = new SectorDispatcher();
	private List<Request> requests = new ArrayList<>();
	private List<Cabin> cabins = new ArrayList<>();
	private Controller(){
		cabins.add(new Cabin(1, 1, 8));
		cabins.add(new Cabin(2, 1, 8));
		cabins.add(new Cabin(3, 1, 8));
	}
	public static Controller getInstance(){
		return controller;
	}
	public void addRequest(Request request){
		this.requests.add(request);
	}
	public void dispatch(Request request){
		Cabin cabin = this.dispatcher.dispatch(cabins, requests);
	}
}
