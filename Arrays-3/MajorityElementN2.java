class MajorityElementN2 {

    public int majorityElement(int[] nums) {
        int votes = 1, candidate = nums[0];
        for(int i=1; i < nums.length; i++){
            if(candidate != nums[i]){
                votes--;
                if(votes == 0){
                    candidate = nums[i];
                    votes = 1;
                }
            }
            else{
                votes++;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElementN2 men = new MajorityElementN2();
        int nums[] = {3,2,3};
        int ans = men.majorityElement(nums);
        System.out.println(ans);
    }
}