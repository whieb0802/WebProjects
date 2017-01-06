import java.util.Arrays;


public class Test03insertSort {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] arr = {4,3,5,2,1,88};
		long start = System.currentTimeMillis();
		arr = Test03insertSort.insertSort(arr);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(arr));
		System.out.println(end-start);
		
		int[] arr2 = {4,6,5,2,1,88};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
	}
	

	static int[] insertSort(int[] x) throws InterruptedException{
		
		for(int i = 1;i < x.length;i++){
			int t = x[i];
			int j;
			for(j = i-1; j>=0&&t<x[j];j--){
				x[j+1] = x[j];
				}
			x[j+1] =t;
			}
		Thread.sleep(1000);
		return x;
	}
}
