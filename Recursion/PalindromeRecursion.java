package Recursion;

public class PalindromeRecursion {
  
  public static boolean palindrome(String input)
  {
    if(input.length()==0|| input.length()==1)
    {
      return true;
    }
    if(input.charAt(0)==input.charAt(input.length()-1))
    {
      return palindrome(input.substring(1, input.length()-1));
    }
    return false;
  }
  public static void main(String [] args)
  {
    String input ="racecar";
    if(palindrome(input))
    {
      System.out.println(input+" is palindrome");
    }
    else{
      System.out.println(input+" is not palindrome");
    }
  }
}
