package yj.lintcodeA;

import java.util.HashMap;

public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
    	// using a hash map to store previous data
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = numbers.length;
        int res[] = new int[2];
        for(int i=0;i<len;i++){
        	//need to check if it has the key
            if(map.containsKey(target-numbers[i])){
                int temp = map.get(target-numbers[i]);
                if(temp<i){
                    res[0]=temp;
                    res[1]=i;
                }else{
                    res[0]=i;
                    res[1]=temp;
                }
                res[0]++;
                res[1]++;
                return res;
            }else{
                map.put(numbers[i],i);
            }
        }
        return null;
    }
}