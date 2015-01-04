package zz;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelColumnTitle e=new ExcelColumnTitle();
		System.out.println(e.convertToTitle(27));

	}
	
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        int res=0;
        while(n>0){
        	res=n%26;
        	if(res==0){
        		sb.insert(0, 'Z');
        		n=n/26-1;
        	}
        	else{
        		sb.insert(0, (char)('A'+res-1));
        		n=n/26;
        	}
        }
        return sb.toString();
    }

}
