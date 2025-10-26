package Recursion;

public class StringReversal {

  public String stringReversal(String input)
  {
    if(input.equals(""))
    {
      return "";
    }
    return stringReversal(input.substring(1))+input.charAt(0);
  }
  public static void main(String[] args)
  {
    String string ="hello";
    StringReversal stringReversal=new StringReversal();
    System.out.println(stringReversal.stringReversal(string));
  }
}
