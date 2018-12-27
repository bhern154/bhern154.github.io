package Lab08;

import java.util.Random;
import java.util.Scanner;

public class RandomizedQuickSort {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter size of list: ");
		int size = input.nextInt();

		int[] A = new int[size];
		System.out.print("\nEnter the list: ");

		for(int i = 0; i < size; i++) {
			A[i] = input.nextInt();
		}
		System.out.println();

		RandomizedQuicksort(A, 0, A.length-1);

		System.out.println("Sorted list (Randomized QuickSort): ");
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}

	public static void RandomizedQuicksort(int[] A, int p, int r) {

		if(p < r) {
			int q = RandomizedPartition(A, p, r);
			RandomizedQuicksort(A, p, q-1);
			RandomizedQuicksort(A, q+1, r);
		}
	}

	public static int RandomizedPartition(int[] A, int p, int r) {

		Random rand = new Random();
		int i = rand.nextInt(r - p + 1) + p;	//Random(p, r)

		//exchange A[r] and A[i]
		int temp = A[r];
		A[r] = A[i];
		A[i] = temp;

		return Partition(A, p, r);
	}

	public static int Partition(int[] A, int p, int r) {

		int x = A[r];
		int i = p-1;

		for(int j = p; j<=(r-1); j++) {
			if(A[j] <= x) {
				i++;

				//exchange A[i] and A[j]
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

		//exchange A[i+1] and A[r]
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;

		return i+1;
	}

}
