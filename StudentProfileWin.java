

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;          //Texfield
import javafx.scene.layout.VBox;

import javafx.application.Platform;


/**
 * Write a description of JavaFX class StudentProfileWin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentProfileWin extends Application
{
    //Read and write java objects to a file: https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
    
    //Stage
    private Stage stage;
    
    //Scenes
    private Scene scene1, scene2;
    
    
    //Scene 1
    //All labels
    private Label nameLb = new Label("Name");  
    private Label lastLb = new Label("Last Name");
    private Label ssnLb = new Label("SSN");
    
    //All Buttons
    private Button subBtn = new Button("Submit"); //Submit button 
    private Button clearBtn = new Button("Clear");//Clears input box
    private Button exitBtn = new Button("Exit"); //End application
    
    //Textfields - scene 1
    TextField nameTf = new TextField("name ");
    TextField lastTf = new TextField("last name");
    TextField ssnTf = new TextField("SSN");
    
    //Scene2
    Button backBtn;
    Button saveBtn;
    Label studentInfoLb;
    
    //Student object
    Student s;
    
    //Student list
    Students sList = new Students();
    
    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage; //Set primary stage
        
        scene1 = createSceneOne();
        
        //Adding scene 1 to the stage 
        stage.setScene(scene1); 
         
        //Displaying the contents of the stage 
        stage.show(); 
        

    }
    
    //Create scene 1
    private Scene createSceneOne(){
        
        //Setting title to the Stage 
        stage.setTitle("New Student Profile Creator"); 
        
        //Creating a Grid Pane layout - OPTIONAL
        GridPane gridPane = new GridPane();
        
        //Setting size for the pane (Width v height) 
        gridPane.setMinSize(400, 200); 
        
        //Set layout arrangement (column, row)
        gridPane.add(nameLb, 0, 0); // col 0, row 0
        gridPane.add(nameTf, 1, 0); // col 1, row 0
        gridPane.add(lastLb, 0, 1); // col 0 ,row 1
        gridPane.add(lastTf, 1, 1); // col 1, row 1
        gridPane.add(ssnLb, 0, 2); //  col 0 ,row 2
        gridPane.add(ssnTf, 1, 2);  // col 1, row 2
        gridPane.add(subBtn, 0, 3); // col 0 ,row 3
        gridPane.add(clearBtn, 1, 3); // col 1, row 3
        gridPane.add(exitBtn, 2, 3);
        
        //set the button to clear all textfields - Event Handler version 1
        clearBtn.setOnAction(this::btn_ClearField);
        
        //set the button to store student information
        subBtn.setOnAction(this::btn_setProfile);
        
        //Exit button - Event Handler version 2
        exitBtn.setOnAction((e) -> {
            Platform.exit();
        });
        
        //Setting the padding inside layout  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(10); 
        gridPane.setHgap(10);  
        
        //Creating a scene object 
        Scene scene = new Scene(gridPane); 
        
        return scene;
    }
    
    private Scene createSceneTwo(){
        
        stage.setTitle("Confirm Inforamtion  ");//Changes state window        
        
        //Creating a Grid Pane layout - OPTIONAL
        GridPane gridPane = new GridPane();
        
        //Setting size for the pane (Width v height) 
        gridPane.setMinSize(400, 200); 
        
        //Create and display label and student information
        studentInfoLb = new Label();
        studentInfoLb.setText("\nName: " + nameTf.getText() + "\nLast Name: " + lastTf.getText() + "\nSSN: " + ssnTf.getText());
        
        //Set layout arrangement (column, row)
        gridPane.add(new Label("Verify Your Profile"), 0, 0); // col 0, row 0
        gridPane.add(studentInfoLb, 0, 1); // col 0 ,row 1
        
    
        //Create back button
        backBtn = new Button("Edit");
        saveBtn = new Button("Save");
        
        gridPane.add(backBtn, 0, 2); // col 0 ,row 3
        gridPane.add(saveBtn, 1, 2); // col 1, row 3
        
        //Setting the padding inside layout  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(10); 
        gridPane.setHgap(5);  
        
        //set the button to clear all textfields
        saveBtn.setOnAction(this::btn_SaveFields);
        
        //Setup back button (Version 2 of creating button - no function)
        backBtn.setOnAction((e) -> {
            System.out.println("Back to scene 2"); 
            switchScenes(scene1);  //Switch to scene 1
        });
       
        
        //Creating a scene object 
        Scene scene = new Scene(gridPane); 
        
        return scene;
    }
    
    //Clear all fields
    private void btn_SaveFields(ActionEvent event)
    {
       System.out.println("Saving...");
       
       //Capture the textfield inputs
       String name = nameTf.getText();
       String lastName = lastTf.getText();
       String ssn = ssnTf.getText();
       
       //Create Person object with information captured
       s = new Student(name, lastName, ssn);
       
       //Test input
       System.out.println(s);
       
       //Add Student to list 
       sList.add(s);
       
       //Student list
       System.out.println(sList);
       
       //Reset scene 1
       System.out.println("Scene 1 Reset");
       scene1 = createSceneOne();  //Create new scene1
       switchScenes(scene1);       //Switch to scene 1 
       
       //Clear all fields
       nameTf.clear();
       lastTf.clear();
       ssnTf.clear();
       
    }
    
    
    //Clear all fields
    private void btn_ClearField(ActionEvent event)
    {
       System.out.println("Fields were cleared");
        
       //Clear all fields
       nameTf.clear();
       lastTf.clear();
       ssnTf.clear();
       
    }
    
    //Process student info
    private void btn_setProfile(ActionEvent event)
    {
       System.out.println("Scene 2 activated");
       scene2 = createSceneTwo();  //Create scene 2
       switchScenes(scene2);       //Switch to scene 2 
       
       
    }
    
    //Switches scenes in single stage
    public void switchScenes(Scene scene){
        System.out.println("Scene switch");
        stage.setScene(scene);
        
    }
    
    
    
    
    
}
