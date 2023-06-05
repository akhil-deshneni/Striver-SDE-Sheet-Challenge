public class Kadane {

    public int bruteForce(int[] arr){
        // TC: O(N*N) Space: O(1)
        int maxValue = 0;
        for(int i=0;i<arr.length;i++){
            int currSum = arr[i];
            for(int j=i+1;j<arr.length;j++){
                currSum += arr[j];
                maxValue = Math.max(maxValue,currSum);
            }
        }
        return maxValue;
    }

    public int optimalSolution(int[] arr){
        int maxSubSum = 0, maxValueSoFar = arr[0];
        for(int i=0;i<arr.length;i++){
            maxValueSoFar += arr[i];
            maxValueSoFar = Math.max(maxValueSoFar, arr[i]);
            maxSubSum = Math.max(maxSubSum,maxValueSoFar);
        }
        return maxSubSum;
    }

    
    public int maxSubArraySum(int[] arr){
        int ans = 0;
        // ans = bruteForce(arr);
        ans = optimalSolution(arr);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        Kadane kd = new Kadane();
        int ans = 0;
        ans = kd.maxSubArraySum(nums);
        System.out.println("Maximum Sub array sum is: "+ans);
    }
}
