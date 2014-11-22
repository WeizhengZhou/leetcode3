package dp;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int atoi(String str) {
        if(str==null||str.length()==0){
        	return 0;
        }
        String s=str.trim();
        if(s.length()==0){
        	return 0;
        }
        boolean isPos=true;
        int l=0;
        if(s.charAt(0)>='0'&&s.charAt(0)<='9'){
        	l=0;
        }
        else if(s.charAt(0)=='+'||s.charAt(0)=='-'){
        	if(s.charAt(0)=='-'){
        		isPos=false;
        	}
        	l=1;
        }
        else{
        	return 0;
        }
        int num=0;
        if(s.charAt(l)>='0' && s.charAt(l)<='9'){
        	num+=Integer.parseInt(s.substring(l, l+1));
        	int i=l;
        	while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
        		i++;
        		if(isPos&&num>((Integer.MAX_VALUE-Integer.parseInt(s.substring(i, i+1)))/10)){
        			return Integer.MAX_VALUE;
        		}
        		if(!isPos&& (-num)< ((Integer.MIN_VALUE+Integer.parseInt(s.substring(i, i+1)))/10)){
        			return Integer.MIN_VALUE;
        		}
        		num=num*10+Integer.parseInt(s.substring(i, i+1));
        	}
        }
        else{
        	return 0;
        }
        return isPos?num:-num;
    }

}
