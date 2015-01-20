
//zz, see my code below
package zz;

import java.util.Arrays;

public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersion c=new CompareVersion();
		System.out.println(c.compareVersion("01", "1"));

	}
	
	public int compareVersion(String version1, String version2) {
		int[] v1=new int[version1.length()];
		int[] v2=new int[version2.length()];
		int i1=0;
		int i2=0;
		int n1=0;
        int n2=0;
        int digit=0;
        int i=0;
		while(i1<version1.length()){
        	if(version1.charAt(i1)!='.'){
        		digit=version1.charAt(i1)-'0';
        		//System.out.println(digit);
        		n1=n1*10+digit;
        	}
        	else{
        		v1[i]=n1;
        		i++;
        		n1=0;
        	}
        	i1++;
		}
		v1[i]=n1;
		i=0;
		while(i2<version2.length()){
        	if(version2.charAt(i2)!='.'){
        		digit=version2.charAt(i2)-'0';
        		//System.out.println(digit);
        		n2=n2*10+digit;
        	}
        	else{
        		v2[i]=n2;
        		i++;
        		n2=0;
        	}
        	i2++;
		}
		v2[i]=n2;
		System.out.println(Arrays.toString(v1));
		System.out.println(Arrays.toString(v2));
		int j=0;
		for(j=0;j<Math.min(v1.length, v2.length);j++){
			if(v1[j]<v2[j]){
				return -1;
			}
			else if(v1[j]>v2[j]){
				return 1;
			}
		}
		int[] big=v1.length >v2.length?v1:v2;
		for(;j<big.length;j++){
			if(big[j]>0){
				return big==v1?1:-1;
			}
		}
		return 0;
		
	}
	
	public int compareVersion1(String version1, String version2) {
        int i1=0;
        int i2=0;
        int n1=0;
        int n2=0;
        int digit=0;
        while(i1<version1.length() && i2 <version2.length()){
        	//System.out.println("i1="+i1+",i2="+i2);
        	if(version1.charAt(i1)!='.'){
        		digit=version1.charAt(i1)-'0';
        		//System.out.println(digit);
        		n1=n1*10+digit;
        		i1++;
        	}
        	if(version2.charAt(i2)!='.'){
        		digit=version2.charAt(i2)-'0';
        		n2=n2*10+digit;
        		i2++;
        	}
        	if(i1<version1.length()&& i2<version2.length()&& version1.charAt(i1)=='.' && version2.charAt(i2)=='.'){
        		//System.out.println("n1="+n1+",n2="+n2);
        		if(n1<n2){
        			return -1;
        		}
        		else if(n1>n2){
        			return 1;
        		}
        		n1=0;
        		n2=0;
        		i1++;
        		i2++;
        	}
        }
        
        //System.out.println("break");
        while(i1<version1.length()){
        	if(version1.charAt(i1)!='.'){
	        	digit=version1.charAt(i1)-'0';
	    		//System.out.println(digit);
	    		n1=n1*10+digit;
        	}
        	i1++;

        }
        while(i2<version2.length()){
        	if(version2.charAt(i2)!='.'){
	        	digit=version2.charAt(i2)-'0';
	    		//System.out.println(digit);
	    		n2=n2*10+digit;
	    		i2++;
        	}
        	i2++;
        }
        if(n1<n2){
			return -1;
		}
		else if(n1>n2){
			return 1;
		}
		else{
			return 0;
		}
    }

}
/*

//zz, use Version class and implement Comparable interface
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CompareVersionNumbers {
	public static void main(String[] args){
		Version a = new Version("13.0");
		Version b = new Version("13.0.8");
		Version c = new Version("0.2");
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.compareTo(b));
//		System.out.println(a.compareTo(b));
//		System.out.println(a.compareTo(c));
	}

}

class Version implements Comparable{
	int[] v;
	public Version(String s){
		if(s == null || s.length() == 0){
			v = new int[0];
		}
		else{
			List<Integer> list = new LinkedList<>();
			int num = 0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i) == '.'){
					if(i!=0)
						list.add(num);
					num = 0;
				}
				else{
					num = num*10+ Integer.parseInt(s.substring(i,i+1)); 
				}
			}
		    list.add(num);
			v = new int[list.size()];
			for(int i=0;i<list.size();i++){
				v[i] = list.get(i);
			}
		}
			
	}
	public String toString(){
		return Arrays.toString(v);
	}
	@Override
	public int compareTo(Object o) {
		Version other = (Version) o;
		int i=0;
		int j=0;
		while(i<this.v.length && j<other.v.length){
			if(this.v[i] < other.v[j])
				return -1;
			else if(this.v[i] > other.v[j])
				return 1;
			i++;
			j++;
		}
		while(i<this.v.length || j<other.v.length){
			if(i<this.v.length){
				if(this.v[i] !=0) return 1;
				i++;
			}
			if(j<other.v.length){
				if(other.v[i]!=0) return -1;
				j++;
			}
		}
		return 0;
	}	
}

*/
