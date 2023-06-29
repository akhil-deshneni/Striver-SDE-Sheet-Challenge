import java.util.Arrays;

public class mergeSortedArrays {

    public int[] mergeArraysUsingSpace(int[] arr1,int[] arr2,int n){
        int[] ans = new int[n+n];
        int i = 0, j = 0;
        int k = 0;
        while(i < n && j < n){
            if(arr1[i] <= arr2[j]){
                ans[k] = arr1[i];
                i++;
            }else{
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < n){
            ans[k++] = arr1[i++];
        }
        while(j < n){
            ans[k++] = arr2[j++];
        }
        return ans;
    }

    public int[] mergeArraysInplace(int[] arr1,int[] arr2,int m,int n){
        int len = arr1.length-1;
        int p1 = m-1, p2 = n-1;
        while(len >= 0 && p1 >=0 && p2 >= 0){
            if(arr1[p1] >= arr2[p2]){
                arr1[len] = arr1[p1];
                p1--;
            }else{
                arr1[len] = arr2[p2];
                p2--;
            }
            len--;
        }
        while(p1 >= 0){
            arr1[len] = arr1[p1];
            p1--; len--;
        }
        while(p2 >= 0){
            arr2[len] = arr2[p2];
            p2--; len--;
        }
        return arr1;
    }

    public static void main(String[] args) {
        mergeSortedArrays msa = new mergeSortedArrays();
        int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};
        int m = 3, n = 3;
        int ans[] = null;
        // ans = msa.mergeArraysUsingSpace(arr1,arr2,n);
        ans = msa.mergeArraysInplace(arr1, arr2, m, n);
        System.out.println(Arrays.toString(ans));
    }
}
