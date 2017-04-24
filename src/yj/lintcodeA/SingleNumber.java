package yj.lintcodeA;

public class SingleNumber {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        int res = 0;
        for(int one:A){
            res^=one;
        }
        return res;
    }
}