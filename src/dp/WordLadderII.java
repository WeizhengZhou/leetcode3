package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII w=new WordLadderII();
		Set<String> dict=new HashSet();
		dict.add("hot");
		dict.add("dog");
		//dict.add("c");
		//dict.add("lot");
		//dict.add("log");
		
		//System.out.println("sas".substring(0,1)+(char)('a'+25)+"sas".substring(2));
				
		List<List<String>> ll=w.findLadder("hot", "dog", dict);
		if(ll!=null){
		for(List<String>l:ll){
			System.out.println(l.toString());
		}
		}

	}
	
	public List<List<String>> findLadder(String start, String end, Set<String> dict){
		if(start==null||end==null||start.length()!=end.length()||start.length()==0||end.length()==0){
			return null;
		}
		LinkedList<String> cur=new LinkedList<String>();
		HashMap<String,LinkedList<String>> map=new HashMap<String,LinkedList<String>>();
		cur.add(start);
		while(!cur.isEmpty()){
			LinkedList<String> next=new LinkedList<String>();	
			Set<String> newAdd=new HashSet<String>();
			while(!cur.isEmpty()){				
				String w=cur.remove();
				for(int i=0; i<w.length();i++){
					for(int j=0;j<26;j++){
						String temp=w.substring(0, i)+(char)('a'+j)+w.substring(i+1);
						if(!temp.equals(w)&&dict.contains(temp)){
							if(!map.containsKey(temp)){
								next.add(temp);
								newAdd.add(temp);
								LinkedList<String> l=new LinkedList<String>();
								l.add(w);
								map.put(temp, l);
							}
							else{
								if(newAdd.contains(temp)&&!map.get(temp).contains(w)){
									map.get(temp).add(w);
								}
							}						
						}
						if(temp.equals(end)){
							if(!map.containsKey(temp)){
								LinkedList<String> l=new LinkedList<String>();
								l.add(w);
								newAdd.add(temp);
								map.put(end, l);
							}
							else{
								if(newAdd.contains(temp)&&!map.get(temp).contains(w)){
									map.get(end).add(w);
								}
							}			
						}
					}
					
				}
			}
			//if(!map.containsKey(end)){
			if(map.containsKey(end)){
				break;
			}
				cur=next;
			//}
		}
		for(String s:map.keySet()){
			System.out.println(s+": "+map.get(s).toString());
		}
		if(map.containsKey(end)){
			List<List<String>> res=new LinkedList<List<String>>();
			LinkedList<String> list=new LinkedList<String>();
			list.add(end);
			buildRes(map,res,end,start,list);
			return res;
		}
		else{
			List<List<String>> r=new LinkedList<List<String>>();
			r.add(null);
			return r;
		}
	}

	public void buildRes(HashMap<String,LinkedList<String>> map, List<List<String>> res, String end, String start, LinkedList<String> l){
		if(end.equals(start)){
			res.add(new LinkedList<String>(l));
			return;
		}
		for(String t:map.get(end)){
			if(!l.contains(t)){
				l.addFirst(t);
				buildRes(map,res,t,start,l);
				l.remove(t);
			}
		}
	}
	
}
