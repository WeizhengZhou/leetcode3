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
	
	 public List<Integer> grayCode(int n) {
		 List<Integer> res=new LinkedList<Integer>();
		 if(n<=0){
			 res.add(0);
			 return res;
		 }
		 List<StringBuilder> build=new ArrayList<StringBuilder>();
		 build.add(new StringBuilder("0"));
		 build.add(new StringBuilder("1"));
		 //System.out.println(build.toString());
		 for(int i=1;i<n;i++){
			 List<StringBuilder> current=new ArrayList<StringBuilder>();
			 for(int j=build.size()-1;j>=0;j--){
				 StringBuilder sb=build.get(j);
				 current.add(0, new StringBuilder("0"+sb.toString()));
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
