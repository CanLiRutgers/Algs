public class MergeSort {

    public static void sortIntegers2(int[] A) {
        // write your code here
        sort(A, 0, A.length - 1);
    }
    
    public static void sort(int[] array, int p, int r) {
        if(p<r){
            int q = (int)Math.floor((p+r)/2);
            sort(array, p, q);
            sort(array, q+1, r);
            merge(array, p, q, r);
        }
    }
    
    public static void merge(int[] A, int p, int q, int r) {
        int n1 = (q-p) + 1;
        int n2 = (r-(q+1)) + 1;
        
        int[] leftArray = new int[n1+1];
        int[] rightArray = new int[n2+1];
        
        for(int i = 0; i < n1; i++) {
            leftArray[i] = A[p+i];
        }
        
        for(int i = 0; i < n2; i++) {
            rightArray[i] = A[(q+1)+i];
        }
        
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;
        
        int i = 0, j = 0;
        
        for( int k = p; k < r + 1; k++ ) {
            if(leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i = i + 1;
            } else {
                A[k] = rightArray[j];
                j = j + 1;
            }
        }
    }
    
    public static void main(String[] args) {
		int[] A = {3,2,1,4,5};
		sortIntegers2(A);
		for( int i = 0; i < 5; i++) {
			System.out.print(A[i]);
		}
	}
}