

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare
{
	public static double time(String alg, Double[] a)
	{  /* ���ǰ������� */  
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) ExampleSort.InsertionSort(a);
		if (alg.equals("Selection")) ExampleSort.SelectionSort(a);
		if (alg.equals("Shell")) ExampleSort.ShellSort(a);
	//	if (alg.equals("Merge")) Merge.sort(a);
	//	if (alg.equals("Quick")) Quick.sort(a);
	//	if (alg.equals("Heap")) Heap.sort(a);
		return timer.elapsedTime();
		
	
	}
	public static double timeRandomInput(String alg, int N, int T)
	{  // ʹ���㷨1��T������ΪN����������
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++)
		{  // ����һ�β��ԣ�����һ�����鲢����)
			for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	public static void main(String[] args)
	{
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T); // �㷨1����ʱ��
		double t2 = timeRandomInput(alg2, N, T); // �㷨2����ʱ��
		StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
		
		int h = 5;
		for(int j = 21; j >= h ;j-=h)
			StdOut.print(j + " ");
	}
}