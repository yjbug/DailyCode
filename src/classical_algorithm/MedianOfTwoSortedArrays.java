package classical_algorithm;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
    	//o(log(m+n)) time
    	//o(1) space
    	int lenA = 0;
        int lenB = 0;
        if(A!=null){
            lenA = A.length;
        }
        if(B!=null){
            lenB = B.length;
        }
        
        int curA = 0;
        int curB = 0;
        
        //pay attention,  must use (len-1)>>1  , not len>>1;
        //if 4 elements , exclude 2 elements , the mid element miss left value
        int k = (lenA+lenB-1)>>1;
        
        // [1,2,3,4] [5,6,7,8,9]
        // [1,2,3,4] [5,6,7,8]
        // if ((lenA+lenB)&1) == 1:    position k+1 is our need
        // else:    position k+1 and k+2 are our need
        // so we find position k first
        int dk = 0;
        while(k!=0){
            // here,  k-1 is the same with len-1
            dk = (k-1)>>1; //exclude dk+1 elements every time
            if(curA==lenA){
                curB+=k;
                k = 0;      // need to update k
            }else if(curB==lenB){
                curA+=k;
                k = 0;
            }else{
                //careful about array bounds
                int tempA= curA+dk<lenA?(curA+dk):(lenA-1); 
                int tempB= curB+dk<lenB?(curB+dk):(lenB-1);
                if(A[tempA]<B[tempB]){
                    // A's next some elements is too small, can be excluded
                    k -= tempA +1 - curA;
                    curA = tempA+1;
                }else{
                    k -= tempB + 1 - curB;
                    curB = tempB+1;
                }
            }
        }
        
        //now we get k = 0; the next element is we need
        int res1 = 0;
        if(curA==lenA){
            res1 = B[curB++];
        }else if(curB==lenB){
            res1 = A[curA++];
        }else{
            if(A[curA]<B[curB]){
                res1 = A[curA++];
            }else{
                res1 = B[curB++];
            }
        }

        if(((lenA+lenB)&1)==1){ //priority, == is higher than &
            return res1;
        }
        
        int res2 = 0;
        if(curA==lenA){
            res2 = B[curB++];
        }else if(curB==lenB){
            res2 = A[curA++];
        }else{
            if(A[curA]<B[curB]){
                res2 = A[curA++];
            }else{
                res2 = B[curB++];
            }
        }
        return (res1+res2)/2.0 ;
    }
}
