package additional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomSet r=new RandomSet();
		r.insert(1);
		r.insert(2);
		r.insert(3);
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		r.delete(1);
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		r.delete(2);
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		r.delete(3);
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());
		System.out.println(r.getRandom());

	}
	
	int[] A=new int[100];
	HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
	int size=0;
	Random rd=new Random();
	public void insert(int x){
			A[size]=x;
			map.put(x, size);
			size++;
		};
	public	void delete(int x){
		if(size==0){
			return;
		}
			int index=map.get(x);
			A[index]=A[size-1];
			map.remove(x);
			map.put(A[index], index);
			System.out.println("size="+size);
			System.out.println(Arrays.toString(A));
			size--;
		};//remove element from the set
	public	int getRandom(){
			if(size==0){
				return -1;
			}
			int n=rd.nextInt(size);
			return A[n];
		};//get a random element from the set
		
}
