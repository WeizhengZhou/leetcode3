package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitionI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitionI p=new PalindromePartitionI();
		List<List<String>> l=p.partition("bb");
		for(List<String> ll:l)
		{
			System.out.println(ll.toString());
		}

	}
	
	public List<List<String>> partition(String s){
		int len=s.length();
		boolean[][] isPal=new boolean[len][len];
		for (int i=0;i<len;i++){
			isPal[i][i]=true;
		}
		for(int j=0;j<len-1;j++){
			if(s.charAt(j)==s.charAt(j+1)){
				isPal[j][j+1]=true;
			}
		}
		for (int d=2;d<len;d++){
			for(int i=0;i<len-d;i++){
				int j=i+d;
				isPal[i][j]=isPal[i+1][j-1]&&s.charAt(i)==s.charAt(j);
			}
		}
		List<List<String>> res=new LinkedList<List<String>>();
		System.out.print(Arrays.deepToString(isPal));
		helper(s,isPal,0,res,new LinkedList<String>());
		return res;
	}
	
	public void helper(String s,boolean[][] check, int l,List<List<String>> res,List<String> list){
		if(l>=check.length){
			return;
		}
		if (check[l][check[0].length-1]){
			list.add(s.substring(l, check[0].length));
			res.add(new LinkedList<String>(list));
			list.remove(list.size()-1);
			//return;
		}
		
		for(int i=0; i<check[0].length;i++){
			if(check[l][i]){
				list.add(s.substring(l, i+1));
				helper(s,check,i+1,res,list);
				list.remove(list.size()-1);
				
			}
		}
	}

}
