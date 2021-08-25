package io.rdk.leetlab.yuanquan.p2;

public class JMatrixTest {
    public static void main(String[] args){
        int sum=0;
        int array[][]={{1,4,7},{2, 5, 8},{3, 6, 9}};
        //No.1
        //开始写代码，求矩阵对角线元素之和
        int rows = array.length;
        int cols = array[0].length;
        // 正方形，满足i == j,或者(i+j) == (rows-1)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == j || (i+j) == (rows-1)){
                    sum += array[i][j];
                }
            }
        }
        //end_code
        System.out.println( sum);
    }
}
