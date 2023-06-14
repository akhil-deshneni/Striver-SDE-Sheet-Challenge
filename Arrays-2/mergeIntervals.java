import java.util.*;

public class mergeIntervals {

    public void Approach1(int[][] intervals){

        Arrays.sort(intervals,(int[] a,int[] b) -> Integer.compare(a[0],b[0]));
        // System.out.println(Arrays.deepToString(intervals));
        Stack<int[]> merger = new Stack<>();
        int[] temp = new int[2];

        for(int[] interval:intervals){
            if(merger.isEmpty()){
                merger.push(interval);
            }else{
                int[] top = merger.peek();
                if(interval[0] <= top[1]){
                    top[1] = Math.max(top[1],interval[1]);
                }else{
                    merger.push(interval);
                }
            }
        }
        
        int[][] printStack = new int[merger.size()][2];
        int k = merger.size()-1;
        while(!merger.isEmpty()){
            temp = merger.pop();
            printStack[k][0] = temp[0];
            printStack[k][1] = temp[1];
            k--;
        }

        System.out.println(Arrays.deepToString(printStack));
    }

    public void Approach2(int[][] intervals){

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        int[][] ans = merged.toArray(new int[merged.size()][]);

        System.out.println(Arrays.deepToString(ans));
    }

    public void mergeOverlappingIntervals(int[][] intervals){
        Approach1(intervals);
    }

    public static void main(String[] args) {
        mergeIntervals mi = new mergeIntervals();
        int[][] intervals = {{4,5},{1,4},{0,1}};
        mi.mergeOverlappingIntervals(intervals);
        // System.out.println(Arrays.deepToString(intervals));
    }
}
