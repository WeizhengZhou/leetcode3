package dp;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a=new AddBinary();
		System.out.println(a.addBinary("1010", "1011"));

	}
    public String addBinary(String a, String b) {
        if(a==null||b==null){
        	return a==null?b:a;
        }
        String s=a.length()<b.length()?a:b;
        String l=a.length()<b.length()?b:a;
        StringBuilder res=new StringBuilder();
        int carry=0;
        int i=s.length()-1;
        int j=l.length()-1;
        for(;i>=0;i--){
        	int ds=Integer.parseInt(s.substring(i,i+1));
        	int dl=Integer.parseInt(l.substring(j,j+1));
        	j--;
        	int sum=ds+dl+carry;
        	int digit=sum%2;
        	carry=sum/2;
        	res.insert(0, digit);
        }
        for(;j>=0;j--){
        	int dl=Integer.parseInt(l.substring(j,j+1));
        	int sum=dl+carry;
        	int digit=sum%2;
        	carry=sum/2;
        	res.insert(0, digit);
        }
        if(carry==1){
        	res.insert(0, 1);
        }
        return res.toString();
    }
}
