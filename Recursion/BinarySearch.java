package Recursion;

public class BinarySearch {

  public static int binarySearch(int [] arr, int left, int right, int x)
  {
    if(left>right)
    {
      return -1;
    }
    int mid=(left+right)/2;
    if(x==arr[mid])
    {
      return mid;
    }
    if(x<arr[mid])
    {
      return binarySearch(arr, left, mid-1, x);
    }
    return binarySearch(arr, mid+1, right, x);
  }
  public static void main(String [] args)
  {
    int[] A={-1,0,1,2,3,4,7,9,10,20};
    int index=binarySearch(A, 0, A.length-1,30);
    System.out.println("element found at index : "+index);
  }
}
