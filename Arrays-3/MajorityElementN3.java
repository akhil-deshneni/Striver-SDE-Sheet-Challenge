import java.util.*;

class MajorityElementN3{

    public List<Integer> Approach1(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int num:nums){
            lookup.put(num,lookup.getOrDefault(num,0)+1);
        }
        for(int num:lookup.keySet()){
            if(lookup.get(num) > nums.length/3){
                ans.add(num);
            }
        }
        return ans;
    }

    public List<Integer> Approach2(int[] nums){
        List<Integer> ans = new ArrayList<>(2);
        int count1 = 0, count2 = 0, element1 = 0, element2 = 0;
        for(int i=0;i<nums.length;i++){
            
        }
        return ans;
    }

    public List<Integer> findmajorityElements(int[] arr){
        List<Integer> ans;
        ans = Approach1(arr);
        return ans;
    }

    public static void main(String[] args) {
        MajorityElementN3 men3 = new MajorityElementN3();
        int[] arr = {3,2,3,2,3,3};
        List<Integer> ans = men3.findmajorityElements(arr);
        System.out.println(ans);
    }
}