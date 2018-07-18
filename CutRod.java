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
		dp[0] = 0; // �ͱ���¼���������Ե����ϵĲ���ȫ���Ϊ�ȵ����±�С�ģ��ٵ����±���, ���Զ�������Ҫ�����±���
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
		if(dp[n] >= 0) return dp[n]; // �������Ѿ�����
		int max = Integer.MIN_VALUE;
		
		if(n==0) max = 0; // ����Ϊ0���������Ϊ0
		else {
			for(int i = 1; i<=n; i++) {
				max = Math.max(max, p[i-1] + memCutRod_helper(p, dp, n-i)); // �Ͳ�������¼��һ����ֻ�Ƕഫ��һ��dp��������
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

	
