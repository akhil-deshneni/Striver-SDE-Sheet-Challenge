import java.util.*;

public class ducthFlag {

    public void sortColors(int[] nums){
        int zero = 0 , one = 0;
        for(int num:nums){
            zero = num  == 0 ? ++zero : zero;
            one = num == 1 ? ++one : one;
        }
        // System.out.println(one+" "+zero);
        int k = 0 , two = zero+one;
        while(zero-- > 0){
            nums[k++] = 0;
        }
        while(one-- > 0){
            nums[k++] = 1;
        }
        for(int i=two;i<nums.length;i++){
            nums[i] = 2;
        }        
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColorsInplace(int[] nums){
        int white = 0 , blue = 0, red = nums.length-1;
        // int k = 0;
        while(blue <= red){
            if(nums[blue] == 0){
                swap(nums,white,blue);
                white++;
                blue++;
            }else if(nums[blue] == 2){
                swap(nums,red,blue);
                red--;
            }else {
                blue++;
            }
        }
    }

    public static void main(String[] args) {
        ducthFlag df = new ducthFlag();
        int arr[] = {2,0,2,1,1,0};
        df.sortColorsInplace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
