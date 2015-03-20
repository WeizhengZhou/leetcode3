package xx;

public class Roman2Integer {
	public int romanToInt(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		int pre=0;
		int sum=0;
		for(int i=s.length()-1;i>=0;i--){
		    int digit=getLetterValue(s.charAt(i));
		    if(digit>=pre) {sum+=digit;}
		    else{sum-=digit;}
		    pre=digit;
		}
		return sum;
	}
	public int getLetterValue(char c){
		switch(c){
		case 'I':{
			return 1;
		}
		case 'V':{
			return 5;
		}
		case 'X':{
			return 10;
		}
		case 'L':{
			return 50;
		}
		case 'C':{
			return 100;
		}
		case 'D':{
			return 500;
		}
		case 'M':{
			return 1000;
		}
		default:{
			return 0;
		}
		}
	}
}
