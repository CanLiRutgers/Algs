
public class QuickSort {
	
	
    public static void main(String[] args) {
		int[] A = {3,2,1,9,4,5,7};
		quick_sort(A, 0, A.length-1);
		for( int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}

	private static void quick_sort(int[] A, int p, int r) {
		// TODO Auto-generated method stub
		if(p<r) {
			int q = partition(A,p,r);
			quick_sort(A, p, q-1);
			quick_sort(A, q+1, r);
		}
	}

	private static int partition(int[] A, int p, int r) {
		// TODO Auto-generated method stub
		int x = A[r];
		int i = p - 1;
		int j;
		
		for (j=p; j<=r-1; j++) {
			if(A[j] <= x) {
				i++;
				swap(A,i,j);
			}
		}
		
		swap(A, i+1, r);
		return i+1;
	}

	private static void swap(int[] a, int i, int r) {
		// TODO Auto-generated method stub
		int tmp = a[r];
		a[r] = a[i];
		a[i] = tmp;
	}
	
	

}
