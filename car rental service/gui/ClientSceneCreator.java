package apalaktikh.gui;




import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

import apalaktikh.Client;


public class ClientSceneCreator  extends sceneCreator implements EventHandler<MouseEvent> {
    //  List of CLIENTS
    ArrayList<Client> ClientList; 
    //	Flow Pane
    FlowPane buttonFlowPane;
    //	Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //	Second Scene buttons
    Button newClientBtn, updateClientBtn, deleteClientBtn, backBtn;
    //	Second scene labelsnameField
    Label IdLbl, PermNumbLbl,nameLbl,eMailLbl,phoneNumbLbl;
    //	Second scene TextFields
    TextField IdField, PermNumbField,eMailField,phoneNumbField,nameField;
    //	TableView
    TableView<Client> ClientTableView;

    public ClientSceneCreator(double width, double height) {
        super(width, height);
        
        //  Initialize fields
        ClientList = new ArrayList<>();
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        IdLbl = new Label("Id: ");
        PermNumbLbl = new Label("PermNumb: ");
       
        IdField = new TextField();
        PermNumbField = new TextField();
        
        nameLbl = new Label("Name: ");
        phoneNumbLbl = new Label("PhoneNumber: ");
       
        nameField = new TextField();
        phoneNumbField = new TextField();
        
        eMailLbl = new Label("EMAIL: ");	       
        eMailField = new TextField();
       
        newClientBtn = new Button("New Client");
        updateClientBtn = new Button("Update");
        deleteClientBtn = new Button("Delete");
        backBtn = new Button("Go Back");
        inputFieldsPane = new GridPane();
        ClientTableView = new TableView<>();

        //  Attach events
        backBtn.setOnMouseClicked(this);
        newClientBtn.setOnMouseClicked(this);
        updateClientBtn.setOnMouseClicked(this);
        deleteClientBtn.setOnMouseClicked(this);
        ClientTableView.setOnMouseClicked(this);

        //  Customize buttonFlowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newClientBtn);
        buttonFlowPane.getChildren().add(updateClientBtn);
        buttonFlowPane.getChildren().add(deleteClientBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // Customize inputFieldsPane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(IdLbl, 0, 0);
        inputFieldsPane.add(IdField, 1, 0);
        inputFieldsPane.add(PermNumbLbl, 0, 1);
        inputFieldsPane.add(PermNumbField, 1, 1);
        inputFieldsPane.add(nameLbl, 0, 2);
        inputFieldsPane.add(nameField, 1, 2);
        inputFieldsPane.add(phoneNumbLbl, 0, 3);
        inputFieldsPane.add(phoneNumbField, 1, 3);
        inputFieldsPane.add(eMailLbl, 0, 4);
        inputFieldsPane.add(eMailField, 1, 4);

        // Customize rootGridPane
//		rootScene2.setGridLinesVisible(true);
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(ClientTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 2);

        //  Customize dogTableView
        TableColumn<Client, String> IdColumn = new TableColumn<>("Id");
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClientTableView.getColumns().add(IdColumn);

        TableColumn<Client, String> PermNumbColumn = new TableColumn<>("PermNumb");
        PermNumbColumn.setCellValueFactory(new PropertyValueFactory<>("permNumb"));
        ClientTableView.getColumns().add(PermNumbColumn);
        
        TableColumn<Client, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ClientTableView.getColumns().add(nameColumn);
        
        TableColumn<Client, String> eMailColumn = new TableColumn<>("eMail");
        eMailColumn.setCellValueFactory(new PropertyValueFactory<>("eMail"));
        ClientTableView.getColumns().add(eMailColumn);
        
        TableColumn<Client, String> phoneNumbColumn = new TableColumn<>("phoneNumber");
        phoneNumbColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumb"));
        ClientTableView.getColumns().add(phoneNumbColumn);

    }

    public Scene createScene() {
        return new Scene(rootGridPane, width, hight);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == backBtn) {
            mainFX.primaryStage.setTitle("FX Window");
            mainFX.primaryStage.setScene(mainFX.primary);
        }
        if (event.getSource() == newClientBtn) {
            String Id = IdField.getText();
            String PermNumb = PermNumbField.getText();
            String phoneNumb = phoneNumbField.getText();
            String name = nameField.getText();
            String eMail = eMailField.getText();


            createClient(Id, PermNumb,name,eMail,phoneNumb);

            tableSync();
            clearTextFields();
        }

        if (event.getSource() == updateClientBtn) {
            String Id = IdField.getText();
            String PermNumb = PermNumbField.getText();
            String phoneNumb = phoneNumbField.getText();
            String nameNumb = nameField.getText();
            String eMailNumb = eMailField.getText();
          
            updateClient( Id,  PermNumb,nameNumb,eMailNumb, phoneNumb);

            tableSync();
            clearTextFields();
        }
        if (event.getSource() == deleteClientBtn) {
            deleteClient(IdField.getText());

            tableSync();
            clearTextFields();
        }
        if (event.getSource() == ClientTableView) {
        	Client selectedClient = ClientTableView.getSelectionModel().getSelectedItem();
            if (selectedClient != null) {
                IdField.setText(selectedClient.getId());
                PermNumbField.setText(selectedClient.getPermNumb());
                
            }
        }
    }
    
    

	public void createClient(String id, String permNumb,String name,String eMail ,String  phoneNumb) {
    	Client d = new Client( id,permNumb,name,eMail ,phoneNumb);
        ClientList.add(d);
    }


    public void tableSync() {
        List<Client> items = ClientTableView.getItems();
        items.clear();
        for (Client d : ClientList) {
            if (d instanceof Client) {
                items.add((Client) d);
            }
        }
    }

    public void updateClient(String id, String permNumb,String name,String eMail ,String  phoneNumb) {
        for (Client d : ClientList) {
            if ((d.getId()).equals(id)) {
                d.setId(id);
                d.setPermNumb(permNumb);
                d.setPermNumb(phoneNumb);
                d.setName(name);
                d.seteMail(eMail);
            }
        }
    }

    public void deleteClient(String Id) {
        for (int i = 0; i < ClientList.size(); i++) {
            if (ClientList.get(i).getId().equals(Id)) {
                ClientList.remove(i);
                break;
            }
        }
    }

    public void clearTextFields() {
        IdField.setText("");
        PermNumbField.setText("");
        phoneNumbField.setText("");
        nameField.setText("");
        eMailField.setText("");
    }
}
