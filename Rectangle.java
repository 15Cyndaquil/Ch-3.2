import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Rectangle extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		//Created grid with 2 columns and 6 rows 
		//Columns are 300 pixels long
		//Rows are 50 pixels long
		GridPane grid = new GridPane();
		for (int col=0; col<2; col++) {
			ColumnConstraints column = new ColumnConstraints(300);
			grid.getColumnConstraints().add(column);
		}
		for (int ro=0; ro<6; ro++) {
			RowConstraints row = new RowConstraints(50);
			grid.getRowConstraints().add(row);
		}
		
		//Creating text in the middle of column one
		//which occupies both rows
		Label text = new Label("Input the height and w");
		grid.add(text, 0, 0);
		GridPane.setHalignment(text, HPos.RIGHT);
		Label text1 = new Label("idth of your rectangle");
		grid.add(text1, 1, 0);
		GridPane.setHalignment(text1, HPos.LEFT);
		
		//Creating labels above text inputs
		Label heightl = new Label("Height");
		grid.add(heightl, 0, 1);
		GridPane.setHalignment(heightl, HPos.CENTER);
		
		Label widthl = new Label("Width");
		grid.add(widthl, 1, 1);
		GridPane.setHalignment(widthl, HPos.CENTER);
		
		//Creating text user text inputs
		TextField height = new TextField();
		height.setText("Enter the height");
		grid.add(height, 0, 2);
		
		TextField width = new TextField();
		width.setText("Enter the width");
		grid.add(width, 1, 2);
		
		//Creating button for exiting the program		
		Button cancel = new Button("Cancel");
		GridPane.setHalignment(cancel, HPos.CENTER);
		GridPane.setValignment(cancel, VPos.CENTER);
		grid.add(cancel, 1, 3);
		
		//Creating output labels
		Label output1 = new Label();
		grid.add(output1, 0, 5);
		GridPane.setHalignment(output1, HPos.CENTER);
		
		Label output2 =new Label();
		grid.add(output2, 1, 5);
		GridPane.setHalignment(output2, HPos.CENTER);
		
		//Allowing user input to start data processing
		ChangeListener<String> calculate1 = (observable1, oldValue1, newValue1) -> {
			//Using try to weed out any non number inputs
			try{
				double widthf1 = Double.parseDouble(width.getText());
				double heightf1 = Double.parseDouble(height.getText());
				double perimiterf1 = 2*widthf1+2*heightf1;
				double areaf1 = widthf1*heightf1;
				output1.setText("The Perimiter of your rectangle is " + perimiterf1);
				output2.setText("The Area of your rectangle is " + areaf1);
			}
			//Reseting outputs and saying input numbers only
			//NumberFormatException occurs when TextField width or height
			//Don't have a double value inside of them
			catch(NumberFormatException f){
				output2.setText("");
				output1.setText("Please input numbers only");
			}
		};
		width.textProperty().addListener(calculate1);
		height.textProperty().addListener(calculate1);
		
		//Setting up cancel button to close program	
		cancel.setOnAction(new EventHandler<ActionEvent>(){
		
			@Override
			public void handle(ActionEvent cancela){
				System.exit(0);
			}
		});
		
		//Applying my GridPane to a scene and then applying scene to stage
		Scene scene = new Scene(grid, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
