
public class MajorityVote {
	public static void main(String[] args) {
		int[] A = {1,2,2,3,2,2,3};
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		int res = getMajority(A);
		System.out.println(res);
	}

	private static int getMajority(int[] a) {
		// TODO Auto-generated method stub
		int m = a.length;
		int counter = 0;
		int label = 0;
		for(int i = 0; i<m; i++) {
			if(counter==0) {
				counter++;
				label = a[i];
			} else if(label != a[i]){
				counter--;
			} else {
				counter++;
			}
		}
		return a[label];
	}
}
