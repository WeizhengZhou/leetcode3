package zz;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String intToRoman(int num){
		if(num<=0 || num>3999){
			return "";
		}
		char[] Ones=new char[]{'I','X','C','M'};
		char[] Fives=new char[]{'V','L','D'};
		StringBuilder res=new StringBuilder();
		int divisor=1000;
		int index=3;
		int dividend=num;
		while(index>=0){
			int cur=dividend/divisor;
			dividend=dividend%divisor;
			divisor/=10;
			if(cur>0){
				if(cur<=3){
					for(int i=0;i<cur;i++){
						res.append(Ones[index]);
					}
				}
				else if(cur==4){
					res.append(Ones[index]);
					res.append(Fives[index]);
				}
				else if(cur<=8){
					res.append(Fives[index]);
					for(int i=0;i<cur-5;i++){
						res.append(Ones[index]);
					}
				}
				else{
					res.append(Ones[index]);
					res.append(Ones[index+1]);
				}
			}
			index--;
		}
		return res.toString();
	}

}
