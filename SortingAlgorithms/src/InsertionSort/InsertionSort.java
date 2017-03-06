/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertionSort;

import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class InsertionSort {
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
        
        for(int a=1;a<arr.length;a++)
        {
            int key = arr[a];
            int j=a-1;
            
            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1] = key;
        }
        
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
}
