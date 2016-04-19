import java.util.Random;


public class PQ<Key extends Comparable<Key>> {

	private Key[] a;
	private int N = 0;
	
//	
	public PQ(int maxN){
//		a = new Key[N];    不能用这种方式来创建泛型数组
		a = (Key[]) new Comparable[maxN+1];
		N = maxN;
	}
	
	public PQ(){
		a = (Key[]) new Comparable[100];
		N = 0;
	}
	
	public int size(){
		return a.length;
	}
	public void insert(Key k){
		System.out.println("inserting ..." + N);
		a[++N] = k;
//		System.out.println(N);
		swim(N);
	}
	
	public Key delMax(){
		Key k = a[1];
		exch(1,N--);
		a[N+1]=null;
		sink(1);
		return k;
		
		
	}
	private boolean less(int i, int j){
		return a[i].compareTo(a[j])<=0;
	}
	private void exch(int i,int j){
		Key temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private void swim(int k){
//		System.out.println(k);
		
		while(k>1){
			int j = k/2;
			if(less(j,k))
				exch(j,k);
			k = k/2;
			
		}
		
		
	}
	private void sink(int k){
		
		while(k <= N/2){
			int j = 2*k;
			if(j<N && less(j,j+1)) j++;
			if(less(k,j)) exch(k,j);
			k = j;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		PQ<Integer> pq = new PQ<Integer>();
		System.out.println(pq.size());
		for(int i = 0; i<10; i++){
			Integer num = rd.nextInt(100);
			pq.insert(num);
			
			System.out.print(num + " ");
		}
		System.out.println();
		for(int i = 0; i<10;i++){
			Integer max = pq.delMax();
			System.out.print(max+ " ");
		}
	}
}
