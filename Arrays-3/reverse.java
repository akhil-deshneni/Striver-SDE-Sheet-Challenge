import java.util.*;

public class reverse {

    int ans = 0;

    public int Approach1(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > nums[j]*2)
                    count++;
            }
        }
        return count;
    }

    public void mergeSort(int[] nums,int start,int mid,int end) {
        List<Integer> temp = new ArrayList<>();
        int left = start;
        int right = mid+1;

        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= end){
            temp.add(nums[right]);
            right++;
        }
        System.out.println(temp);
        for(int i=start;i<=end;i++){
            nums[i] = temp.get(i-start);
        }
    }

    public int countPairs(int[] nums,int start,int mid,int end){
        int right = mid + 1;
        int cnt = 0;
        for(int i = start; i <= mid; i++){
            while(right <= end && nums[i] > 2 * nums[right]) right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }

    public int divideAndConquer(int[] nums,int start,int end){
        int cnt = 0;
        if(start >= end) return 0;
        int mid = start + (end-start)/2;
        // System.out.println(start+"--->"+end);
        cnt += divideAndConquer(nums, start, mid);
        cnt += divideAndConquer(nums, mid+1, end);
        cnt += countPairs(nums,start,mid,end);
        mergeSort(nums,start,mid,end);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        // int ans = Approach1(nums);
        ans = divideAndConquer(nums,0,nums.length-1);
        return ans;
    }

    public static void main(String[] args) {
        reverse rp = new reverse();
        int[] ans = {1,3,2,3,1};
        int result = rp.reversePairs(ans);
        System.out.println(result);
    }
}