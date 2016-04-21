import java.util.Random;


public class QuickSort {
	
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j= hi+1;
		
		while(true){
			while(less(a[++i],a[lo])){
				if(i == hi)
					break;
			}
			while(less(a[lo],a[--j]))
				if(j == lo)
					break;
			
			if(i>=j)
				break;
			exch(a,i,j);
			
		}
		
		exch(a,lo,j);
		
		return j;
	}
	
	private static void sort(Comparable[] a,int lo, int hi){
		if(lo >= hi)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public static void sort(Comparable[] a){
		sort(a, 0, a.length-1);
	}
	
	
	public static void show(Comparable[] a){
		for(int i= 0; i<a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	
	//Èý·ÖÅÅÐò
	private static void sort3(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lo];
		while(i<=gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a,lt++,i++);
			else if(cmp > 0) exch(a, i,gt--);
			else i++;
			
		}
		sort3(a,lo,lt-1);
		sort3(a,gt+1,hi);
	}
	
	public static void sort3(Comparable[] a){
		sort3(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[30];
		Random r = new Random();
		for(int i= 0; i<a.length; i++){
			a[i] = r.nextInt(100);
		}
		
		show(a);
		sort(a);
		System.out.println();
		show(a);
		
//		for(int i= 0; i<a.length; i++){
//			a[i] = r.nextInt(20);
//		}
//		
//		show(a);
//		sort3(a);
//		System.out.println();
//		show(a);
//		
		
	}

}
