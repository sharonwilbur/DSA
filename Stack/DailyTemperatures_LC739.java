import java.util.Stack;

public class DailyTemperatures_LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result= new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i])
            {
                stack.pop();
            }
            result[i]=(stack.isEmpty()) ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        DailyTemperatures_LC739 solver = new DailyTemperatures_LC739();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solver.dailyTemperatures(temps);
        for (int days : res) {
            System.out.print(days + " ");
        } 
        // Expected output: 1 1 4 2 1 1 0 0
    }
}
