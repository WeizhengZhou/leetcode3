package xx;

public class MajorityElement {
	public int majorityElement(int[] num) {
        if(num==null || num.length==0)return 0;
        int value=num[0];
        int count=1;
        for(int i=1;i<num.length;i++){
            if(count==0){value=num[i];}
            if(value==num[i]){count++;}
            else{
                count--;
            }
        }
        return value;
    }
}
