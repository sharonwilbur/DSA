import java.util.Stack;

public class validParanthesis_LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='(') stack.push(')');
            else if (c=='{') stack.push('}');
            else if(c=='[') stack.push(']');
            else if(stack.isEmpty()||stack.pop()!=c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        validParanthesis_LC20 vp=new validParanthesis_LC20();

        String test1 = "()[]{}";
        String test2 = "([)]";
        String test3 = "{[()]}";

        System.out.println(test1 + " is valid? " + vp.isValid(test1));  // true
        System.out.println(test2 + " is valid? " + vp.isValid(test2));  // false
        System.out.println(test3 + " is valid? " + vp.isValid(test3));  // true
    }
}
