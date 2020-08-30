//GOOD
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.control.Separator;
import javafx.scene.Group;
import java.util.Arrays;
import javafx.collections.FXCollections;


public class View 
{
    private TextArea reviewerDescription;
    private TextArea movieReview;
    private Button calcRating;
    private TextArea movieRating;
    private Stage myStage;
    private Button exit;
    final int SPAN = 7;
    final int FONT = 13;
    
 
    public Stage getStage()   
    { 
    	return myStage;  
    }
    public Button getButton() 
    { 
    	return exit;
    }
    
    private void createLabel(String labelName, int xIndex, int yIndex, Font font, GridPane gPane)
    {
        Label label = new Label(labelName);

        if(font != null)
           label.setFont(font);
        GridPane.setConstraints(label, xIndex, yIndex);
        GridPane.setColumnSpan(label, 1);
        gPane.getChildren().add(label);
    }

    private void createSeparator(int yIndex, GridPane gPane)
    {
        final Separator sep = new Separator();
        sep.setValignment(VPos.CENTER);
        GridPane.setConstraints(sep, 0, yIndex);
        GridPane.setColumnSpan(sep,SPAN);
        gPane.getChildren().add(sep);
    }

    private TextArea createTextArea(int xIndex, int yIndex, GridPane gPane)
    {
        TextArea textArea = new TextArea("");
        GridPane.setConstraints(textArea,xIndex,yIndex);
        GridPane.setColumnSpan(textArea,2);
        gPane.getChildren().add(textArea);
        return textArea;
    }
    private Button createButton(String buttonName, int xIndex, int yIndex, GridPane gPane)
    {
        Button button = new Button(buttonName);
        GridPane.setConstraints(button,xIndex,yIndex);
        GridPane.setColumnSpan(button,1);
        gPane.getChildren().add(button);
        return button;
    }

    public void setStage(Stage stage) 
    {
        myStage = stage;
        int yIndex = 0;
        
        Group root = new Group();
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(root, 500, 400, Color.GRAY);
        stage.setScene(scene);
        scene.setRoot(gPane);
        
        createLabel("MovieReviewer",3,yIndex,new Font(20),gPane);
        yIndex++;

        createSeparator(yIndex, gPane);
        yIndex++;     
        
        //Movie Reviewer Description
        reviewerDescription = new TextArea("Enter movie review and to find the rating");
        reviewerDescription.setPrefHeight(100);
        GridPane.setConstraints(reviewerDescription, 0, yIndex);
        GridPane.setColumnSpan(reviewerDescription, SPAN);
        reviewerDescription.setEditable(false);
        gPane.getChildren().add(reviewerDescription);
        yIndex++;
    
        createSeparator(yIndex, gPane);
        yIndex++;
        
        createLabel("Movie Review", 0, yIndex, new Font(FONT), gPane);
        createLabel("Movie Rating", 4, yIndex, new Font(FONT), gPane);
        yIndex++;
        
        createSeparator(yIndex, gPane);
        yIndex++;
       
        movieReview = createTextArea(0, yIndex, gPane);        
        calcRating = createButton("CalcRating", 2, yIndex, gPane);        
        movieRating = createTextArea(4, yIndex, gPane);
        movieRating.setEditable(false);
        yIndex++;

        createSeparator(yIndex, gPane);
        yIndex++;

        exit = createButton("Close",3,yIndex,gPane);
        exit.setPrefWidth(80);
        
        ReviewScene myReviewScene = App.getReviewScene();
        Object list[] = new Object[2];
        list[0] = movieReview;
        list[1] = movieRating;
        myReviewScene.setList(list);
        calcRating.setOnAction(myReviewScene);
        exit.setOnAction(myReviewScene);        
        myStage.show();
    }
}
