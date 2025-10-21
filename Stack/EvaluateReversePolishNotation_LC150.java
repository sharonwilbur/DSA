import java.util.Stack;

public class EvaluateReversePolishNotation_LC150 {

    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens)
        {
            if(s.equals("+"))// don't use "==" . Use ".equals" instead;
            {
                stack.push(stack.pop()+stack.pop());
            }
            else if(s.equals("-"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b-a);
            }
            else if(s.equals("*"))
            {
                stack.push(stack.pop()*stack.pop());
            }
            else if(s.equals("/"))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }
            else
            {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
   public static void main(String[] args) {
        EvaluateReversePolishNotation_LC150 solution = new EvaluateReversePolishNotation_LC150();
        
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = solution.evalRPN(tokens);
        
        System.out.println("Result: " + result);  // Output should be 9 (because (2 + 1) * 3 = 9)
    }
}
