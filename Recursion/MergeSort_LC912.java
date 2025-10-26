package Recursion;

public class MergeSort_LC912 {
  
  public static void mergeSort(int[] arr)
  {
    if(arr.length<2)
    {
      return;
    }
    int mid=arr.length/2;
    int[] left=new int[mid];
    int[] right=new int[arr.length-mid];
    for(int i=0;i<mid;i++)
    {
      left[i]=arr[i];
    }
    for(int i=mid;i<arr.length;i++)
    {
      right[i-mid]=arr[i];
    }
    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right, mid,arr.length-mid);
  }

  public static void merge(int[] arr, int[] leftarr, int[] rightarr, int left, int right)
  {
    int i=0,j=0,k=0;
    while(i<left&&j<right)
    {
      if(leftarr[i]<=rightarr[j])
      {
        arr[k++]=leftarr[i++];
      }
      else
      {
        arr[k++]=rightarr[j++];
      }
    }
    while(i<left)
    {
      arr[k++]=leftarr[i++];
    }
    while(j<right)
    {
      arr[k++]=rightarr[j++];
    }
  }
  public static void main(String[] args) {
    int[] array=new int[]{38,27,43,3,9,82,10};
    mergeSort(array);
    for(int element:array)
    {
      System.out.println(element);
    }
  }
}
