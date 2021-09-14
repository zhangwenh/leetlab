package io.rdk.leetlab.yqTest.p2;

public class Case_1_2 {
    public static boolean checkUploadFileNaame(String filename){
        if(filename == null || filename.length() == 0){
            return false;
        }
        boolean res = false;
        int splitIndex = filename.lastIndexOf(".");
        if(splitIndex > 0){
            String suffix = filename.substring(splitIndex + 1);
            if("png".equalsIgnoreCase(suffix) || "jpg".equalsIgnoreCase(suffix)){
                String fileRealName = filename.substring(0, splitIndex).replace(" ","");
                if(fileRealName.length() == 0){
                    return false;
                }
                String[] arr = new String[]{".","%00","::",";"};
                for(String str : arr){
                    if(fileRealName.contains(str)){
                        return false;
                    }
                }
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(checkUploadFileNaame("a.jpg"));
        System.out.println(checkUploadFileNaame("a%%00.jpg"));
    }
}
