import java.util.Arrays;

public class CutRod {
	public static int[] prices = {1,5,8,9,10,17,20,24,30};
	public static void main(String[] args) {
		for(int i = 1; i <= prices.length; i++) {
			System.out.println("length:" + i + " max profit:" + cutRod(i) + " (topdown)" );
			System.out.println("length:" + i + " max profit:" + memCutRod(prices, i) + " (mem_topdown)");
			System.out.println("length:" + i + " max profit:" + bottomUpCut(prices, i) + " (bottomup)");
		}
	}

	private static int bottomUpCut(int[] p, int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 0; // 和备忘录的区别是自底向上的不用全填，因为先调用下标小的，再调用下标大的, 而自顶向下先要调用下标大的
		for(int j=1; j<=n; j++) {
			int max = Integer.MIN_VALUE;
			for(int i=1; i<=j; i++) {
				max = Math.max(max, p[i-1] + dp[j-i]);
			}
			dp[j] = max;
		}
		return dp[n];
	}
		

	private static int memCutRod(int[] p, int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		return memCutRod_helper(p, dp, n);
	}

	private static int memCutRod_helper(int[]p, int[] dp, int n) {
		// TODO Auto-generated method stub
		if(dp[n] >= 0) return dp[n]; // 子问题已经解了
		int max = Integer.MIN_VALUE;
		
		if(n==0) max = 0; // 长度为0则最大收益为0
		else {
			for(int i = 1; i<=n; i++) {
				max = Math.max(max, p[i-1] + memCutRod_helper(p, dp, n-i)); // 和不带备忘录的一样，只是多传了一个dp用来计数
			}
		}
		dp[n] = max;
		return max;
		
	}

	private static int cutRod(int length) {
		// TODO Auto-generated method stub
		if(length == 0) return 0;
		int result = Integer.MIN_VALUE;
		for(int i = 1; i <= length; i++) {
			result = Math.max(result, prices[i-1] + cutRod(length-i));
		}
		return result;
	}
}

	
