package xx;
import java.util.*
public class LongestSubstringWORepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
        if(s==null|| s.length()==0){return 0;}
        BitSet set=new BitSet();
        int start=0;
        int len=0;
        for(int i=0;i<s.length();i++){
            if(!set.get(s.charAt(i))){
                set.set(s.charAt(i));
            }
            else{
                while(start<i && s.charAt(start)!=s.charAt(i)){
                    set.set(s.charAt(start),false);
                    start++;
                }
                start++;
            }
            len=Math.max(len,i-start+1);
        }
        return len;
    }
}
