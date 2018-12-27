import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Randomized-Hire-Assistant method using Randomize-In-Place

public class RandomizedHireAssistantRIP {

	public static void main(String[] args) {

		System.out.println("*Randomized-Hire-Assistant method using Randomize-In-Place*");
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
		newCandidates.addAll(RandomizeInPlace(Candidates));

		//print list of new candidates
		System.out.println();
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

	public static ArrayList<Integer> RandomizeInPlace(ArrayList<Integer> Candidates) {

		int n = Candidates.size();
		ArrayList<Integer> randomKeys = new ArrayList<Integer>();
		Random RANDOM = new Random();

		for(int i = 1; i <= n; i++) { //max = n min = i
			int random = RANDOM.nextInt((n - i) + 1) + i;
			int temp = Candidates.get(i-1);

			//SWAP
			Candidates.set(i-1, Candidates.get(random-1));
			Candidates.set(random-1, temp);
		}

		return Candidates;
	}

}
