package additional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTicket s=new SortTicket();
		//SortTicket tt = new SortTicket();
		List<Ticket> list=new LinkedList<Ticket>();
		list.add(new Ticket("Durham","NYC"));
		list.add(new Ticket("NYC","Durham"));
		list.add(new Ticket("SF","Seattle"));
		list.add(new Ticket("NYC","SF"));
		list.add(new Ticket("Seattle","Miami"));
		List<String> res=s.sortTickets(list);
		System.out.println(res.toString());
	}
	
	public List<String> sortTickets(List<Ticket> tickets){
		Map<String,List<String>> city=new HashMap<String,List<String>>();
		for(Ticket t:tickets){
			String f=t.fromCity;
			if(!city.containsKey(f)){
				List<String> list=new LinkedList<String>();
				list.add(t.toCity);
				city.put(f, list);
			}
			else{
				city.get(f).add(t.toCity);
			}
			if(!city.containsKey(t.toCity)){
				city.put(t.toCity, new LinkedList<String>());
			}
		}
		Set<String> visited=new HashSet<String>();
		List<String> res=new LinkedList<String>();
		for(String start:city.keySet())
		{
			if(!visited.contains(start))
			{
				topological(start,res,city,visited);
			}
		}		
		return res;
	}
	
	public void topological(String c, List<String> res, Map<String, List<String>> graph, Set<String> visited){
		visited.add(c);
		for(String s:graph.get(c)){
			if(!visited.contains(s)){
				topological(s,res,graph,visited);
			}
		}
		res.add(0, c);
	}
}

class Ticket{
	public String fromCity;
	public String toCity;
	public Ticket(String f, String t){
		fromCity=f;
		toCity=t;
	}
}	
