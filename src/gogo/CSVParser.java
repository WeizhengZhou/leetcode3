package gogo;

public class CSVParser {
	public static void main(String[] args) {
		CSVParser c=new CSVParser();
		String s=c.csvParser("\"\"Alexandra Alex\"\"");
		System.out.println(s);
	}
	
	public String csvParser(String s) {
		if (s==null || s.length()==0) return "";
		String[] a=s.split(",");
		StringBuilder sb=new StringBuilder();
		
		int i=0;
		while(i<a.length) {
			String part=a[i];
			part=part.replaceAll("\"\"", "\"");
			//System.out.println(part);
			if (part==null || part.length()==0) continue;
			char first=part.charAt(0);
			if (first != '"') {
				if(sb.length()>0) sb.append('|');
				sb.append(part);
				i++;
			} else {
				int count=1;
				int j=1;
				StringBuilder sub=new StringBuilder();
				sub.append(part);
				while(j<part.length()) {
					if (part.charAt(j)=='"') count++;
					if (j==part.length()-1 && count%2!=0) {
						i++;
						part=a[i];
						part=part.replaceAll("\"\"", "\"");
						sub.append(',');
						sub.append(part);
					}
					j++;
				}
				String subS=sub.toString();//System.out.println(subS);
				if(sb.length()>0) sb.append('|'); 
				sb.append(subS.substring(1,subS.length()-1));
				i++;
			}
		}
		return sb.toString();
	}
}
