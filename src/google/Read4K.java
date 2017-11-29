import java.util.*;

public class Read4K {
	private final int SIZE = 4;
	private char[] buffer = null;
	private int index = 0;
	public char[] readAny(int size){
		StringBuilder sb = new StringBuilder();
		if(buffer == null || index >= buffer.length){
			buffer = read4k();
			index = 0;
		}
		while(size > 0){
			if(size < buffer.length - index){
				sb.append(Arrays.copyOfRange(buffer,index,index+size));
				index = index + size;
				size = 0;
			}
			else{
				sb.append(Arrays.copyOfRange(buffer, index, buffer.length));
				index = 0;
				buffer = read4k();
				size = size - (buffer.length - index);
			}
			
		}
		return sb.toString().toCharArray();
	}
	private char[] read4k(){
		Random rd = new Random();
		char[] res = new char[SIZE];
		for(int i=0;i<SIZE;i++){
			res[i] = (char) (i + 'a');
//			res[i] = (char) ('a' + (rd.nextInt() * 26));
		}
//		System.out.println(Arrays.toString(res));
		return res;
	}
	public static void main(String[] args){
		Read4K solu = new Read4K();
		System.out.println(solu.readAny(3));
		System.out.println(solu.readAny(1));
		System.out.println(solu.readAny(8));
		System.out.println(solu.readAny(12));
		System.out.println(solu.readAny(1));
		System.out.println(solu.readAny(3));	
	}
}
