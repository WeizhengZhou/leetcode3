package additional;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<=0) return 1;
        int sum=10;
        int num=9;
        int add=9;
        int max=Math.min(10,n);
        for(int i=1;i<max;i++) {
            add*=num--;
            sum+=add;
        }       
        return sum;
    }
}
