/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n=k.nextInt();
        
        
        int arr[]=new int[n];
        int i=0;
        k.nextLine();
        String s = k.nextLine();
        for(String str:s.split(" "))
        {
            arr[i++]=Integer.parseInt(str);
        }
        
        sort(arr,0,n-1);
        
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i =(low-1);
        
        for(int j=low;j<=high-1;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
         int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
    public static void sort(int arr[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(arr, low, high);
            
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }
}
