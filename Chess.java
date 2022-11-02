package com.zoho.javaprograms;

public class Chess {
//		static double total_gud=-1;
		
		public static void main(String[] args) {
			
			int n=10;
			
			int arr[][] = new int[n][n];
			
			int r=5,
				c=5,
				k=3;
			
			double ans = dfs(arr,r,c,k,0);
			System.out.println(ans);
//			System.out.println("Total gud pos : "+total_gud);

		}

		private static double dfs(int[][] arr, int r, int c,int k,int step) {
			double count = 0;
			
			if(r<0||r>arr.length-1 || c<0 || c>arr.length-1) 
				return 0;
			
//			total_gud++;
			
			if(k==step)
				return 1;
			
			count+=	dfs(arr,r-2,c-1,k,step+1);
			count+=	dfs(arr,r-2,c+1,k,step+1);
			count+=	dfs(arr,r-1,c-2,k,step+1);
			count+=	dfs(arr,r-1,c+2,k,step+1);
				
			count+=	dfs(arr,r+1,c+2,k,step+1);
			count+=	dfs(arr,r+1,c-2,k,step+1);
			count+=	dfs(arr,r+2,c-1,k,step+1);
			count+=	dfs(arr,r+2,c+1,k,step+1);
			
		return count/8;
			
		}
}

	