package gogo;

public class Zigzag {
	public static void main(String[] args) {
		Zigzag z=new Zigzag();
		System.out.println(z.convert("ABCD", 3));
	}
	public String convert(String s, int numRows) {
        if (s==null || s.length()<=2 || numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
        	sb[i] = new StringBuilder();
        }
        int size = s.length();
        for (int i=0; i<size; i++) {System.out.println("i="+i);
        	int index = (i+1)%(numRows*2 - 2); System.out.println("index="+index);
        	if (index == 0) index=numRows*2 - 2;
        	if (index<=numRows) {System.out.println("seq:"+index);
        		sb[index-1].append(s.charAt(i));
        	} else {
        		index = 2* numRows - index; System.out.println("res:"+index);
        		sb[index-1].append(s.charAt(i));
        	}
        }
        StringBuilder re = new StringBuilder();
        for (int i=0; i<numRows;i++) {System.out.println(sb[i].toString());
        	re.append(sb[i].toString());
        }
        return re.toString();
    }
}
