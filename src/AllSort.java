import java.util.Random;

public class AllSort {

	Comparable[] aux;

	private boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void InsertSort(Comparable[] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = i; j > 0 && less(b, j, j - 1); j--)
				exch(b, j, j - 1);
		}

	}

	public void SelectSort(Comparable[] b){
		for(int i = 0; i<b.length; i++){
			int min = i;
			for(int j = i; j<b.length;j++){
				if(less(b,j,min))
					min = j;
			}
			exch(b,i,min);
		}
	}
	
	public void ShellSort(Comparable[] b){
		int h = 1;
		int N = b.length;
		while(h <N/3)
			h = 3*h +1;
		while(h >= 1){
			
			for(int i = 0; i<N; i+=h){
				for(int j = i; j>0 && less(b,j,j-1);j--){
					exch(b,j,j-1);
				}
			}
			h = h/3;
		}
		
	}
	
	public void Merge(Comparable[] a, int lo, int mid, int hi){
		
		aux = new Integer[a.length];
		for(int i = 0; i<a.length;i++)
			aux[i] = a[i];
//		show(aux);
//		System.out.println("begin merge...");
		int i = lo, j = mid+1;
		for(int k = lo; k<=hi;k++){
			if(i>mid){
//				System.out.println("i > mid.. value: "+aux[j]);
				a[k] = aux[j++];}
			else if(j>hi){
//				System.out.println("j > hi.. value: "+ aux[i]);
				a[k] = aux[i++];
			}
			else if(less(aux,i,j)){
//				System.out.println("i: "+aux[i] + " ** j: "+aux[j]+"  choose i: "+aux[i]);
				a[k] = aux[i++];}
			else{
//				System.out.println("i: "+aux[i] + " ** j: "+aux[j]+"  choose j: "+aux[j]);				
				a[k] = aux[j++];
			}
//			System.out.println("end merge...");
			System.out.println(a[k]);
				
		}
	}

	public void MergeSort(Comparable[] a){
		MergeSort(a, 0, a.length-1);
		
	}
	private void MergeSort(Comparable[] a, int lo, int hi){
		if(lo>=hi)
			return ;
		int mid = lo +(hi - lo)/2;
		MergeSort(a, lo,mid);
		MergeSort(a,mid+1,hi);
		Merge(a,lo,mid,hi);
	}
	
	
	private int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi + 1;
		
		while(true){
			while(less(a, ++i, lo))
				if(i >= hi)
					break;
			while(less(a,lo,--j))
				if(j <= lo)
					break;
			
			if(i >= j)
				break;
			exch(a,i,j);
		}
		
		exch(a, lo, j);
		
		
		return j;
	}
	
	private void QuickSort(Comparable[] a,int lo, int hi){
		if(lo >= hi)
			return;
		int j = partition(a,lo,hi);
		QuickSort(a,lo,j-1);
		QuickSort(a,j+1,hi);
		
		
	}
	
	public void QuickSort(Comparable[] a){
		QuickSort(a, 0, a.length-1);
	}
	public static void main(String[] args) {
		Random rd = new Random();
		int N = 10;
		Integer[] a = new Integer[10];
		for (int i = 0; i < N; i++)
			a[i] = rd.nextInt(100);

		AllSort as = new AllSort();
		as.show(a);
		System.out.println();
//		as.InsertSort(a);
//		as.SelectSort(a);
//		as.ShellSort(a);
//		as.MergeSort(a);
		as.QuickSort(a);
		as.show(a);
		
//		Integer[] b = {1,3,5,7,2,4,6,8};
//		as.Merge(b, 0, 3, 7);
//		as.show(b);

		
		
	}

}
