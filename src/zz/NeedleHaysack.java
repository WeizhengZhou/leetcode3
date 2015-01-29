//zz reviewed
package zz;

public class NeedleHaysack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int strStr(String haystack, String needle) {
		if(haystack==null||haystack.length()==0||needle==null || needle.length()==0){
			return 0;
		}
		for(int i=0;i<=haystack.length()-needle.length();i++){
			if(haystack.substring(i, i+needle.length()).equals(needle)){
				return i;
			}
		}
		return -1;
	}
}
