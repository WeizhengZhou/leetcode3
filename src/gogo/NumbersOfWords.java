package gogo;

public class NumbersOfWords {
    // billion: 1,000,000,000
    // million: 1,000,000
    // thousand: 1,000
	public String numberToWords(int num) {
        if(num==0) return "Zero";
        int[] nums = new int[4];
        String[] bases=new String[4];
        bases[0] ="";
        bases[1] = "Thousand";
        bases[2] = "Million";
        bases[3] = "Billion";
        for(int i=0;i<4;i++){
        	nums[i]=num%1000;
        	num=num/1000;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=3;i>=0;i--) {
        	if (nums[i]!=0) {
        		String hundreds=helper(nums[i]);
                if(sb.length()>0) {sb.append(" ");}
        		sb.append(hundreds.trim());
        		sb.append(" ");
        		sb.append(bases[i]);
        	}
        }
        return sb.toString().trim();
    }
    
    private String helper(int n){
    	int[] nums = new int[3];
    	for(int i=0;i<3;i++) {
    		nums[i]=n%10;
    		n=n/10;
    	}
    	StringBuilder sb=new StringBuilder();
    	if (nums[2]!=0){
    		sb.append(ones(nums[2]));
            sb.append(" ");
    		sb.append("Hundred");
    	}
    	if (nums[1]>1) {
    		if(sb.length()>0) sb.append(" ");
    		sb.append(tens(nums[1]));
        	if (nums[0] !=0) {
        		if(sb.length()>0) sb.append(" ");
        		sb.append(ones(nums[0]));
        	}
    	} else if (nums[1]==1) {
            if(sb.length()>0) sb.append(" ");
    		sb.append(teens(nums[0]));
    	} else {
            if(sb.length()>0) sb.append(" ");
            sb.append(ones(nums[0]));
        }
    	return sb.toString();
    }
    
    private String teens(int n){
    	switch (n) {
    		case 0: return "Ten";
			case 1: return "Eleven";
			case 2: return "Twelve";
			case 3: return "Thirteen";
			case 4: return "Fourteen";
			case 5: return "Fifteen";
			case 6: return "Sixteen";
			case 7: return "Seventeen";
			case 8: return "Eighteen";
			case 9: return "Nineteen";
			default: return "";
    	}
    }
    
    private String ones(int n){
    	switch (n) {
    		case 1: return "One";
    		case 2: return "Two";
    		case 3: return "Three";
    		case 4: return "Four";
    		case 5: return "Five";
    		case 6: return "Six";
    		case 7: return "Seven";
    		case 8: return "Eight";
    		case 9: return "Nine";
    		default: return "";
    	}
    }
    private String tens(int n){
    	switch (n) {
    		case 2: return "Twenty";
    		case 3: return "Thirty";
    		case 4: return "Forty";
    		case 5: return "Fifty";
    		case 6: return "Sixty";
    		case 7: return "Seventy";
    		case 8: return "Eighty";
    		case 9: return "Ninety";
    		default: return "";
    	}
    }
}
