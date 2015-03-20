package xx;

public class ZigzagConversion {
	public String convert(String s, int nRows) {
		if(s==null || s.length()==0 || nRows<=1){return s;}
		StringBuilder[] sb=new StringBuilder[nRows];
		for(int i=0;i<nRows;i++){sb[i]=new StringBuilder();}
		int cycle=2*nRows-2;
		for(int i=0;i<s.length();i++){
			int index=i%cycle;
			if(index>=nRows)
			{
				index=index%nRows;
				index=nRows-2-index;
			}
			sb[index].append(s.charAt(i));
		}
		StringBuilder res=new StringBuilder();
		for(int i=0;i<nRows;i++){res.append(sb[i].toString());}
		return res.toString();

	}
}
