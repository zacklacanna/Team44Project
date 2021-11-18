import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.*;

public class PALS extends Application
{
   
   public static void main(String[] args)
   {
      launch(args);
   }
      
   @Override
   public void start(Stage primaryStage) throws Exception
   {
      primaryStage.setTitle("PALS");
      Font biggerFont = Font.font("Arial", FontWeight.BOLD, 18);
      
      //-------------------------------------Login Select Scene---------------------------
      Group lsLayout = new Group();
      Scene loginSelect = new Scene(lsLayout, 600, 500);
      
      
      Label lsLabel = new Label("Login as:");
      Button staffButton = new Button("Staff");
      Button patientButton = new Button("Patient");
      
      lsLabel.setLayoutX(260);
      lsLabel.setLayoutY(175);
      lsLabel.setPrefSize(100,50);
      lsLabel.setFont(biggerFont);
      
      staffButton.setLayoutX(175);
      staffButton.setLayoutY(225);
      staffButton.setPrefSize(100,50);
      
      
      patientButton.setLayoutX(325);
      patientButton.setLayoutY(225);
      patientButton.setPrefSize(100,50);
      //patientButton.setOnAction(e -> primaryStage.setScene(patientLogin));
      
      lsLayout.getChildren().addAll(lsLabel, patientButton, staffButton);
      
      
      //---------------------------------Staff Login Scene-------------------------
      
      Group slLayout = new Group();
      Scene staffLogin = new Scene(slLayout, 600, 500);
      
      Label slLabel = new Label("Staff Login");
      Button confirm = new Button("enter");
      TextField username = new TextField();
      TextField password = new TextField();
      
      slLabel.setLayoutX(175);
      slLabel.setLayoutY(175);
      slLabel.setPrefSize(150,50);
      slLabel.setFont(biggerFont);
      
      username.setLayoutX(175);
      username.setLayoutY(225);
      username.setPrefSize(200,50);
      username.setText("username");
      
      password.setLayoutX(175);
      password.setLayoutY(275);
      password.setPrefSize(200,50);
      password.setText("password");
      
      confirm.setLayoutX(175);
      confirm.setLayoutY(325);
      confirm.setPrefSize(50,50);
      /*confirm.setOnAction(e -> {
         
      });*/
      slLayout.getChildren().addAll(slLabel, username, password, confirm);
      staffButton.setOnAction(e -> primaryStage.setScene(staffLogin));
      
      
      
      //Start with login select
      primaryStage.setScene(loginSelect);
      primaryStage.show();
      
      
   }
   
}  