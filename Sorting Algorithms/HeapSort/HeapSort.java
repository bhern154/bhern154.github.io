import java.util.Scanner;

public class HeapSort {

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


		A = Heapsort(A);

		System.out.println("\nSorted list (Heapsort): ");
		print(A);

	}

	//--------------------------------------- MAX-HEAPIFY ---------------------------------------

	static int largest;

	public static int[] MaxHeapify(int[] A, int i) {

		int L = 2*i+1; 	//LEFT
		int R = 2*i+2;	//RIGHT

		//LEFT
		if(L < A.length) {
			if((L < A.length) && (A[L] > A[i])) {
				largest = L;
			}
			else {
				largest = i;
			}
		}

		//Right
		if(R < A.length) {
			if((R<= A.length) && (A[R] > A[largest])){
				largest = R;
			}
		}

		if(largest != i) {

			//swap A[i] with A[largest]
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;

			//print array after exchange
			System.out.print("List after swapping A[" + (i+1) + "] with A[" + (largest+1) + "]: ");
			print(A);

			MaxHeapify(A,largest);
		}

		return A;
	}

	//--------------------------------------- BUILD-MAX-HEAP ---------------------------------------

	public static int[] BuildMaxHeap(int[] A){

		int heapSize = A.length-1;

		for(int i = (heapSize/2); i >= 0; i--) {
			MaxHeapify(A,i);
		}
		return A;
	}

	//--------------------------------------- HEAPSORT ---------------------------------------

	public static int[] Heapsort(int[] A) {

		A = BuildMaxHeap(A);

		System.out.print("\nMax Heapified List: ");
		print(A);
		System.out.println();

		int[] sorted = new int[A.length];

		int length = A.length-1;

		for(int i = length; i >= 1; i--) {

			//swap A[0] with A[i]
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;

			//add last element to a new array
			sorted[i] = A[i];

			//remove the last element (largest)
			A = shorten(A);

			length--;
			MaxHeapify(A, 0);
		}

		sorted[0] = A[0];

		return sorted;
	}

	public static int[] shorten(int[] A) {
		int[] shortA = new int[A.length-1];

		for(int i = 0; i < A.length-1; i++) {
			shortA[i] = A[i];
		}
		return shortA;
	}

	//--------------------------------------- PRINT ---------------------------------------

	public static void print(int[] A) {
		for(int j = 0; j < A.length; j++) {
			System.out.print(A[j] + " ");
		}
		System.out.println();
	}

}
