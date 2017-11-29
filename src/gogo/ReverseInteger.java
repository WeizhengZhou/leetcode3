package gogo;

public class ReverseInteger {
	public int reverse(int x) {
        if (x>-10 && x<10) return x;
        int val = x > 0 ? x : -x;
        int re = 0;
        while (val != 0) {
          int remain = val % 10;
          if (re>(Integer.MAX_VALUE-remain)/10) return 0;
          re = re*10 + remain;
          val = val/10;
        }
        return x>0 ? re : -re;
    }
}
