//zz reviewed
package zz;

public class LongestValidParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<=1){
        	return 0;
        }
        int len=s.length();
        int[] validPL=new int[len];//zz for such a complicated dp array, you should at least write a comment to explain the meaning of this array
				  //for example, validPL[i] is the length of longest valid paren starting from index i
        validPL[len-1]=0;//zz then explian why validPL[len-1] = 0
        int max=0;//zz name->max_valid_para_len
        for(int i=len-2;i>=0;i--){
        	if(s.charAt(i)==')'){//zz simple comment why it is zero
        		validPL[i]=0;
        	}
        	else{
        		if(s.charAt(i+1)==')'){
        			int next=i+2>=len?0:validPL[i+2];
        			validPL[i]=2+next;
        		}
        		else{
        			int nextIndex=validPL[i+1]+i+1;
        			if(nextIndex>=len){
        				validPL[i]=0;
        			}
        			else{
        				if(s.charAt(nextIndex)=='('){
        					validPL[i]=0;
        				}
        				else{
        					int next=nextIndex+1>=len?0:validPL[nextIndex+1];
        					validPL[i]=2+validPL[i+1]+next;
        				}
        			}        			
        		}
        	}
        	max=Math.max(max, validPL[i]);
        }
        return max;
    }    
}
