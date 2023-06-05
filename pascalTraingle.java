import java.util.*;

class pascalTraingle {
    // TC: O(M*N) Space: O(M*N) number of steps & space to compute all the values N*(N+1)/2
    public void fillOnes(List<List<Integer>> traingle,int i){
        List<Integer> temp = new ArrayList<>();
        for(int one=0;one<i+1;one++){
            temp.add(1);
        }
        traingle.add(temp);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> traingle = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            if(i <= 1){
                fillOnes(traingle,i);
            }else{
                List<Integer> curr = new ArrayList<>();
                // System.out.println("->"+i+"->"traingle.size());
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        curr.add(1);
                    }else{
                        List<Integer> prev = traingle.get(i-1);
                        curr.add(prev.get(j-1)+prev.get(j));
                    }
                }
                traingle.add(curr);
            }
        }
        return traingle;
    } 

    public static void main(String[] args) {
        pascalTraingle pt = new pascalTraingle();
        List<List<Integer>> ans = pt.generate(5);   
        System.out.println(ans);
    }
}

