package zz;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement m=new MajorityElement();
		System.out.println(m.majorityElement(new int[]{1,2,3,5,2,3,2,2}));

	}
	
    public int majorityElement(int[] num) {
        int current=num[0];
        int count =1;
        for(int i=1;i<num.length;i++){
        	if(count<=0){
        		current=num[i];
        		count=1;
        	}
        	else{
        		if (num[i]==current){
        			count++;
        		}
        		else{
        			count--;
        		}
        	}
        }
        return current;
    }

}
