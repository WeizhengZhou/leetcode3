package xx;

public class Integer2Roman {
	public String intToRoman(int num){
		if(num<=0 || num>3999){
			return "";
		}
		char[] Ones=new char[]{'I','X','C','M'};
		char[] Fives=new char[]{'V','L','D'};
		int divisor=1000;
		StringBuilder buf=new StringBuilder();
		int n=num;
		int i=3;
		while(i>=0){
		    int cur=n/divisor;
		    if(cur>0){
		        build(i,cur,buf,Ones,Fives);
		    }
		    n=n%divisor;
		    divisor/=10;
		    i--;
		}
		return buf.toString();
	}
	private void build(int i,int digit,StringBuilder buf,char[] Ones,char[] Fives){
	    if(digit<=3){
	        for(int j=0;j<digit;j++){
	            buf.append(Ones[i]);
	        }
	    }
	    else if(digit==4){
	        buf.append(Ones[i]);
	        buf.append(Fives[i]);
	    }
	    else if(digit==5){
	        buf.append(Fives[i]);
	    }
	    else if(digit>5 && digit<9){
	        buf.append(Fives[i]);
	        for(int j=0;j<digit-5;j++){
	            buf.append(Ones[i]);
	        }
	    }
	    else if(digit==9){
	        buf.append(Ones[i]);
	        buf.append(Ones[i+1]);
	    }
	}
}
