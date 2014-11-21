package dp;

public class ZigZagConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConvert z=new ZigZagConvert();
		System.out.println(z.convert("A", 1));
	}
    public String convert(String s, int nRows) {
        if(s==null||s.length()==0){
        	return "";
        }
        if (nRows==1){
        	return s;
        }
        StringBuilder[] sbs=new StringBuilder[nRows];
        for(int k=0;k<nRows;k++){
        	sbs[k]=new StringBuilder();
        }
        int len=2*nRows-2;
        for(int i=0;i<s.length();i++){
        	int j=i%len;
        	if(j<nRows){
        		sbs[j].append(s.charAt(i));
        	}
        	else{
        		sbs[nRows-(j+1)%nRows-1].append(s.charAt(i));
        	}
        }
        StringBuilder res=new StringBuilder();
        for(int k=0;k<nRows;k++){
        	res.append(sbs[k]);
        }
        return res.toString();
    }
}
