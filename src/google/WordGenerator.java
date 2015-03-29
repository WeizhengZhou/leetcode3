import java.util.Arrays;
import java.util.Random;


public class WordGenerator {
	private int[] freq = new int[256];
	private int totalCount = 0;
	public void train(String w){
		if(w == null) return ;
		for(int i=0;i<w.length();i++){
			int index = (int) w.charAt(i);
			if(index < 256 && index >=0){
				freq[index] = freq[index]+1;
				totalCount++;
			}
		}
		System.out.println(Arrays.toString(freq));
	}
	public String generate(int k){
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		for(int i=0;i<k;i++){
			int sum = 0;
			int r = rd.nextInt(totalCount);
			for(int j=0;j<256;j++){
				sum += freq[j];
				if(r < sum){
					sb.append((char) j);
					break;
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args){
		WordGenerator solu = new WordGenerator();
		solu.train("apple");
		solu.train("ape");
		solu.train("aaaa");
		System.out.println(solu.generate(3));
		System.out.println(solu.generate(1));
		
	}

}
