import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.*;

public class LoginTest extends Application
{
   
   Label label;
   Button staffButton, patientButton;
   
   public static void main(String[] args)
   {
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage) throws Exception
   {
      primaryStage.setTitle("PALS Login");
      Group root = new Group();
      Scene loginSelect = new Scene(root, 600, 500);
      
      label = new Label("Login as:");
      staffButton = new Button("Staff");
      patientButton = new Button("Patient");
      
      Font font = Font.font("Arial", FontWeight.BOLD, 18);
      
      label.setLayoutX(260);
      label.setLayoutY(175);
      label.setPrefSize(100,50);
      label.setFont(font);
      staffButton.setLayoutX(175);
      staffButton.setLayoutY(225);
      staffButton.setPrefSize(100,50);
      patientButton.setLayoutX(325);
      patientButton.setLayoutY(225);
      patientButton.setPrefSize(100,50);
      
      root.getChildren().add(label);
      root.getChildren().add(patientButton);
      root.getChildren().add(staffButton);
     
      primaryStage.setScene(loginSelect);
      primaryStage.show();
   }
   
}  