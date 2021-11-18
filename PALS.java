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
      
      
      //---------------------------------Patient Login Scene-----------------------
      
      Group plLayout = new Group();
      Scene patientLogin = new Scene(plLayout, 600, 500);
      
      Label plLabel = new Label("Patient Login");
      Button pConfirm = new Button("enter");
      TextField pUsername = new TextField();
      TextField pPassword = new TextField();
      
      plLabel.setLayoutX(175);
      plLabel.setLayoutY(175);
      plLabel.setPrefSize(150,50);
      plLabel.setFont(biggerFont);
      
      pUsername.setLayoutX(175);
      pUsername.setLayoutY(225);
      pUsername.setPrefSize(200,50);
      pUsername.setText("username");
      
      pPassword.setLayoutX(175);
      pPassword.setLayoutY(275);
      pPassword.setPrefSize(200,50);
      pPassword.setText("password");
      
      pConfirm.setLayoutX(175);
      pConfirm.setLayoutY(325);
      pConfirm.setPrefSize(50,50);
      /*pConfirm.setOnAction(e -> {
         bool user/pass = (runn check)
         if user/pass good
         {
         
         }
         else
         {
         
         }
      });*/
      plLayout.getChildren().addAll(plLabel, pUsername, pPassword, pConfirm);
      
      //---------------------------------Staff Portal Scene------------------------
      
      Group spLayout = new Group();
      Scene staffPortal = new Scene(spLayout, 600, 500);
      
      Label spLabel = new Label("Staff Portal");
      Button spFind = new Button("Find a patient");
      Button spInbox = new Button("Inbox");
      Button spLogout = new Button("Log out");
      
      spLabel.setLayoutX(175);
      spLabel.setLayoutY(100);
      spLabel.setPrefSize(150,50);
      spLabel.setFont(biggerFont);
      
      spFind.setLayoutX(175);
      spFind.setLayoutY(175);
      spFind.setPrefSize(150,50);
      
      
      //---------------------------------Staff Login Scene-------------------------
      
      Group slLayout = new Group();
      Scene staffLogin = new Scene(slLayout, 600, 500);
      
      Label slLabel = new Label("Staff Login");
      Button sConfirm = new Button("enter");
      TextField sUsername = new TextField();
      TextField sPassword = new TextField();
      
      slLabel.setLayoutX(175);
      slLabel.setLayoutY(175);
      slLabel.setPrefSize(150,50);
      slLabel.setFont(biggerFont);
      
      sUsername.setLayoutX(175);
      sUsername.setLayoutY(225);
      sUsername.setPrefSize(200,50);
      sUsername.setText("username");
      
      sPassword.setLayoutX(175);
      sPassword.setLayoutY(275);
      sPassword.setPrefSize(200,50);
      sPassword.setText("password");
      
      sConfirm.setLayoutX(175);
      sConfirm.setLayoutY(325);
      sConfirm.setPrefSize(50,50);
      /*sConfirm.setOnAction(e -> {
         bool user/pass = (runn check)
         if user/pass good
         {
         
         }
         else
         {
         
         }
      });*/
      slLayout.getChildren().addAll(slLabel, sUsername, sPassword, sConfirm);
      
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
      staffButton.setOnAction(e -> primaryStage.setScene(staffLogin));
      
      
      patientButton.setLayoutX(325);
      patientButton.setLayoutY(225);
      patientButton.setPrefSize(100,50);
      patientButton.setOnAction(e -> primaryStage.setScene(patientLogin));
      
      lsLayout.getChildren().addAll(lsLabel, patientButton, staffButton);
      
      
      
      //Start with login select
      primaryStage.setScene(loginSelect);
      primaryStage.show();
      
      
   }
   
}  