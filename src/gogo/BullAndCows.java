package gogo;

public class BullAndCows {
    public String getHint(String secret, String guess) {
        int bulls=0;
		int cows=0;
		char[] s=new char[10];
		char[] g=new char[10];
		for(int i=0;i<secret.length();i++) {
			char sChar=secret.charAt(i);
			char gChar=guess.charAt(i);
			if (sChar==gChar) {
				bulls++;
			} else {
				s[sChar-'0']++;
				g[gChar-'0']++;
			}
		}
		for(int i=0;i<10;i++) {
			cows+=Math.min(s[i],g[i]);
		}
		return bulls+"A"+cows+"B";
    }
}
