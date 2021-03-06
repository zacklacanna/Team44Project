import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Group;
import javafx.scene.text.*;
import java.util.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class PALS extends Application
{
    public HashMap<String, Main.MessageInbox> inbox = new HashMap<>();

    public static void main(String[] args)
    {
        Main instance = new Main();
        instance.createBaseAccounts();

        launch(args);
    }

    Main.User foundPatient = null;
    public void setFoundPatient(Main.User user)
    {
        foundPatient = user;
    }

    Main.User activeUser;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("PALS");
        Font biggerFont = Font.font("Arial", FontWeight.BOLD, 18);

        //---------------------------------Logged out scene--------------------------

        Group loLayout = new Group();
        Scene loggedOut = new Scene(loLayout, 600, 500);

        Label loLabel = new Label("Logged out");
        loLabel.setLayoutX(175);
        loLabel.setLayoutY(175);
        loLabel.setPrefSize(150,50);
        loLabel.setFont(biggerFont);

        loLayout.getChildren().addAll(loLabel);

        //---------------------------------Staff Inbox Scene-------------------------

        Group spiLayout = new Group();
        Scene staffInbox = new Scene(spiLayout, 600, 500);

        Label spiLabel = new Label("Inbox");
        Button spCompose = new Button("Compose");
        Button spiBack = new Button("Go back");

        spiLabel.setLayoutX(300);
        spiLabel.setLayoutY(75);
        spiLabel.setPrefSize(150,50);
        spiLabel.setFont(biggerFont);

        spCompose.setLayoutX(500);
        spCompose.setLayoutY(75);
        spCompose.setPrefSize(100,50);
        spCompose.setOnAction(e -> {
            final Stage composeMsg = new Stage();
            composeMsg.initModality(Modality.WINDOW_MODAL);

            TextField recipientField = new TextField();
            recipientField.setText("Send to...");
            TextField subjectField = new TextField();
            subjectField.setText("Subject...");
            TextField messageField = new TextField();
            messageField.setText("Message...");
            Button closeBtn = new Button("Send");
            closeBtn.setOnAction(event -> {
                composeMsg.close();
            });

            VBox composeLayout = new VBox(5);
            composeLayout.getChildren().addAll(new Text("Compose your message"), recipientField, subjectField, messageField, closeBtn);
            Scene composeMsgScene = new Scene(composeLayout);

            composeMsg.setScene(composeMsgScene);
            composeMsg.show();
        });


        spiBack.setLayoutX(75);
        spiBack.setLayoutY(75);
        spiBack.setPrefSize(100,50);

        spiLayout.getChildren().addAll(spiLabel, spCompose, spiBack);

        //---------------------------------Staff Patient Info Scene-------------------------
        Group spfiLayout = new Group();
        Scene staffPatientInfo = new Scene(spfiLayout, 600, 500);

        Label spfiLabel = new Label("Patient Info:");
        Button spfiBack = new Button("Go Back");
        Label patientInfo = new Label();

        spfiLabel.setLayoutX(250);
        spfiLabel.setLayoutY(25);
        spfiLabel.setPrefSize(150,50);
        spfiLabel.setFont(biggerFont);

        patientInfo.setLayoutX(250);
        patientInfo.setLayoutY(100);
        patientInfo.setPrefSize(150,50);
        patientInfo.setFont(biggerFont);

        //Add patient info
        if (foundPatient != null)
        {
            patientInfo.setText("Name: " + foundPatient.getName() + "\n");
            patientInfo.setText(patientInfo.getText() + "DOB: " + foundPatient.getDOB() + "\n");
        } else {
            patientInfo.setText("\nInvalid Text\n");
        }


        /*patientInfo.setLayoutX(175);
        patientInfo.setLayoutY(300);
        patientInfo.setPrefSize(400,300);

        patientInfo.setText("Invalid patient");*/

        spfiBack.setLayoutX(25);
        spfiBack.setLayoutY(25);
        spfiBack.setPrefSize(100,50);

        spfiLayout.getChildren().addAll(spfiLabel, patientInfo, spfiBack);

        //----------------------------Contact Info Scene--------------------------------------
        Group contactLayout = new Group();
        Scene contactScene = new Scene(contactLayout,600,500);

        Label cntLabel = new Label("Contact Information");
        cntLabel.setLayoutX(220);
        cntLabel.setLayoutY(100);
        cntLabel.setPrefSize(400,100);
        cntLabel.setFont(biggerFont);

        Label cntPhone = new Label("Phone Number: ");
        cntPhone.setLayoutX(50);
        cntPhone.setLayoutY(200);
        cntPhone.setPrefSize(100,25);

        Label cntEmail = new Label("Email Address: ");
        cntEmail.setLayoutX(50);
        cntEmail.setLayoutY(250);
        cntEmail.setPrefSize(100,25);

        Label cntAddress = new Label("Home Address: ");
        cntAddress.setLayoutX(50);
        cntAddress.setLayoutY(300);
        cntAddress.setPrefSize(100,25);

        TextField cntPhoneEdit = new TextField();
        TextField cntEmailEdit = new TextField();
        TextField cntAddressEdit = new TextField();
        Button cntConfirmChanges = new Button("Confirm Changes");
        if (activeUser == null)
        {
            System.out.println("active user not found");
        } else {
            cntPhoneEdit.setText(activeUser.getInfo().getPhoneNumber());
            cntPhoneEdit.setLayoutX(150);
            cntPhoneEdit.setLayoutY(200);
            cntPhoneEdit.setPrefSize(250, 25);

            cntEmailEdit.setText(activeUser.getInfo().getEmail());
            cntEmailEdit.setLayoutX(150);
            cntEmailEdit.setLayoutY(250);
            cntEmailEdit.setPrefSize(250, 25);

            cntAddressEdit.setText(activeUser.getInfo().getHomeAddress());
            cntAddressEdit.setLayoutX(150);
            cntAddressEdit.setLayoutY(300);
            cntAddressEdit.setPrefSize(250, 25);

            cntConfirmChanges.setLayoutX(200);
            cntConfirmChanges.setLayoutY(350);
            cntConfirmChanges.setPrefSize(200, 25);
        }


        contactLayout.getChildren().addAll(cntLabel,cntPhone,cntEmail,cntAddress,
                cntPhoneEdit,cntEmailEdit,cntAddressEdit,cntConfirmChanges);
        //---------------------------------Staff Find a patient Scene-------------------------

        Group spfLayout = new Group();
        Scene staffFindPatient = new Scene(spfLayout, 600, 500);
        Main.User foundPatient = null;

        Label spfLabel = new Label("Find a patient");
        Button submit = new Button("Submit");
        Button spfBack = new Button("Go back");
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField dob = new TextField();

        spfLabel.setLayoutX(175);
        spfLabel.setLayoutY(175);
        spfLabel.setPrefSize(150,50);
        spfLabel.setFont(biggerFont);

        fName.setLayoutX(175);
        fName.setLayoutY(225);
        fName.setPrefSize(200,50);
        fName.setText("Enter first name");

        lName.setLayoutX(175);
        lName.setLayoutY(275);
        lName.setPrefSize(200,50);
        lName.setText("Enter last name");

        dob.setLayoutX(175);
        dob.setLayoutY(325);
        dob.setPrefSize(200,50);
        dob.setText("Enter DOB (MM/DD/YYYY)");

        submit.setLayoutX(175);
        submit.setLayoutY(375);
        submit.setPrefSize(100,50);
        submit.setOnAction(e -> {
            String firstName = fName.getText();
            String lastName = lName.getText();
            Main.User foundUser;
            Main newClass = new Main();
            List<Main.User> accounts = newClass.getAccounts();
            if (accounts.size() == 0)
            {
                newClass.createBaseAccounts();
            }

            Main.User foundAccount = null;
            for (Main.User account : accounts)
            {
                if (account.getType().equalsIgnoreCase("Patient"))
                {
                    if (account.getName().equalsIgnoreCase(firstName + " " + lastName))
                    {
                        if (account.getDOB().equals(dob.getText()))
                        {
                            foundAccount = account;
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (foundAccount != null){
                setFoundPatient(foundAccount);
            }
            primaryStage.setScene(staffPatientInfo);
        });

        spfBack.setLayoutX(75);
        spfBack.setLayoutY(75);
        spfBack.setPrefSize(100,50);

        spfLayout.getChildren().addAll(spfLabel, fName, lName, dob, submit, spfBack);


        //---------------------------------Patient Inbox Scene-------------------------

        Group ptiLayout = new Group();
        Scene patientInbox = new Scene(ptiLayout, 600, 500);

        Label ptiLabel = new Label("Inbox");
        Button ptCompose = new Button("Compose");
        Button ptiBack = new Button("Go back");

        ptiLabel.setLayoutX(300);
        ptiLabel.setLayoutY(75);
        ptiLabel.setPrefSize(150,50);
        ptiLabel.setFont(biggerFont);

        ptCompose.setLayoutX(500);
        ptCompose.setLayoutY(75);
        ptCompose.setPrefSize(100,50);
        ptCompose.setOnAction(e -> {
            final Stage composeMsg = new Stage();
            composeMsg.initModality(Modality.WINDOW_MODAL);

            TextField recipientField = new TextField();
            recipientField.setText("Send to...");
            TextField subjectField = new TextField();
            subjectField.setText("Subject...");
            TextField messageField = new TextField();
            messageField.setText("Message...");
            Button closeBtn = new Button("Send");
            closeBtn.setOnAction(event -> {
                composeMsg.close();
            });

            VBox composeLayout = new VBox(5);
            composeLayout.getChildren().addAll(new Text("Compose your message"), recipientField, subjectField, messageField, closeBtn);
            Scene composeMsgScene = new Scene(composeLayout);

            composeMsg.setScene(composeMsgScene);
            composeMsg.show();
        });


        ptiBack.setLayoutX(75);
        ptiBack.setLayoutY(75);
        ptiBack.setPrefSize(100,50);

        ptiLayout.getChildren().addAll(ptiLabel, ptCompose, ptiBack);

        //-------------------------Patient Portal Scene------------------------------
        Group ptLayout = new Group();
        Scene patientPortal = new Scene(ptLayout,600,500);

        Label ptLabel = new Label("Patient Portal");
        ptLabel.setLayoutX(240);
        ptLabel.setLayoutY(25);
        ptLabel.setPrefSize(150,50);
        ptLabel.setFont(biggerFont);

        Button ptContact = new Button("Edit Contact Info");
        ptContact.setLayoutX(230);
        ptContact.setLayoutY(250);
        ptContact.setPrefSize(150,50);
        ptContact.setOnAction(e -> primaryStage.setScene(contactScene));

        Button ptInbox = new Button("Inbox");
        ptInbox.setLayoutX(230);
        ptInbox.setLayoutY(325);
        ptInbox.setPrefSize(150,50);
        ptInbox.setOnAction(e -> primaryStage.setScene(patientInbox));

        Button ptLogout = new Button("Log Out");
        ptLogout.setLayoutX(230);
        ptLogout.setLayoutY(400);
        ptLogout.setPrefSize(150,50);
        ptLogout.setOnAction(e -> primaryStage.setScene(loggedOut));

        ptiBack.setOnAction(e -> primaryStage.setScene(patientPortal)); //these buttons must be referenced after the scene is declared
        //ptcBack.setOnAction(e -> primaryStage.setScene(patientPortal));

        ptLayout.getChildren().addAll(ptLabel,ptContact,ptLogout,ptInbox);

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
        spFind.setOnAction(e -> primaryStage.setScene(staffFindPatient));

        spInbox.setLayoutX(175);
        spInbox.setLayoutY(250);
        spInbox.setPrefSize(150,50);
        spInbox.setOnAction(e -> primaryStage.setScene(staffInbox));

        spLogout.setLayoutX(175);
        spLogout.setLayoutY(325);
        spLogout.setPrefSize(150,50);
        spLogout.setOnAction(e -> primaryStage.setScene(loggedOut));

        spiBack.setOnAction(e -> primaryStage.setScene(staffPortal)); //these buttons must be referenced after the scene is declared
        spfBack.setOnAction(e -> primaryStage.setScene(staffPortal));
        spfiBack.setOnAction(e -> primaryStage.setScene(staffPortal));

        spLayout.getChildren().addAll(spLabel, spFind, spInbox, spLogout);

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
        pConfirm.setOnAction(e -> {
            String username = pUsername.getText();
            String password = pPassword.getText();
            Main newClass = new Main();
            List<Main.User> accounts = newClass.getAccounts();
            if (accounts.size() == 0)
            {
                newClass.createBaseAccounts();
            }

            Main.User currentUser = null;
            for (Main.User account : accounts)
            {
                if (account.getType().equalsIgnoreCase("Patient"))
                {
                    if (account.getUserName().equalsIgnoreCase(username) &&
                            account.getPassWord().equalsIgnoreCase(password))
                    {
                        currentUser = account;
                        primaryStage.setScene(patientPortal);
                    } else {
                        plLabel.setText("Incorrect login");
                        continue;
                    }
                } else {
                    plLabel.setText("Incorrect login");
                    continue;
                }
            }
            if (currentUser != null)
            {
                activeUser = currentUser;
            }
        });
        plLayout.getChildren().addAll(plLabel, pUsername, pPassword, pConfirm);

        //---------------------------------Staff Login Scene-------------------------

        Group slLayout = new Group();
        Scene staffLogin = new Scene(slLayout, 600, 500);

        Label slLabel = new Label("Staff Login");
        Button sConfirm = new Button("Enter");
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
        sConfirm.setOnAction(e -> {
            String username = sUsername.getText();
            String password = sPassword.getText();
            Main newClass = new Main();
            List<Main.User> accounts = newClass.getAccounts();
            if (accounts.size() == 0)
            {
                newClass.createBaseAccounts();
            }

            Main.User currentUser = null;
            for (Main.User account : accounts)
            {
                if (account.getType().equalsIgnoreCase("Staff"))
                {
                    if (account.getUserName().equalsIgnoreCase(username) &&
                            account.getPassWord().equalsIgnoreCase(password))
                    {
                        currentUser = account;
                        primaryStage.setScene(staffPortal);
                    } else {
                        slLabel.setText("Incorrect login");
                        continue;
                    }
                } else {
                    slLabel.setText("Incorrect login");
                    continue;
                }
            }
            if (currentUser != null)
            {
                activeUser = currentUser;
            }
        });
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
