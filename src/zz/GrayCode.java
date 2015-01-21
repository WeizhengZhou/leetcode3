//zz reviewed
package zz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode g=new GrayCode();
		System.out.println(g.grayCode(3).toString());

	}


	//zz, consider not using StringBuilder, but use integer to store the intemediate result	
	//zz, see my code below
	 public List<Integer> grayCode(int n) {
		 List<Integer> res=new LinkedList<Integer>();
		 if(n<=0){
			 res.add(0);
			 return res;
		 }
		 List<StringBuilder> build=new ArrayList<StringBuilder>();//zz not a noun
															      //zz should be curSB
		 build.add(new StringBuilder("0"));
		 build.add(new StringBuilder("1"));
		 //System.out.println(build.toString());
		 for(int i=1;i<n;i++){
			 List<StringBuilder> current=new ArrayList<StringBuilder>();//zz should be nextSB
			 for(int j=build.size()-1;j>=0;j--){
				 StringBuilder sb=build.get(j);
				 current.add(0, new StringBuilder("0"+sb.toString()));//zz, inserting an element at the head of array
																	 //     needs O(n) time
																	// you should use linkedlist instead of arraylist
				 //sb.delete(0, 1);
				 current.add(new StringBuilder("1"+sb.toString()));
				 //current.add(0, sb.insert(0, "0"));
				 //sb.delete(0, 1);
				 //current.add(sb.insert(0, "1"));
			 }
			 System.out.println(current.toString());
			 build=new ArrayList<StringBuilder>(current);
		 }
		 for(StringBuilder sb:build){
			 res.add(Integer.parseInt(sb.toString(), 2));
		 }
		 return res;
	 }

}
/*
import java.util.*;
public class Solution {
    public List<Integer> grayCode(int n) {
        if(n<0) 
            return new ArrayList<Integer>();
       
        List<Integer> cur = new ArrayList<Integer>();
        List<Integer> next = new ArrayList<Integer>();
        cur.add(0);
        for(int i=1;i<=n;i++){
            for(Integer k:cur){
                next.add(k);
            }
            Collections.reverse(cur);
            for(Integer k:cur){
                next.add(k+(1<<(i-1)));
            }
            cur = new ArrayList<>(next);
            next.clear();
        }
        return cur;
    }
}

*/
