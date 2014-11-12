package dp;

import java.util.LinkedList;
import java.util.List;

public class IPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPAddress i=new IPAddress();
		System.out.println(i.restoreIP("25525511135"));

	}
	
	public List<String> restoreIP(String s){
		if(s==null||s.length()==0){
			return null;
		}
		List<String> res=new LinkedList<String>();
		helper(s,0,0,res,new StringBuilder());
		return res;
	}
	
	public void helper(String s, int index, int part, List<String> res, StringBuilder sb){
		if(part>=4){
			if(index==s.length()){
				res.add(sb.toString());
			}
			return;
		}
		if (s.length()-index<(4-part)||s.length()-index>(4-part)*3){
			return;
		}
		for(int i=0; i<3;i++){
			int num=0;
			for(int j=0;j<i;j++){
				num*=10;
				if (index+j<s.length()){
					num+=Integer.parseInt(s.substring(index+j, index+j+1));
				}
			}
			if(num>=0 && num<=255){
				if(part==0){
					sb.append(num);
				}
				else{
					sb.append("."+num);
				}
				helper(s,index+i+1,part+1,res,sb);
				int len=Integer.toString(num).length();
				int removeL=part==0?len-1:len;
				for(int k=0;k<=removeL;k++){
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
	}

}
