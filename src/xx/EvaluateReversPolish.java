package xx;

public class EvaluateReversPolish {
	public int evalRPN(String[] tokens) {
		if(tokens==null || tokens.length==0){
			return 0;
		}
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<tokens.length;i++){
			String cur=tokens[i];
			if(isNumber(cur)){
				stack.push(Integer.parseInt(cur));
			}
			else if(isOperator(cur)){
				if(stack.isEmpty()){return 0;}
				int second=stack.pop();
				if(stack.isEmpty()){return 0;}
				int first=stack.pop();
				stack.push(calculate(first,second,cur));
			}
			else{return 0;}
		}
		return stack.isEmpty()?0:stack.pop();
	}

	private boolean isNumber(String cur){
		try{
			Integer.parseInt(cur);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	private boolean isOperator(String cur){
		if(cur.equals("+")||cur.equals("-")||cur.equals("*")||cur.equals("/"))
		{return true;}
		else{return false;}
	}

	private int calculate(int first, int second, String op){
		if(op.equals("+")){return first+second;}
		else if(op.equals("-")){return first-second;}
		else if(op.equals("*")){return first*second;}
		else if(op.equals("/")){return first/second;}
		else{return 0;}
	}

}
