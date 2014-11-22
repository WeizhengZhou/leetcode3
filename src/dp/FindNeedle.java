package dp;

public class FindNeedle {

	public static void main(String[] args) {

	}
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null){
        	return -1;
        }
        int len=needle.length();
        for(int i=0; i<=haystack.length()-len;i++){
        	int j=i+len;
        	if(haystack.substring(i, j).equals(needle)){
        		return i;
        	}
        }
        return -1;
    }

}
