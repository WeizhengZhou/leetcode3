package gogo;

public class ExcelSheetColumn {
    public String convertToTitle(int n) {
    	StringBuilder sb= new StringBuilder();
    	if (n==1) return "A";
        while (n!=0) {
        	int remain = (n-1)%26;
        	char c = (char)('A' + remain);
        	sb.insert(0,c);
        	n=(n-1)/26;
        }
        return sb.toString();
    }
}
