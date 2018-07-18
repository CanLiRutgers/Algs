public class Insertion {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers(int[] A) {
        // write your code here
        for ( int i = 1; i < A.length; i++ ){
            int key = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > key){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = key;
        }
    }
    
}