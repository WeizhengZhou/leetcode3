package gogo;

import java.util.LinkedList;
import java.util.List;

public class RestoreIP {
	public static void main(String[] args) {
		RestoreIP r = new RestoreIP();
		System.out.println(r.restoreIpAddresses("010010"));
		StringBuilder s=new StringBuilder("011");System.out.println(s.toString());
		s.delete(0, 2);
		System.out.println(s.toString());
	}
	//["0.10.0.10","0.100.1.0"]
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<> ();
        if (s==null || s.length()<4 || s.length()>12) return list;
        helper(0,0,new StringBuilder(),s, list);
        return list;
    }
	
	private void helper(int index, int part, StringBuilder sb, String s, List<String> list) {
		System.out.println("index="+index+"=============.part="+part);
		if ((s.length()-index)>(4-part)*3) return;
		if (part>=4) {
			if(index<s.length()) return;
			list.add(sb.toString());
			return;
		}
		if (index>=s.length()) return;
		if(part>0) sb.append('.');
		System.out.println("index="+index+"=============.part="+part);
		for(int i=0;i<3;i++) {
			if(index+i<s.length()) {System.out.println("i="+i);
				String sub = s.substring(index, index+i+1);System.out.println("index="+index+", sub="+sub);
				int num = Integer.parseInt(sub);System.out.println("num="+num);
				if (i==1 && num<10) continue;
				if (i==2 && (num<100 || num>255)) continue;
				sb.append(sub); System.out.println("sb="+sb.toString()+",-->");
				helper(index+i+1,part+1,sb,s,list);System.out.println("sb="+sb.toString()+"");
				sb.delete(sb.length()-i-1, sb.length()); System.out.println("sb="+sb.toString()+",<--");
				System.out.println("index="+index+"<============="+"i="+i);
			}
		}
		if (part>0) {
			sb.deleteCharAt(sb.length()-1);
		}		
	}
}
