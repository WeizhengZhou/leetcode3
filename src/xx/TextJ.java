package xx;
import java.util.*;
public class TextJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJ t=new TextJ();
		System.out.println(t.fullJustify(new String[]{"a","b","c"}, 1));

	}
	public List<String> fullJustify(String[] words, int L) {
		 List<String> res=new LinkedList<>();
		 if(words==null || words.length==0 || L<=0){res.add("");return res;}
		 int i=0;
		 int start=0;
		 while(i<words.length){
		     start=i;
		     int len=words[i].length()+1;
		     while(i+1<words.length&&len<L){
		         len+=words[i+1].length()+1;
		         i++;
		     }
		     if(i!=words.length-1&&i!=start){
		     i--;}
		     append(start,i++,words,L,res);
		 }
		 res.remove(res.size()-1);
		 StringBuilder last=new StringBuilder();
		 int len=0;
		 for(int j=start;j<words.length;j++){
		     last.append(words[j]);
		     last.append(" ");
		     len+=words[j].length()+1;
		 }
		 if(len>L){last.deleteCharAt(last.length()-1);}
		 for(int j=0;j<L-len;j++){last.append(" ");}
		 res.add(last.toString());
		 return res;
   }
   private void append(int start,int end,String[] words,int L,List<String> res){
       int len=0;
       for(int i=start;i<=end;i++){
           len+=words[i].length();
       }
       if(end==start){
           StringBuilder sb=new StringBuilder();
           sb.append(words[start]);
           for(int j=0;j<L-words[start].length();j++){sb.append(" ");}
           res.add(sb.toString());
           return;
       }
       int gap=(L-len)/(end-start);
       int remain=(L-len)%(end-start);
       StringBuilder sb=new StringBuilder();
       for(int i=start;i<=end;i++){
           sb.append(words[i]);
           for(int j=0;j<gap;j++){sb.append(" ");}
           if(remain>0){sb.append(" ");remain--;}
       }
       if(sb.length()>0){
       sb.deleteCharAt(sb.length()-1);}
       res.add(sb.toString());
   }
}
