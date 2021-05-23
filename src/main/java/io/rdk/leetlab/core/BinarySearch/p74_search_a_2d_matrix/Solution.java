package io.rdk.leetlab.core.BinarySearch.p74_search_a_2d_matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 把矩阵视作一个数组
        // 然后采用二分法判断指定值是否存在
        if(matrix == null){
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int mid,left = 0,right = height*width-1;
        while(left<right){
            mid = left+(right-left)/2;
            int midVal = getMatrixIndexValue(mid,matrix,width);
            if(midVal==target){
                return true;
            }else if(midVal<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return getMatrixIndexValue(left,matrix,width) == target;
    }
    private int getMatrixIndexValue(int arrIndex,int[][] matrix,int matrixWidth){
        int widthInd = toMatrixWidthInd(arrIndex,matrixWidth);
        int heightInd = toMatrixHeightInd(arrIndex,matrixWidth);
        return matrix[widthInd][heightInd];
    }
    private int toMatrixHeightInd(int index, int width){
        return index % width;
    }
    private int toMatrixWidthInd(int index, int width){
        return index / width;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{new int[]{1,3,5,7},new int[]{10,11,16,20},new int[]{23,30,34,60}};
//        int target = 13;
        int[][] matrix = new int[][]{new int[]{1}};
        int target = 0;
        Solution s = new Solution();
        boolean bool = s.searchMatrix(matrix,target);
        System.out.println(bool);
    }
//    private int toArrInd(int widInd,int heiInd,int width){
//        return widInd*width+heiInd;
//    }
}
