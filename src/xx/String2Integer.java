package xx;

public class String2Integer {
	public int atoi(String str) {
        if(str==null){return 0;}
        str=str.trim();
        if(str.length()==0){return 0;}
        boolean isPo=true;
        int start=0;
        char first=str.charAt(0);
        if(first!='+'&&first!='-'&&(first>'9'||first<'0'))return 0;
        if(first=='+'){start++;}
        else if(first=='-'){isPo=false;start++;}
        long num=0;
        int i=start;
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            num*=10;
            num+=str.charAt(i)-'0';
            if(isPo&&num>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(!isPo && -num<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            i++;
        }
        //if(isPo&&num>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        //if(!isPo && -num<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return isPo?(int)num:-(int)num;
    }
}
