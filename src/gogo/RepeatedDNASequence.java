package gogo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new LinkedList<> ();
        if (s==null || s.length()<10) return list;
        Set<String> set=new HashSet<> ();
        for (int i=0;i<=s.length()-10;i++) {
        	String sub = s.substring(i,i+10);
        	if (!set.contains(sub)) {
        		set.add(sub);
        	} else if (!list.contains(sub)){
        		list.add(sub);
        	}
        }
        return list;
    }
}
