//GOOD
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
	private static Database myDatabase;
	private static View myView;
	private static ReviewScene myReviewScene;
	
	public App() 
	{
		myDatabase = new Database();
		myReviewScene = new ReviewScene();
		myView = new View();		
	}
	
	public static Database getDatabase()           
	{ 
		return myDatabase;
	}
	public static View getView()
	{ 
		return myView;       
	}
	public static ReviewScene getReviewScene() 
	{ 
		return myReviewScene;
	}	

	public static void main(String[] args) 
	{ 
		launch(args); 
	}

	public void start(Stage stage) throws Exception 
	{
		System.out.println("Initializing app window...");
		myView.setStage(stage);
		System.out.println("Initialization has completed");
	}	
}