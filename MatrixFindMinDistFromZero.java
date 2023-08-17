import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixFindMinDistFromZero {
    public static void main(String[] args) {
        int[][] arr= {{0,1,1},{1,1,1},{1,1,1}};

        System.out.println(Arrays.deepToString(Matrix(arr)));
    }
    public static int[][] Matrix(int[][] matrix){
        int n= matrix.length;
        int m= matrix[0].length;
        int[][] res = new int[n][m];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m; j++){
                if(matrix[i][j] == 0) res[i][j]=0;
                else res[i][j] =-1;
            }
        }

        Queue<int[]> q= new LinkedList<>();
        //first push all the 0's cordinate into queue 
        for(int i=0;i<n;i++){
            for(int j=0;j<m; j++){
                if(matrix[i][j]== 0){
                    
                    q.offer(new int[] {i,j});
                }
            }
        }

        while(!q.isEmpty()){
            //we will check four poitions right, left, up, down
            int[] cell = q.poll();
            int i = cell[0];
            int j= cell[1];
            //for all four direction we will move
            for(int[] dir:directions){
                int new_i= i+dir[0];
                int new_j= j+dir[1];
                if(new_i>=0 && new_i<n && new_j>=0 && new_j<n && res[new_i][new_j]==-1){
                     res[new_i][new_j] = res[i][j] + 1;
                     q.offer(new int[] {new_i,new_j});
                }

            }
        }


        return res;
    }
   
}
