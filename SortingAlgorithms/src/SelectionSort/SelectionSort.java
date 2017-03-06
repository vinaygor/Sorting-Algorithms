/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectionSort;

import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class SelectionSort {
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
        int min=arr[0];
        
        for(int j=0;j<arr.length;j++)
        {
            min=arr[j];
            int index=j;
            for(int c=j;c<arr.length;c++)
            {
                if(arr[c]<min)
                {
                    min=arr[c];
                    index=c;
                }
            }
            int temp = arr[j];
            arr[j]=arr[index];
            arr[index]=temp;
            
        }
        
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
}
