

public class MatrixChain {
	
	public static void main(String[] args) {
	        int[] p = {30, 35, 15, 5, 10, 20 ,25};
	        int[][] s = MatrixChain.order(p);
	        print(s, 1, 6);
	    

	    }
    private static int[][] order(int[] p) {
		// TODO Auto-generated method stub
    	int n = p.length - 1;
    	int[][] m = new int[p.length][p.length];
    	int[][] s = new int[p.length][p.length];
    	
    	for(int l = 2; l<=n; l++) {
    		for(int i = 1; i<=n-l+1; i++) {
    			int j = i+l-1;
    			m[i][j] = Integer.MAX_VALUE;
    			for(int k = i; k<j; k++) {
    				int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
    				if(q<m[i][j]) {
    					m[i][j] = q;
    					s[i][j] = k;
    				}
    			}
    		}
    	}
    	return s;
	}
	public static void print(int[][] s, int i, int j) {
        if(i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.print(")");
        }
	}
}
