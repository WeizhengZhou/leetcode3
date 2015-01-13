package zz;

import java.util.LinkedList;
import java.util.List;

public class ValidIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidIP v=new ValidIP();
		System.out.println(v.restoreIpAddresses("0000").toString());

	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> res=new LinkedList<String>();
        if(s==null || s.length()<4 || s.length()>12){
        	return res;
        }
        helper(0,s,new StringBuilder(),res,0);
        return res;
    }
	
	public void helper(int index,String s, StringBuilder sb, List<String> res, int part){
		if(part==3){
			if(s.length()-index-1<=3 && Integer.parseInt(s.substring(index))<=255){
				sb.append('.');
				sb.append(s.substring(index, s.length()));
				res.add(sb.toString());
				int len=s.length()-index;
				sb.delete(sb.length()-len, sb.length());
			}
			return;
		}
		if(s.length()-index<4-part || s.length()-index-1>(4-part)*3){
			return;
		}
		if(part!=0){
			sb.append('.');
		}
		for(int i=0;i<2;i++){
			if(index+i<s.length()-1){
				sb.append(s.charAt(index+i));
				//System.out.println(sb.toString());
				helper(index+i+1,s,sb,res,part+1);
			}
		}
		sb.delete(sb.length()-2, sb.length());
		if(Integer.parseInt(s.substring(index,index+2))<=255 && Integer.parseInt(s.substring(index,index+2))>100){
			sb.append(s.charAt(index+2));
			helper(index+3,s,sb,res,part+1);
			sb.deleteCharAt(sb.length()-1);
		}
		if(part!=0){
			sb.deleteCharAt(sb.length()-1);
		}
		//sb.deleteCharAt(sb.length()-1);
	}


}
