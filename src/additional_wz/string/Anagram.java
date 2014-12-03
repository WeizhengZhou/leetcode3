package string;

import java.util.*;
public class Anagram{
	public boolean isAnagram(String a, String b){
		if(a == null && b == null) return true;
		if(a == null || b == null) return false;	
		a = a.toLowerCase().replaceAll("\\s+","");
		b = b.toLowerCase().replaceAll("\\s+","");
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		return Arrays.equals(aArr,bArr);	
	}
	public static void main(String[] args){
		Anagram solu = new Anagram();
		String a = "the sky is blue";
		String b = "tskyhe blueis    ";
		System.out.println("a = " + a + ", b = " + b + ", isAnagram = " + solu.isAnagram(a,b));
	}
}
