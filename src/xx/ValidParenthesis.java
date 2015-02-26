package xx;

public class ValidParenthesis {
	public boolean isValid(String s) {
        if(s==null||s.length()<=1) return false;
        Stack<Character> stack=new Stack<>();
        for( int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){stack.push(c);}
            else{
                if(stack.isEmpty())return false;
                char top=stack.peek();
                if(c==')'&&top!='('||c==']'&&top!='['||c=='}'&&top!='{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
