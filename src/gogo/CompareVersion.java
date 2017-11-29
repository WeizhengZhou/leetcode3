package gogo;

public class CompareVersion {
	public static void main(String[] args) {
		CompareVersion c = new CompareVersion();
		System.out.println(c.compareVersion("1.0", "1"));
		String[] p="0.1".split("\\.");
		for(String s:p){
			System.out.println(s);
		}
	}
	public int compareVersion(String version1, String version2) {
        if (version1==null ||version1.length()==0) return -1;
        if (version2==null || version2.length()==0) return 1;
        String[] parts1 = version1.split("\\.",2);
        String[] parts2 = version2.split("\\.",2); 
        String m1=parts1.length>0 ? parts1[0]: version1;
        String m2=parts2.length>0 ? parts2[0]: version2;
        int major = compare(m1,m2);
        if (major!=0) {
        	return major;
        }
        if (parts1.length==1 && parts2.length==1) return 0;
        String n1="0";
        String n2="0";
        if (parts1.length>1) {
        	n1=parts1[1];
        }
        if (parts2.length>1) {
        	n2 = parts2[1];
        }
        return compareVersion(n1, n2);
    }
    
    private int compare(String s1, String s2) {
        int i=0;
        while(i<s1.length() && s1.charAt(i)=='0') {
        	i++;
        }
        s1=s1.substring(i);
        i=0;
        while(i<s2.length() && s2.charAt(i)=='0') {
        	i++;
        }
        s2=s2.substring(i);
    	if (s1.length()>s2.length()) return 1;
        if (s1.length()<s2.length()) return -1;
        for (int ii=s1.length()-1;ii>=0;ii--){
        	char c1=s1.charAt(ii);
        	char c2=s2.charAt(ii);
        	if (c1>c2) return 1;
        	if(c1<c2) return -1;
        }
        return 0;
    }
}
