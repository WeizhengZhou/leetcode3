package xx;

public class CompareVersionNumber {
	public int compareVersion(String version1, String version2) {
        if(version1==null && version2==null || version1.length()==0 && version2.length()==0){return 0;}
        if(version1==null||version1.length()==0){return -1;}
        if(version2==null||version2.length()==0){return 1;}
        List<Long> num1=convert(version1);
        List<Long> num2=convert(version2);
        return compare(num1,num2);
    }
    private List<Long> convert(String s){
        List<Long> res=new LinkedList<>();
        int i=0;
        while(i<s.length()){
            int start=i;
            while(i<s.length()&&s.charAt(i)!='.'){i++;}
            res.add(Long.parseLong(s.substring(start,i++)));
        }
        return res;
    }
    private int compare(List<Long> l1,List<Long> l2){
        int i=0;
        int len1=l1.size()-1;
        int len2=l2.size()-1;
        while(len1>=0 && l1.get(len1)==0){len1--;}
        while(len2>=0 && l2.get(len2)==0){len2--;}
        while(i<=len1&&i<=len2){
            Long num1=l1.get(i);
            Long num2=l2.get(i++);
            if(num1!=num2){return num1-num2>0?1:-1;}
        }
        if(len1==len2)return 0;
        return len1-len2>0?1:-1;
    }
}
