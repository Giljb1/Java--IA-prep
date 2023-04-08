

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

/**
 * Write a description of JavaFX class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test extends Application
{

    private Label text1 = new Label("Maximum Lottery Number: ");
    
    //Text Field     
    private TextField textField1;  
        
    //Creating Text Filed for password        
    private TextField textField2; 
        
    //Buttons
    private Button purchaseBtn;
    private Button clearBtn;
    private int maxVal;

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        
        
        //Create label for max value
        text1 = new Label("Maximum Lottery Number: ");
        //Creating Text Filed for max lottery number       
        textField1 = new TextField("Enter max number here");       
        
        //Creating Text Filed for password        
        textField2 = new TextField(); 
        
        //Create a Button or any control item
        purchaseBtn = new Button("Purchase");
        clearBtn = new Button("Clear");
        
        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane (Width v height) 
        gridPane.setMinSize(400, 100); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        //gridPane.setAlignment(Pos.CENTER); 
        
        //Arranging all the nodes in the grid 
        gridPane.add(text1, 0, 0); 
        gridPane.add(textField1, 1, 0); 
        gridPane.add(purchaseBtn, 0, 1);       
        gridPane.add(clearBtn, 1, 1); 
        
        //set the button to create ticket
        purchaseBtn.setOnAction(this::btn_Create_ticket);
        
        //set the button to clear textfield
        clearBtn.setOnAction(this::btn_ClearField);
        
        
        //Creating a scene object 
        Scene scene = new Scene(gridPane);  
        
        //Setting title to the Stage 
        stage.setTitle("Grid Pane Example"); 
         
        //Adding scene to the stage 
        stage.setScene(scene); 
         
        //Displaying the contents of the stage 
        stage.show(); 
            
          
        
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void btn_Create_ticket(ActionEvent event)
    {
        
        System.out.println("Creating ticket");
        
        //Store max value
        String maxValInput = textField1.getText();
        maxVal = Integer.parseInt(maxValInput);
        
        System.out.println("You entered: " + maxVal);
        
        //Create ticket and display
        TicketWin ticket = new TicketWin(maxVal);
        ticket.display();
        
        
    }//End of button click
    
    //Clear button
    public void btn_ClearField(ActionEvent event){
        textField1.clear();
    }
    
}//End of class
