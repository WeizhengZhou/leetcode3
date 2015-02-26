package xx;
import java.util.*;
public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		WordLadderII w=new WordLadderII();
		List<List<String>> res=w.findLadders("hot", "dog", dict);
		for(List<String> list:res){
			System.out.println(list);
		}
		System.out.println(new String(new char[]{'a','b'}));

	}
	 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		 List<List<String>> res=new LinkedList<>();
		 if(dict==null||start==null || end==null || start.length()!=end.length()){
		     return res;
		 }
		 Map<String,List<String>> map=new HashMap<>();
		 Set<String> visited =new HashSet<>();
		 visited.add(start);
		 Queue<String> curLevel=new LinkedList<>();
		 curLevel.add(start);
		 Queue<String> nextLevel=new LinkedList<>();
		 while(!curLevel.isEmpty()){
		     String cur=curLevel.poll();
		     List<String> next=build(cur,dict,end,visited,map);
		     nextLevel.addAll(next);
		     if(curLevel.isEmpty()){
		         if(nextLevel.contains(end)){
		        	 for(String key:map.keySet()){
		        		 System.out.println(key+": "+map.get(key));
		        	 }
		             resBuilder(new LinkedList<String>(),map,res,end,start);
		             return res;
		         }
		         curLevel=new LinkedList<String>(nextLevel);
		         nextLevel.clear();
		     }
		 }
		 return res;
	 }
	 private void resBuilder(LinkedList<String> buf,Map<String,List<String>> map,List<List<String>> res,String end,String start){
	     buf.addFirst(end);
	     if(end.equals(start)){
	         res.add(new LinkedList<String>(buf));
	         buf.poll();
	         return;
	     }
	     List<String> pre=map.get(end);
	     for(String s:pre){
	         resBuilder(buf,map,res,s,start);
	     }
	     buf.poll();
	 }
	 private List<String> build(String cur,Set<String> dict,String end,Set<String> visited,Map<String,List<String>> map){
	     List<String> res=new LinkedList<>();
	     if(cur==null||cur.length()==0)return res;
	     for(int i=0;i<cur.length();i++){
	         String pre=cur.substring(0,i);
	         String after=cur.substring(i+1);
	         for(char c='a';c<='z';c++){
	             String temp=pre+c+after;
	             if(dict.contains(temp)&&!visited.contains(temp)||temp.equals(end)){
	                 visited.add(temp);
	                 res.add(temp);
	             }
	             if(res.contains(temp)){
	                 List<String> list=map.get(temp);
	                 if(list==null){
	                     list=new LinkedList<String>();	                
	                     map.put(temp,list);
	                 }
	                 list.add(cur);
	             }
	         }
	         
	     }
	     System.out.println(cur+": "+res);
	     return res;
	 }
	 
	 /**
	  * 	 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		 List<List<String>> res=new LinkedList<>();
		 if(dict==null||start==null || end==null || start.length()!=end.length()){
		     return res;
		 }
		 Map<String,List<String>> map=new HashMap<>();
		 Set<String> visited =new HashSet<>();
		 visited.add(start);
		 List<String> curLevel=new LinkedList<>();
		 curLevel.add(start);
		 List<String> nextLevel=new LinkedList<>();
		 while(!curLevel.isEmpty()){
		     String cur=curLevel.remove(0);
		     //List<String> next=build(cur,dict,end,visited,map,nextLevel);
		     //List<String> next=new LinkedList<>();
	     for(int i=0;i<cur.length();i++){
	         char[] A=cur.toCharArray();
	         for(char c='a';c<='z';c++){
	             A[i]=c;
	             String temp=new String(A);
	             if(!visited.contains(temp)&&(dict.contains(temp)||temp.equals(end))){
	                 visited.add(temp);
	                 nextLevel.add(temp);
	             }
	             if(nextLevel.contains(temp)){
	                 List<String> list=map.get(temp);
	                 if(list==null){
	                     list=new LinkedList<String>();
	                 }
	                 list.add(cur);
	                 map.put(temp,list);
	             }
	         }
	     }
		     //
		     //nextLevel.addAll(next);
		     if(curLevel.isEmpty()){
		         if(nextLevel.contains(end)){
		             resBuilder(new LinkedList<String>(),map,res,end,start);
		             return res;
		         }
		         curLevel=new LinkedList<String>(nextLevel);
		         nextLevel.clear();
		     }
		 }
		 return res;
	 }
	 private void resBuilder(List<String> buf,Map<String,List<String>> map,List<List<String>> res,String end,String start){
	     buf.add(0,end);
	     if(end.equals(start)){
	         res.add(new LinkedList<String>(buf));
	         buf.remove(0);
	         return;
	     }
	     List<String> pre=map.get(end);
	     for(String s:pre){
	         resBuilder(buf,map,res,s,start);
	     }
	     buf.remove(0);
	 }
	 private List<String> build(String cur,Set<String> dict,String end,Set<String> visited,Map<String,List<String>> map,List<String> nextLevel){
	     List<String> res=new LinkedList<>();
	     if(cur==null||cur.length()==0)return res;
	     for(int i=0;i<cur.length();i++){
	         char[] A=cur.toCharArray();
	         for(char c='a';c<='z';c++){
	             A[i]=c;
	             String temp=new String(A);
	             if((dict.contains(temp)||temp.equals(end))&&!visited.contains(temp)){
	                 visited.add(temp);
	                 res.add(temp);
	             }
	             if(res.contains(temp)||nextLevel.contains(temp)){
	                 List<String> list=map.get(temp);
	                 if(list==null){
	                     list=new LinkedList<String>();
	                     map.put(temp,list);
	                 }
	                 list.add(cur);
	             }
	         }
	     }
	     return res;
	 }
	  * 
	  */
	 
}
