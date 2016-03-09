

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ExampleSort {

	public static void sort(Comparable[] a){
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
//		String[] a = In.readStrings();
		
		int N = 100;
		Integer[] a = new Integer[N];
		for(int i = 0; i < N; i++){
			a[i] = StdRandom.uniform(1000);
		}
		
//		ShellSort(a);
		assert isSorted(a);
		show(a);
	}
	
	
	public static void InsertionSort(Comparable[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			for(int j = i; j >0 && less(a[j],a[j-1]); j-- )
				// 由于左边已经有序   && less(a[j],a[j-1])可以保证提前退出循环
				exch(a,j,j-1);
		}
		
	}
	
	public static void SelectionSort(Comparable[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			int min = i;
			for(int j = i + 1; j < N; j++){
				if(less(a[j],a[min])) min = j;
			}
			exch(a,i,min);
			
		}
		
	}
	
	
	public static void ShellSort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && less(a[j],a[j-h]); j-=h){
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
		
	}
	
	//归并排序
	public static void Merge(Comparable[] a, int lo, int mid, int hi){
		
		int i = lo, j = mid + 1;
		//copy to a  aux array
		Comparable[] aux = new Comparable[a.length];
		for(int k = lo; k <= hi ; k++)
			aux[k] = a[k];
		for(int k = lo; k <= hi; k++){
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = a[i++];
			else if(less(a[j],a[i]))
				a[k] = a[j++];
			else
				a[k] = a[i++];
		}
		
		
		
	}
}
