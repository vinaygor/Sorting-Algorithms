/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.all.algorithms;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class SortingAlgorithms {

    
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n = k.nextInt();
        int arr[] = new int[n];
        int partial[]=new int[n];
        for(int i=1;i<=n;i++)
        {
            arr[i-1]=i;
        }
        for(int i=0;i<n/2;i++)
            partial[i]=arr[i];
        
        int temp[]=new int[n];
        
        //knuth(arr);
        copyArr(arr,temp);
       
        //////////////////////////////////////////////////////////////////////
       /////////////////MERGE SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
        
       System.out.println("Merge Sort:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
           getOldArray(temp,arr);
        //   System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
      // mergeSort(arr,0,arr.length-1);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
           //System.out.println("---------------------------");
       }
       
       //////////////////////////////////////////////////////////////////////
       /////////////////HEAP SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
       System.out.println("Heap Sort:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
          getOldArray(temp,arr);
         //  System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
       //heapSort(arr);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
           //System.out.println("---------------------------");
       }
       
       //////////////////////////////////////////////////////////////////////
       /////////////////SELECTION SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
       System.out.println("Selection Sort:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
           getOldArray(temp,arr);
         //  System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
          // selectionSort(arr);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
           //System.out.println("---------------------------");
       }
       
        //////////////////////////////////////////////////////////////////////
       /////////////////INSERTION SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
       System.out.println("INSERTION SORT:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
           getOldArray(temp,arr);
          // System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
          insertionSort(arr,0,arr.length);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
           //System.out.println("---------------------------");
       }
       
        //////////////////////////////////////////////////////////////////////
       /////////////////QUICK SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
       System.out.println("QUICK SORT:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
           getOldArray(temp,arr);
           //System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
           quickSort(arr,0,arr.length-1);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
           //System.out.println("---------------------------");
       }
       
        //////////////////////////////////////////////////////////////////////
       /////////////////QUICK SORT////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
       System.out.println("Combined Algo: Quick-Insertion SORT:\n--------------------------------");
       for(int i=0;i<10;i++)
       {
           
           getOldArray(temp,arr);
         //  System.out.println("Round :"+(i+1));
           long start=System.nanoTime();
           combinedAlgo(arr,0,arr.length-1);
       long end=System.nanoTime();
       long elapsedTime=(end-start); 
       System.out.println(elapsedTime);
          // System.out.println("---------------------------");
       }
    }
    
    static void mergeSort(int arr[],int l,int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void display(int arr[]) {
        for (int a : arr) {
            System.out.print(a+" ");
        }
        System.out.println("");
    }
    
     static void knuth(int[] arr) {
         int de[]= new int[arr.length/2];
         
    Random r = new Random();
    for (int i = arr.length/2 - 1; i > 0; i--) {
      int index = r.nextInt(i);
      // swap 
      int tmp = arr[index];
      arr[index] = arr[i];
      arr[i] = tmp;
    }
  }
     
     public static void heapify(int arr[],int n, int i)
    {
        
        int largest = i;
        int l=2*i+1;
        int r=2*i+2;
        
        if(l<n && arr[l]>arr[largest])
            largest=l;
        
        if(r<n && arr[r]>arr[largest])
            largest=r;
        
        if(largest!=i)
        {
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;
            
            heapify(arr,n,largest);
        }
    }
     
     public static void heapSort(int arr[])
    {
        int n=arr.length;
        for(int i = (n-2)/2;i>=0;--i)
        {
            heapify(arr,n,i);
        }
        
        for(int i=n-1;i>=0;i--)
        {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,i,0);
        }
    }
     
     public static void selectionSort(int arr[])
     {
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
     }
     
     public static void insertionSort(int arr[],int l,int h)
     {
         for(int a=(l+1);a<h;a++)
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
     }
     
     public static void quickSort(int arr[],int lowerIndex,int higherIndex)
    {
//        if(low<high)
//        {
//            int pi=partition(arr, low, high);
//            quickSort(arr,low,pi-1);
//            quickSort(arr,pi+1,high);
//            
//        }
        
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = arr[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(arr,lowerIndex, j);
        if (i < higherIndex)
            quickSort(arr,i, higherIndex);

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
      
      public static void copyArr(int arr[],int temp[])
      {
          for(int i=0;i<arr.length;i++)
              temp[i]=arr[i];
      }
      
      static void getOldArray(int temp[],int arr[])
      {
          for(int i=0;i<arr.length;i++)
              arr[i]=temp[i];
      }
      
      static void combinedAlgo(int arr[],int lowerIndex,int higherIndex)
      {
         
            if((higherIndex-lowerIndex)<49)
            {
                insertionSort(arr,lowerIndex,higherIndex);
            }

    
          int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = arr[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            combinedAlgo(arr,lowerIndex, j);
        if (i < higherIndex)
            combinedAlgo(arr,i, higherIndex);

          
//        if(low<high)
//        {
//            if((high-low)<9)
//            {
//                insertionSort(arr,low,high);
//            }
//            int pi=partition(arr, low, high);
//            if(pi-low <= high-(pi+1))
//            {
//            combinedAlgo(arr,low,pi);
//            low=pi+1;
//            }
//            else
//            {
//            combinedAlgo(arr,pi+1,high);
//            high=pi;
//            }
//        }
    
      }
}
