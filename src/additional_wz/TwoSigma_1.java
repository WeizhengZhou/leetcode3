
import java.util.*;
public class TwoSigma_1 {
	public static void main(String[] args){
//		String input = "d 3 c 2 1 a";//output  "a 1 c 2 3 d" 
//		String input = "add 6 abb at";//abb 6 add at
		TwoSigma_1 solu = new TwoSigma_1();
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();
		String input = "a b c d";
		System.out.println(solu.alphanumericSort(input));		
	}
	public String alphanumericSort(String input){
		if(input == null) return input;//check if input is null
		String[] strs = input.split(" ");//split input to array of strings, using " "
		
		if(strs.length <=0) return input;//check if input is "        " like string
		
		boolean[] isNumber = new boolean[strs.length];//if strs[i] is number, isNumber[i] = true
		List<String> numbers = new ArrayList<>();//list to store numbers
		List<String> alphas = new ArrayList<>();//list to store non-numbers
				
		for(int i=0;i<strs.length;i++){//iterate each string in strs
			if(isNumber(strs[i])){//if it is a number
				isNumber[i] = true;//set isNumber[i] to be true
				numbers.add(strs[i]);//add this number to number list
			}
			else{
				isNumber[i] = false;//set isNumber[i] to be false
				alphas.add(strs[i]);
			}
		}		
		Collections.sort(numbers);//sort number list
		Collections.sort(alphas);//sort non-numbers list
		
		StringBuilder sb = new StringBuilder();//final result's string builder
		
		int numberIndex = 0;//current looking index in number list's index
		int alphaIndex = 0;//current looking index in non-number list's index
		
		for(int i=0;i<strs.length;i++){//append number or non-number to sb, according the isNumber[]
			if(isNumber[i] == true){
				sb.append(numbers.get(alphaIndex++));
			}
			else{
				sb.append(alphas.get(numberIndex++));
			}
			if(i != strs.length-1){//if not the last one, append a space
				sb.append(" ");
			}
		}
		return sb.toString();//return final result
	}
	private boolean isNumber(String s){//if s is a number, return true
		try{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			
		}
		return false;
	}
}
