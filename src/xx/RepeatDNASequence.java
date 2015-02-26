package xx;

public class RepeatDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new LinkedList<>();
        if(s==null || s.length()==0) {return res;}
        Map<Long,Integer> map = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            long digits = DNA2Digits(s.substring(i,i+10));
            if(!map.containsKey(digits)){
                map.put(digits,1);
            }
            else{
                map.put(digits,map.get(digits)+1);
                if(map.get(digits) == 2)
                    res.add(s.substring(i,i+10));
            }
        }
        return res;
    }
    private long DNA2Digits(String s){
            long res = 0;
            for(int i=0;i<s.length();i++){
                res = res *10 + parseDigit(s.charAt(i));
            }
            return res;
        }
    private int parseDigit(char c){
            if(c=='A') return 1;
            else if(c=='C') return 2;
            else if(c=='G') return 3;
            else if(c=='T') return 4;
            else return 0;
        }
}
