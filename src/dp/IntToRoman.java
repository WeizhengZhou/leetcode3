package dp;

public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	String[] one =new String[]{"I","X","C","M"};
	String[] five =new String[]{"V","L","D",""};
    public String intToRoman(int num) {
        int d=0;
        int r=1;
        int s=num;
        while(s/r/10!=0){
        	d++;
        	r*=10;
        }
        StringBuilder sb=new StringBuilder();
        while(num!=0){
        	int digit=num/r;
        	num=num%r;
        	sb.append(getString(digit,d));
        	d--;
        	r/=10;
        }
        return sb.toString();
    }
    public String getString(int digit,int d){
    	switch(digit){
    	case 1:{
    		return one[d];
    	}
    	case 2:{
    		return one[d]+one[d];
    	}
    	case 3:{
    		return one[d]+one[d]+one[d];
    	}
    	case 4:{
    		return one[d]+five[d];
    	}
    	case 5:{
    		return five[d];
    	}
    	case 6:{
    		return five[d]+one[d];
    	}
    	case 7:{
    		return five[d]+one[d]+one[d];
    	}
    	case 8:{
    		return five[d]+one[d]+one[d]+one[d];
    	}
    	case 9:{
    		return one[d]+one[d+1];
    	}
    	default:{
    		return "";
    	}
    	}
    }
}
