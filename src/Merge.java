import java.util.Random;

public class Merge {

	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}

	}

	
	//自顶向下的排序
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a,lo,mid,hi);
	}

	
	//自底向上的排序
	public static void sortBU(Comparable[] a){
		int N = a.length;
		aux = new Comparable[a.length];
		
		
		for(int sz = 1; sz <N ; sz+=sz){
			for(int lo = 0; lo <=N-sz;lo+= sz +sz){
				merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1,N-1));
			}
		}
		
	}
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void show(Comparable[] a){
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[20];
		
		Random r = new Random();
		for(int i=0 ; i<a.length;i++){
			a[i] = r.nextInt(10);
		}
		show(a);
		sortBU(a);
		System.out.println("\n");
		show(a);
	}
}
