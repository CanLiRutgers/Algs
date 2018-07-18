import java.util.ArrayList;

public class ActivitySelector {
	
    public static ArrayList<Integer> greedyActivitySelection(int[] s, int[] f, int i, int n, ArrayList<Integer> activities){
        //初始调用时 i = 0, 所以a(1)是必选的(注意:活动编号已经按结束时间排序)
        int m = i + 1;
        
        //s[m] < f[i] 意味着活动 a(m) 与 a(i)冲突了
        while(m <= n && s[m] < f[i])
            m++;//选择下一个活动
        
        if(m <= n){
            activities.add(m);
            greedyActivitySelection(s, f, m, n, activities);
        }
        return activities;
    }
    
    //贪心算法的非递归解, assume f[] has been sorted and actId 0/n+1 is virtually added
    public static ArrayList<Integer> greedyActivitySelection2(int[] s, int[] f, ArrayList<Integer> acitivities){
        //所有真正的活动(不包括 活动0和 活动n+1)中,结束时间最早的那个活动一定是最大兼容活动集合中的 活动.
        int n = s.length;
    	acitivities.add(1);
        int k = 1;
        
        for(int m = 2; m < n; m++){
            if(s[m] >= f[k])
            {
                acitivities.add(m);
                k = m;
            }
        }
        return acitivities;
    }
	
    public static void main(String[] args) {
        //添加了 a(0) 和 a(n+1)活动. 其中s(0)=f(0)=0, s(n+1)=f(n+1)=Integer.MAX_VALUE
        int[] s = {0,1,3,0,5,3,5,6,8,8,2,12};//start time
        int[] f = {0,4,5,6,7,8,9,10,11,12,13,14};//finish time
        int n = 11;//活动的个数
        
        ArrayList<Integer> acts = new ArrayList<Integer>();
        greedyActivitySelection(s, f, 0, n, acts);
        for (Integer activityId : acts)
            System.out.print(activityId + " ");
        
        System.out.println();
        
        ArrayList<Integer> acts2 = new ArrayList<Integer>();
        greedyActivitySelection2(s, f, acts2);
        for (Integer activityId : acts2)
            System.out.print(activityId + " ");
             
    }
}
