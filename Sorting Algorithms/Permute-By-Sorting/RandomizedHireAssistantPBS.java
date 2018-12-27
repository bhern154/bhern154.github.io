import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Randomized-Hire-Assistant (n) method using Permute-By-Sorting

public class RandomizedHireAssistantPBS {

	public static void main(String[] args) {

		System.out.println("*Randomized-Hire-Assistant method using Permute-By-Sorting*");
		System.out.println();

		Scanner input = new Scanner(System.in);
		ArrayList<Integer> Candidates = new ArrayList<Integer>();

		System.out.print("Amount of candidates: ");
		int total = input.nextInt();

		//the number is also the qualifying number
		System.out.print("Enter the list of candidates: ");
		for(int i=0; i<total; i++) {
			Candidates.add(input.nextInt());
		}

		//System.out.println();
		ArrayList<Integer> hired = new ArrayList<Integer>();
		hired = RandomizedHireAssistant(Candidates);

		System.out.println();
		System.out.print("Amount of candidates hired: " + hired.size());

		System.out.println();
		System.out.print("List of candidates hired: ");

		System.out.print("(");
		for(int i=0; i < hired.size(); i++) {
			if(i<hired.size()-1)
				System.out.print(hired.get(i) + ", ");
			else
			System.out.print(hired.get(i));
		}
		System.out.print(")");

	}

	public static ArrayList<Integer> RandomizedHireAssistant(ArrayList<Integer> Candidates){

		int n = Candidates.size();

		ArrayList<Integer> newCandidates = new ArrayList<Integer>();
		newCandidates.addAll(PermuteBySorting(Candidates));

		//print list of new candidates
		System.out.println("Candidate list after randomized: ");
		for(int i = 1; i <= n; i++) {
				System.out.print(newCandidates.get(i-1) + " ");
		}
		System.out.println();
		System.out.println();

		//make a list of candidates hired
		ArrayList<Integer> hired = new ArrayList<Integer>();
		int best = 0;

		for(int i = 1; i <= n; i++) {
			if(newCandidates.get(i-1) > best){
				best = newCandidates.get(i-1);
				System.out.println("Candidate " + newCandidates.get(i-1) + " was hired!");
				hired.add(newCandidates.get(i-1));
			}

		}

		return hired;
	}

	public static ArrayList<Integer> PermuteBySorting(ArrayList<Integer> Candidates) {

		int n = Candidates.size();

		ArrayList<Integer> randomKeys = new ArrayList<Integer>();

		Random RANDOM = new Random();
		int max = (int) Math.pow(n, 3);
		int min = 1;

		for(int i = 1; i <= n; i++) {
			int randInt = RANDOM.nextInt((max - min) + 1) + min;
			randomKeys.add(i-1, randInt);
		}

		return Sort(Candidates, randomKeys);
	}

	public static ArrayList<Integer> Sort(ArrayList<Integer> Candidates, ArrayList<Integer> randomKeys) {

		ArrayList<Integer> newCandidates = new ArrayList<Integer>();

		int n = Candidates.size();
		int SmallestKey = 0;

		System.out.println("");
		int smallest;

		for (int i = 0; i<n; i++){
			smallest = randomKeys.get(i);
			int index = i;
			for (int j = 0; j<n; j++) {
				if (smallest > randomKeys.get(j)) {
					smallest = randomKeys.get(j);
					index = j;
				}
			}
			randomKeys.set(index, (int) Math.pow(n, 3)+1);
			newCandidates.add(index+1);
		}

		return newCandidates;
	}

}
