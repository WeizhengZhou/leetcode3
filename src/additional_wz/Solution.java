import java.io.*;
import java.util.Scanner;
public class Solution {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int x = in.nextInt();//read in next integer
			int s = (int) Math.sqrt(x/2);//
			int totalWay = 0;
			for(int i=0;i<=s;i++){
				int t = (int) Math.sqrt(x - i*i);
				if(Math.pow(t,2) == x - i*i)
					totalWay++;
			}
			System.out.println(totalWay);
		}		
    }
}
