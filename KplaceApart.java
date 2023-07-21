import java.util.*;

public class KplaceApart{
    public static void main(String[] args) {
        int[] arr = {2,1,17,10,21,85};
        int B =1;

        System.out.println(Arrays.toString(solve(arr,B)));
    }
    public static int[] solve(int[] A, int B){
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minQ= new PriorityQueue<>();
        
        //slidimg window adding first 3 element till B in min queue\
        int minCount = Math.min(A.length, B + 1);
        for(int i =0; i<minCount; i++){
            minQ.add(A[i]);
        }

        int j=B+1;
        while(j<A.length){
            ans.add(minQ.peek());
            minQ.poll();
            minQ.add(A[j]);
            j++;
        }

        //remaining element in q we will simply just iterate in PriorityQueue
        Iterator<Integer> itr = minQ.iterator();
 
        while (itr.hasNext()) {
             ans.add(minQ.peek());
            minQ.poll();
        }
        
        int res[] = new int[A.length];
        for(int i =0; i<A.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    
}

//brute for with time complexity O(N*B) TC =O(1)
/*
    public static int[] solve(int[] A, int B){
        int i,j,key;
        for(i =1; i<A.length; i++){
            key= A[i];
            j = i-1;

            while(j>=Math.max(0,i-B) && A[j]>key){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = key;
        }
       
        
        return A;
    
    }
 */