package xx;

public class ExcelColumnNumber {
	public int titleToNumber(String s) {
        if(s==null || s.length()==0)return 0;
        int num=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            num*=26;
            num+=cur-'A'+1;
        }
        return num;
    }
}
