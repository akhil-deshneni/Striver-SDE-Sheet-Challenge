import java.util.*;
public class threeSum {

    public void approachOne(int[] nums,List<List<Integer>> ans){
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n;j++) {
                for(int k=j+1;k<n;k++){
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        
                        temp.add(nums[i]);temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);
                        temp = new ArrayList<>();
                    }
                }
            }
            while(i < n && nums[i] == nums[i+1]) i+=1;
        }
    }

    public List<List<Integer>> triplets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();;
        approachOne(nums,ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};
        threeSum ts = new threeSum();
        List<List<Integer>> ans = ts.triplets(arr);
        System.out.println(ans);
    }
}
