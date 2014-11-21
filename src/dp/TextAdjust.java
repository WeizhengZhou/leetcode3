package dp;

import java.util.LinkedList;
import java.util.List;

public class TextAdjust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextAdjust t=new TextAdjust();
		List<String> r=t.fullJustify(new String[]{"What","must","be","shall","be."},12);
		for(String s:r){
			System.out.println("|"+s+"|");
		}
	}
	
public List<String> fullJustify(String[] words, int L) {
        List<String> res=new LinkedList<String>();
        res.add("");
        if(words==null||words.length==0||L==0){
        	return res;
        }
        res.clear();
        int i=0;
        while(i<words.length){
        	int l=i;
        	int len=words[l].length();
        	while(l+1<words.length && len+1+words[l+1].length()<=L){
        		len=len+1+words[l+1].length();
        		l++;
        	}
        	int slots=l-i;
        	int w=L;
        	for(int j=i;j<=l;j++){
        		w-=words[j].length();
        	}
        	int spaces=slots==0?L-words[i].length():w/slots;
        	int remaining=slots==0?0:w%slots;
        	StringBuilder sb=new StringBuilder();
        	for(int j=i;j<l;j++){
        		sb.append(words[j]);
        		for(int k=0;k<spaces;k++){
        			sb.append(" ");
        		}
        		if(remaining>0){
        			sb.append(" ");
        			remaining--;
        		}
        	}
        	sb.append(words[l]);
        	if(slots==0){
        		for(int k=0;k<spaces;k++){
        			sb.append(" ");
        		}
        	}
        	res.add(sb.toString());
        	i=l+1;
        }
        String last=res.get(res.size()-1);
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<last.length();k++){
        	char c=last.charAt(k);
        	if(c!=' '){
        		sb.append(c);
        	}
        	else{
        		while(k+1<last.length()&&last.charAt(k+1)==' '){
        			k++;
        		}
        		
        		sb.append(" ");
        		
        	}
        }
        System.out.println(sb.length());
        if(L-sb.length()>0){
        	int q=L-sb.length();
        	for(int p=0;p<q;p++){
        		sb.append(" ");
        	}
        }
        System.out.println(sb.length());
        res.remove(res.size()-1);
        res.add(sb.toString());
        return res;
    }

}
