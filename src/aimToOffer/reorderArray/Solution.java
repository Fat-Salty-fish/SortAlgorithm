package aimToOffer.reorderArray;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.*;

/**
 * @author acer
 * @Date 2019/4/9 10:01
 */
public class Solution {
    public void reOrderArray(int [] array) {
//        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even[evenIndex++] = array[i];
            }else{
                array[oddIndex++] = array[i];
            }
        }
        for(int i =0;i<evenIndex;++i){
            array[oddIndex++] = even[i];
        }
//        Arrays.stream(odd).forEach(i->System.out.print(i+" "));

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        new Solution().reOrderArray(array);
        Arrays.stream(array).forEach(i->System.out.print(i+" "));
    }
}
