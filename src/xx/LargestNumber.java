package xx;

public class LargestNumber {
	public String largestNumber(int[] num) {
        if(num==null || num.length==0){return "";}
        Integer[] IntegerNum=new Integer[num.length];
        for(int i=0;i<num.length;i++){
            IntegerNum[i]=num[i];
        }
        Arrays.sort(IntegerNum,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                if(o1==0 || o2==0){return o1==0?1:-1;}
                int divisor1=1;
                int divisor2=1;
                while(o1/divisor1>0){divisor1*=10;}
                while(o2/divisor2>0){divisor2*=10;}
                return -o1*divisor2-o2+o2*divisor1+o1;
            }
        });
        StringBuilder buf=new StringBuilder();
        for(int i=0;i<IntegerNum.length;i++){
            buf.append(IntegerNum[i]);
        }
        return buf.charAt(0)=='0'?"0":buf.toString();
    }
}
