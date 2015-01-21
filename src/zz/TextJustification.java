package zz;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification t=new TextJustification();
		StringBuilder test=new StringBuilder();
		test.append(" ");
		//System.out.println(test.length());
		System.out.println(t.fullJustify(new String[]{""}, 2).toString());

	}
	 public List<String> fullJustify(String[] words, int L) {
		 List<String> res=new LinkedList<String>();
		 if(words==null  || L==0){
			 res.add("");
			 return res;
		 }
		 int i=0;
		 int start=0;
		 while(i<words.length)
		 {
			 StringBuilder sb=new StringBuilder(L);
			 int len=0;
			 int wordLen=0;
			 int num=0;
			 start=i;
			 while(i<words.length && len+words[i].length()<=L){
				 len+=words[i].length();
				 wordLen+=words[i].length();
				 num++;
				 len++;
				 i++;
			 }
			 if(num==0){
				 for(int j=0;j<L;j++){
					 sb.append(" ");
				 }
				 res.add(sb.toString());
			 }
			 else if(num==1){
				 sb.append(words[start]);
				 for(int j=0;j<L-words[start].length();j++){
					 sb.append(" ");
				 }
				 res.add(sb.toString());
			 }
			 else{
				 int spaces=(L-wordLen)/(num-1);
				 int remain=(L-wordLen)%(num-1);
				 for(int j=start;j<i-1;j++){
					 sb.append(words[j]);
					 for(int k=0;k<spaces;k++){
						 sb.append(" ");
					 }
					 if(remain>0){
						 sb.append(" ");
						 remain--;
					 }
				 }
				 sb.append(words[i-1]);
				 res.add(sb.toString());
			 }
		 }
		 if(res.size()>0){
			 res.remove(res.size()-1);
			 StringBuilder sb1=new StringBuilder();
			 for(int j=start;j<words.length;j++){
				 sb1.append(words[j]+" ");
			 }
			 sb1.deleteCharAt(sb1.length()-1);
			 System.out.println("sb length="+sb1.length());
			 int tail=L-sb1.length();
			 System.out.println("tail zeros="+tail+", L="+L);
			 for(int j=0;j<tail;j++){
				 sb1.append(" ");
				 System.out.println("sb new length="+sb1.length()+", L="+L);
			 }
			 System.out.println("sb new length="+sb1.length());
			 res.add(sb1.toString());
		 }
		 return res;
	 }
}
