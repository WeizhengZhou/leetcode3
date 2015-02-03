//zz reviewed
package zz;

public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigzagConversion z=new ZigzagConversion();
		System.out.println(z.convert("ABC", 2));
	}
	public String convert(String s, int nRows) {
		if(s==null || s.length()<=2 ||nRows==1){
			return s;
		}
		StringBuilder[] sbs=new StringBuilder[nRows];
		for(int j=0;j<nRows;j++){
			sbs[j]=new StringBuilder();
		}
		int total=2*nRows-2;
		//System.out.println(total);
		for(int i=0;i<s.length();i++){
			char cur=s.charAt(i);
			int index=i%total;
			//System.out.println(i+" "+index);
			if(index>=nRows){
				index=index%nRows;
				index=nRows-2-index;
			}
			//System.out.println(index);
			sbs[index].append(cur);
		}
		StringBuilder res=new StringBuilder();
		for(int j=0;j<nRows;j++){
			res.append(sbs[j].toString());
		}
		return res.toString();
	}

}
