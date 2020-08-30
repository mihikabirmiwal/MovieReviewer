//GOOD
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.TreeMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ReviewScene implements EventHandler<ActionEvent> 
{
    Object list[];	
    public void setList(Object oList[])
    {
        list = oList;
    }
    // Event Handler Method
    public void handle(ActionEvent event) 
    {
        String source = ((Button)event.getSource()).getText();
        if (source.contentEquals("Close"))
            Platform.exit();
        else
        {
            TextArea movieReview = (TextArea) list[0];
            TextArea movieRating = (TextArea) list[1];
            String review = movieReview.getText();
            
            Database myDatabase = App.getDatabase();
            HashMap<String, int[]> data = myDatabase.getDatabase();
            double rating = 0.0;
            rating = myDatabase.calcRating(review, data);
            movieRating.setText(Double.toString(rating));            
        }
    }
}