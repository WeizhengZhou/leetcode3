package additional;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNumber r=new RandomNumber();
		System.out.println(r.getRandom(4, new int[]{1,2}));

	}
	
	public int getRandom(int N, int[] blacklist){
		Random r=new Random();
		int n=r.nextInt(N+1);
		Set<Integer> bl=new HashSet<Integer>();
		for(int i=0;i<blacklist.length;i++){
			bl.add(blacklist[i]);
		}
		while(bl.contains(n) || n==0){
			n=r.nextInt(N+1);
		}
		return n;
	}

}
