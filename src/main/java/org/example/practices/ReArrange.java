package org.example.practices;

public class ReArrange {

    static void rearrange(int[] arr, int n){
        int j=0, temp;
        for (int i = 0; i<n; i++){
            if (arr[i] < 0){
                if (i != j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    static void printArray(int[] arr, int n){
        for (int i: arr){
            System.out.print(i + " ");
        }
    }


    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { -1, 2,  -4, -5, 7};
        int n = arr.length;
        rearrange(arr, n);
        printArray(arr, n);

    }
}

