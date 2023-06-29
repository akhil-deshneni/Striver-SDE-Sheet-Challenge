import java.util.*;

public class duplicateNumber {

    public int Approach1(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j])
                    return arr[i];
            }
        }
        return 0;
    }

    public int Approach2(int[] arr){
        Set<Integer> hs = new HashSet<>();
        for(int num:arr){
            if(hs.contains(num))
                return num;
            else
                hs.add(num);
        }
        return 0;
    }

    public int Approach3(int[] nums){
        for(int i=0;i<nums.length;i++){
            int curridx = Math.abs(nums[i]);
            if(nums[curridx] < 0) return curridx;
            else nums[curridx] *= -1;
        }
        return 0;
    }

    public int Approach4(int[] nums){
        int tortise = nums[0];
        int hare = nums[0];
        do{
            tortise=nums[tortise];
            hare=nums[nums[hare]];
        }while(tortise!=hare);
        //restting the position  of the tortoise to find the orgin node of the loop
        tortise=nums[0];
        while(tortise!=hare){
            tortise=nums[tortise];
            hare=nums[hare];
        }
        return hare;
    }

    public int findduplicate(int[] arr){
        int ans = 0;
        // ans = Approach1(arr);
        // ans = Approach2(arr);
        // ans = Approach3(arr);
        ans = Approach4(arr);
        return ans;
    }

    public static void main(String[] args) {
        duplicateNumber dn = new duplicateNumber();
        int arr[] = {1,3,4,2,2};
        int ans = dn.findduplicate(arr);
        System.out.println("The duplicate number in the array is "+ans);
    }
}
