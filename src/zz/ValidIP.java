//zz reviewed
package zz;

import java.util.ArrayList;
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
		//zz, use String[] with length 4 to contain the ip, or List<String>, then construct the res
														
		if(part==4){
			if(s.length()<=index){
				res.add(sb.toString());
			}
			return;
		}
		if(s.length()-index<4-part || s.length()-index>(4-part)*3){
			return;
		}
		if(part!=0){
			sb.append('.');
		}
		sb.append(s.charAt(index));//zz should check if input is valid, for example s = "abc"
		helper(index+1,s,sb,res,part+1);
		//zz this code is not maintainable, if each part has more than 3 digits, how many if will you write?
		if(s.charAt(index)>'0' && index+1<s.length()){
			sb.append(s.charAt(index+1));
			helper(index+2,s,sb,res,part+1);
			if(index+2<s.length() && Integer.parseInt(s.substring(index, index+3))<=255){
				sb.append(s.charAt(index+2));
				helper(index+3,s,sb,res,part+1);
				sb.deleteCharAt(sb.length()-1);
			}
			sb.deleteCharAt(sb.length()-1);			
		}
		sb.deleteCharAt(sb.length()-1);
		if(part!=0){
			sb.deleteCharAt(sb.length()-1);
		}
		/*for(int i=0;i<2;i++){
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
		}*/
		//sb.deleteCharAt(sb.length()-1);
	}
	
	
	public List<String> restoreIpAddresses_wz(String s){
		List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4) return res; 
        String[] t = new String[4];
        helper_wz(s,0,0,t,res);
        return res;
	}
    private void helper_wz(String s, int index, int section, String[] t, List<String> res){
        if(section >= 4 && index < s.length()) return;
        if(index >= s.length() && section < 4 ) return;
		if(index == s.length() && section == 4){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<t.length;i++){
				sb.append(t[i]);
                if(i != t.length-1) 
					sb.append(".");
 			}
            res.add(sb.toString());
			return;
		}
        
        for(int i=index;i<Math.min(index+3,s.length());i++){
			int value = Integer.parseInt(s.substring(index,i+1));
            if(value > 255) return;
            t[section] = s.substring(index,i+1);
            helper_wz(s,i+1,section+1,t,res);
            if(value == 0){
                break;
			}
		}	
	}


}
