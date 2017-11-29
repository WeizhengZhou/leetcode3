package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/*
 *  a:2
 *  b:2
 *  c:1
 * */
//bcabc
/*
 * pos=2
 * 
 * */
public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters r=new RemoveDuplicateLetters();
		System.out.println(r.removeDuplicateLettersIII("abaca"));
		//System.out.println(r.removeDuplicateLetters("cbacdcbc"));
	}
	public String removeDuplicateLetters(String s) {
		System.out.println("s="+s);
        int[] cnt = new int[26];//baca
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {System.out.println("pos="+pos);
        System.out.println("s.charAt(pos)="+s.charAt(pos));
        System.out.println("i="+i);
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }System.out.println("pos="+pos);
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	public String removeDuplicateLettersIII(String s) {
        if (s == null || s.length() <= 1) return s;

        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }

        char[] result = new char[lastPosMap.size()];
        int begin = 0, end = findMinLastPos(lastPosMap);

        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;System.out.println("begin="+begin+",end="+end);
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k+1;
                }
            }
            System.out.println("minchar="+minChar);
            result[i] = minChar;
            if (i == result.length-1) break;

            lastPosMap.remove(minChar);
            if (s.charAt(end) == minChar) end = findMinLastPos(lastPosMap);
        }

        return new String(result);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
             minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }
    public String removeDuplicateLettersII(String s) {
        if (s==null || s.length()==0) return s;
        Map<Character,Integer> map=new HashMap<> ();
        for(int i=0;i<s.length();i++) {
        	char c=s.charAt(i);
        	map.put(c, i);
        }
        PriorityQueue<Integer> q=new PriorityQueue<> ();
        for(Integer i:map.values()) {
        	q.add(i);
        }
        int start=0;
        List<Character> list=new LinkedList<> ();
        while(!q.isEmpty()) {
        	int index=q.poll();
        	start=findMin(start,index,s,list)+1;
        }
        StringBuilder sb=new StringBuilder();
        for(Character c:list){
        	sb.append(c);
        }
        return sb.toString();
    }
    private int findMin(int l, int r,String s, List<Character> list) {
    	if (l>r) return l;
    	char min=s.charAt(l);
    	int minIndex=l;
    	for (int i=l+1;i<=r;i++) {
    		if (s.charAt(i)<min && !list.contains(s.charAt(i))) {
    			min=s.charAt(i);
    			minIndex=i;
    		}
    	}
    	if (!list.contains(min)) {
    		list.add(min);
    	}
    	if (min!=s.charAt(r)) {
    		return findMin(minIndex+1,r,s,list);
    	}
    	return minIndex;
    }
}
