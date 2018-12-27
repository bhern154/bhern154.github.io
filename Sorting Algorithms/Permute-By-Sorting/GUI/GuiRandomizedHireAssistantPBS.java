import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiRandomizedHireAssistantPBS extends Application{

	static TextArea textArea = new TextArea();
	static VBox vbox = new VBox(textArea);
	static String displayText = "";

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label label1 = new Label("");
		TextField textField = new TextField ();
		HBox hb = new HBox();
		hb.getChildren().addAll(label1, textField);
		hb.setSpacing(10);

		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(vbox, 0, 0);
		grid.getChildren().add(vbox);

		//Defining the Name text field
		final TextField candidates = new TextField();
		candidates.setPromptText("Enter a list of Candidates...");
		candidates.setPrefColumnCount(10);
		candidates.getText();
		GridPane.setConstraints(candidates, 0, 1);
		grid.getChildren().add(candidates);

		//Defining the Submit button
		Button enter = new Button("Enter");
		GridPane.setConstraints(enter, 0, 2);
		grid.getChildren().add(enter);

		//Adding a Label
		final Label label = new Label();
		GridPane.setConstraints(label, 0, 3);
		GridPane.setColumnSpan(label, 2);
		grid.getChildren().add(label);

		Group root = new Group();
		Scene scene = new Scene(root, 560, 265, Color.WHITE);

		root.getChildren().add(grid);

		primaryStage.setTitle("Randomized Hire Assistant (Permute-By-Sorting)");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

		//Setting an action for the Submit button
		enter.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
			if ((candidates.getText() != null && !candidates.getText().isEmpty())) {

				ArrayList<Integer> CandidateArray = new ArrayList<Integer>();

				 String[] stringArray = candidates.getText().split(" ");
				 int[] intArray = new int[stringArray.length];

			      for (int i = 0; i < stringArray.length; i++) {
			         String numberAsString = stringArray[i];
			         intArray[i] = Integer.parseInt(numberAsString);
			      }

			      for (int i=0; i<stringArray.length; i++) {
			    	  CandidateArray.add(intArray[i]);
			          System.out.print(intArray[i]);
			       }

			      setUp(CandidateArray);
			      textArea.setText(displayText);

			} else {
				label.setText("You have not entered the candidate list.");
			}
		}
				 });

	}

	public static void setUp(ArrayList<Integer> candidateArray) {

		ArrayList<Integer> Candidates = new ArrayList<Integer>();

		displayText += "Amount of candidates: " + candidateArray.size() + "\n";
		int total = candidateArray.size();

		displayText += "List of candidates: ";
		for(int i=0; i<total; i++) {
			displayText += candidateArray.get(i).toString() + " ";
		}
		displayText += "\n" + "\n";

		for(int i=0; i<total; i++) {
			Candidates.add(candidateArray.get(i));
		}

		//System.out.println();
		ArrayList<Integer> hired = new ArrayList<Integer>();
		hired = RandomizedHireAssistant(Candidates);

		displayText += "Amount of candidates hired: " + hired.size() + "\n";
		displayText += "List of candidates hired: (";

		for(int i=0; i < hired.size(); i++) {
			if(i<hired.size()-1)
				displayText +=hired.get(i) + ", ";
			else
				displayText += hired.get(i);
		}
		displayText += ")";
	}

	public static ArrayList<Integer> RandomizedHireAssistant(ArrayList<Integer> Candidates){

		int n = Candidates.size();

		ArrayList<Integer> newCandidates = new ArrayList<Integer>();
		newCandidates.addAll(PermuteBySorting(Candidates));

		//print list of new candidates
		displayText += "Candidate list after randomized: ";
		for(int i = 1; i <= n; i++) {
			displayText += newCandidates.get(i-1) + " ";
		}
		displayText += "\n" + "\n";

		//make a list of candidates hired
		ArrayList<Integer> hired = new ArrayList<Integer>();
		int best = 0;

		for(int i = 1; i <= n; i++) {
			if(newCandidates.get(i-1) > best){
				best = newCandidates.get(i-1);
				displayText += "Candidate " + newCandidates.get(i-1) + " was hired!" + "\n";
				hired.add(newCandidates.get(i-1));
			}
		}
		displayText += "\n";

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


	public static void main(String[] args) {
		Application.launch(args);
	}
}
