/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BubbleSort;

import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class BubbleSort {
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
        
        for(int z=0;z<n-1;z++)
            for(int x=0;x<n-z-1;x++)
            {
                if(arr[x]>arr[x+1])
                {
                    int temp=arr[x];
                    arr[x]=arr[x+1];
                    arr[x+1]=temp;
                }
            }
        
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
}
