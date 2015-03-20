package xx;

public class RotateImage {
	public List<List<Integer>> permuteUnique(int[] num){
		if (num==null||num.length==0){
			return null;
		}
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(num,0,res);
		return res;
	}
	
	public void helper(int[] num, int index, List<List<Integer>> res){
		if (index==num.length-1){
			List<Integer> l=new LinkedList<Integer>();
			for(int i=0;i<num.length;i++){
				l.add(num[i]);
			}
			res.add(l);
			return;
		}
		Set<Integer> visited=new HashSet<Integer>();
		for(int i=index;i<num.length;i++){
			if(!visited.contains(num[i])){
				swap(num,index,i);
				helper(num,index+1,res);
				swap(num,index,i);
				visited.add(num[i]);
			}
		}
	}
	
	public void swap(int[] num, int a, int b){
		if (a==b){
			return;
		}
		int temp=num[a];
		num[a]=num[b];
		num[b]=temp;
	}
}
