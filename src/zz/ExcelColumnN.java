package zz;

public class ExcelColumnN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelColumnN e=new ExcelColumnN();
		System.out.println(e.titleToNumber("AB"));

	}
    public int titleToNumber(String s) {
        if(s==null || s.length()==0){
        	return 0;
        }
        int length=s.length();
        int n=0;
        int count=1;
        for(int i=length-1;i>=0;i--){
        	char c=s.charAt(i);
        	n+=(c-'A'+1)*count;
        	count*=26;
        }
        return n;
    }
}
