
public class StringInterval {
	public boolean isInter(String s1, String s2, String sum){
		if(sum == null) return s1 == null && s2 == null;
		if(s1 == null) return sum.equals(s2);
		if(s2 == null) return sum.equals(s1);
		int i=0;
		int j=0;
		while(i < s1.length() || j < s2.length()){
			if(i >= s1.length()){
				if(s2.charAt(j) == sum.charAt(i+j))
					j++;
				else
					return false;
			}
			else if(j >= s1.length()){
				if(s1.charAt(i) == sum.charAt(i+j))
					i++;
				else
					return false;
			}
			else if(s1.charAt(i) == sum.charAt(i+j)){
				i++;
			}
			else if(s2.charAt(j) == sum.charAt(i+j)){
				j++;
			}
			else
				return false;
		}
		return true;
	}

}
