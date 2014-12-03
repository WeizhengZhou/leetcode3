
import java.util.*;
import java.io.*;
public class Solution2 {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		String s = in.next();//input 1 as the input string
		
		String start = null;//start letter 
		int k = 0;//kth letter 
		String input2 = in.next();//get the input 2
		//if input2 is a letter
		if((input2.compareTo("a") >= 0 && input2.compareTo("z") <=0 ) ||
				(input2.compareTo("A") >= 0 && input2.compareTo("Z") <=0)){//
			start = input2;//update start letter
			k = in.nextInt();//get k
		}
		else{
			start = "a";
			k = Integer.parseInt(input2);//parse k
		}
		Solution2 solu = new Solution2();

		
		System.out.println(solu.kthLetter(s, start.charAt(0), k));
    }
	public char kthLetter(String s, char start, int k){
		s = s.toLowerCase();//to lower case first, since case insen
		int n = s.length();//total length of string s
		char[] charArr = s.toCharArray();//to char array
		Arrays.sort(charArr);//sort charArr in natural order
//		System.out.println(charArr);
		int startIndex = 0;//find the proper index of "start"
		for(int i=0;i<n;i++){
			if(i == 0 && start < charArr[0]){
				startIndex = 0;
				break;
			}
			else if(i == n-1 && start > charArr[n-1]){
				startIndex = n;
				break;
			}
			else if(start >= charArr[i] && start < charArr[i+1]){
				startIndex = i+1;
				break;
			}			
		}
//		System.out.println("StartIndex = " + startIndex + ", " + charArr[startIndex]);
		char res = 'a';
		for(int i=startIndex;i<startIndex+n;i++){
			k--;
			if(k==0) {
				res = charArr[i%n];
				break;
			}
		}
//		System.out.println(res);
		return res;
	}
}
