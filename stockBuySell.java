import java.util.*;

public class stockBuySell {

    public int bruteForce(int[] prices){
        // The Time complexity of this code will be O(N^2) and Space O(1)
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i] > maxProfit){
                    maxProfit = prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }

    public int subOptimal(int[] prices){
        // This function takes tc of O(N) and space O(N)
        int n = prices.length;
        int maxRevere[] = new int[n];
        maxRevere[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxRevere[i] = Math.max(maxRevere[i+1],prices[i]);
        }
        System.out.println(Arrays.toString(maxRevere));
        int maxProfit = 0;
        for(int i=0;i<n-1;i++){
            maxProfit = Math.max(maxProfit, (maxRevere[i]-prices[i]));
        }
        return maxProfit;
    }

    public int optimal(int[] prices){
        // TC: O(N) Space: O(1)
        int n = prices.length;
        int buy = prices[0], sell = 0, maxProfit = 0;
        for(int i=0;i<n;i++){
            buy = Math.min(prices[i],buy);
            sell = Math.max(sell,prices[i]-buy);
            maxProfit = Math.max(maxProfit,sell);
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int ans;
        // ans = bruteForce(prices);
        ans = subOptimal(prices);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        stockBuySell sbs = new stockBuySell();
        int ans = sbs.maxProfit(arr);
        System.out.println(ans);
    }
}
