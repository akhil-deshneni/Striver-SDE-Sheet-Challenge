import java.util.*;

public class repeatMissing {

    private int findRepeatingNumber(int[] nums,int n){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    private boolean numberExists(int[] nums,int num){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == num) 
                return true;
        }
        return false;
    }

    private int findMissingNumber(int[] nums,int n){
        for(int i=1;i<=n;i++){
            boolean flag = numberExists(nums,i);
            if(!flag)
                return i;
        }
        return -1;
    }

    private int[] repeatedNumberBruteForce(int[] nums){
        int[] ans = new int[2];
        int n = nums.length;
        ans[0] = findRepeatingNumber(nums,n);
        ans[1] = findMissingNumber(nums,n);
        return ans;
    }

    private int[] repatedNumberHash(int[] nums){
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            lookup.put(i,0);
        }
        for(int num:nums){
            lookup.put(num,lookup.getOrDefault(num,0)+1);
        }
        int[] ans = new int[2];
        for(Map.Entry<Integer,Integer> num:lookup.entrySet()){
            if(num.getValue() == 2){
                ans[1] = num.getKey();
            }else if(num.getValue() == 0){
                ans[0] = num.getKey();
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        repeatMissing rm = new repeatMissing();
        int arr[] = {3,1,2,5,3};
        int[] ans;
        // ans = rm.repeatedNumberBruteForce(arr);
        ans = rm.repatedNumberHash(arr);
        System.out.println("Missing number is: "+ans[0]+"\nRepeating number is: "+ans[1]);
        // System.out.println(Arrays.toString(ans));
    } 
}