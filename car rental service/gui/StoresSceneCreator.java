    
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

    import apalaktikh.Store;
    

 public class StoresSceneCreator extends sceneCreator implements EventHandler<MouseEvent> {
	    //  List of Stores
	    ArrayList<Store> StoreList;
	    //	Flow Pane
	    FlowPane buttonFlowPane;
	    //	Grid Panes
	    GridPane rootGridPane, inputFieldsPane;
	    //	Second Scene buttons
	    Button newStoresBtn, updateStoresBtn, deleteStoresBtn, backBtn;
	    //	Second scene labels
	    Label codeLbl, sureNameLbl,CityLbl;
	    //	Second scene TextFields
	    TextField codeField, sureNameField,CityField;
	    //	TableView
	    TableView<Store> StoreTableView;

	    public StoresSceneCreator(double width, double height) {
	        super(width, height);
	        //  Initialize fields
	        StoreList = new ArrayList<>();
	        rootGridPane = new GridPane();
	        buttonFlowPane = new FlowPane();
	        
	        codeLbl = new Label("Code: ");
	        CityLbl=new Label("City: ");
	        sureNameLbl = new Label("sureName: ");
	       
	        codeField = new TextField();
	        sureNameField = new TextField();
	        CityField= new TextField();
	        
	        newStoresBtn = new Button("New Store");
	        updateStoresBtn = new Button("Update");
	        deleteStoresBtn = new Button("Delete");
	        backBtn = new Button("Go Back");
	        inputFieldsPane = new GridPane();
	        StoreTableView = new TableView<>();

	        //  Attach events
	        backBtn.setOnMouseClicked(this);
	        newStoresBtn.setOnMouseClicked(this);
	        updateStoresBtn.setOnMouseClicked(this);
	        deleteStoresBtn.setOnMouseClicked(this);
	        StoreTableView.setOnMouseClicked(this);

	        //  Customize buttonFlowPane
	        buttonFlowPane.setHgap(10);
	        buttonFlowPane.getChildren().add(newStoresBtn);
	        buttonFlowPane.getChildren().add(updateStoresBtn);
	        buttonFlowPane.getChildren().add(deleteStoresBtn);
	        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

	        // Customize inputFieldsPane
	        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
	        inputFieldsPane.setVgap(10);
	        inputFieldsPane.setHgap(10);
	        inputFieldsPane.add(codeLbl, 0, 0);
	        inputFieldsPane.add(codeField, 1, 0);
	        inputFieldsPane.add(sureNameLbl, 0, 1);
	        inputFieldsPane.add(sureNameField, 1, 1);
	        inputFieldsPane.add(CityLbl, 0, 2);
	        inputFieldsPane.add(CityField, 1, 2);
	       

	        // Customize rootGridPane
	//		rootScene2.setGridLinesVisible(true);
	        rootGridPane.setVgap(10);
	        rootGridPane.setHgap(10);
	        rootGridPane.add(inputFieldsPane, 1, 0);
	        rootGridPane.add(StoreTableView, 0, 0);
	        rootGridPane.add(buttonFlowPane, 0, 2);
	        rootGridPane.add(backBtn, 1, 2);

	        //  Customize StoreTableView
	        TableColumn<Store, String> codeColumn = new TableColumn<>("code");
	        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
	        StoreTableView.getColumns().add(codeColumn);

	        TableColumn<Store, String> sureNameColumn = new TableColumn<>("sureName");
	        sureNameColumn.setCellValueFactory(new PropertyValueFactory<>("sureName"));
	        StoreTableView.getColumns().add(sureNameColumn);
	        
	        TableColumn<Store, String> CityColumn = new TableColumn<>("City");
	        	CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
	        StoreTableView.getColumns().add(CityColumn);

	    }

	    @Override
	    public Scene createScene() {
	        return new Scene(rootGridPane, width, hight);
	    }

	    @Override
	    public void handle(MouseEvent event) {
	        if (event.getSource() == backBtn) {
	        	mainFX.primaryStage.setTitle("Car rental Servise");
	            mainFX.primaryStage.setScene(mainFX.primary);
	        }
	        if (event.getSource() == newStoresBtn) {
	            String code = codeField.getText();
	            String sureName = sureNameField.getText();
	            String City = CityField.getText();
	            
	            createStore(code,sureName,City);

	            tableSync();
	            clearTextFields();
	        }

	        if (event.getSource() == updateStoresBtn) {
	            String code = codeField.getText();
	            String sureName = sureNameField.getText();
	            String City = CityField.getText();


	            updateStore(code,sureName,City);

	            tableSync();
	            clearTextFields();
	        }
	        if (event.getSource() == deleteStoresBtn) {
	            deleteStores(codeField.getText());

	            tableSync();
	            clearTextFields();
	        }
	        if (event.getSource() == StoreTableView) {
	            Store selectedStore = StoreTableView.getSelectionModel().getSelectedItem();
	            if (selectedStore != null) {
	                codeField.setText(selectedStore.getCode());
	                sureNameField.setText(selectedStore.getSureName());
	                CityField.setText(selectedStore.getCity());
	            }
	        }
	    }


	    public void updateStore(String code, String sureName, String City) {for (Store d : StoreList) {
            if ((d.getCode()).equals(code)) {
                d.setSureName(sureName);
                d.setCity(City);
            }
          }
			
		}

		public void createStore(String code,  String sureName,String City) {
	        Store d = new Store(code, sureName,City);
	        StoreList.add(d);
	    }


	    public void tableSync() {
	        List<Store> items = StoreTableView.getItems();
	        items.clear();
	        for (Store d : StoreList) {
	            if (d instanceof Store) {
	                items.add((Store) d);
	            }
	        }
	    }
 

	    public void deleteStores(String code) {
	        for (int i = 0; i < StoreList.size(); i++) {
	            if (StoreList.get(i).getCode().equals(code)) {
	                StoreList.remove(i);
	                break;
	            }
	        }
	    }

	    public void clearTextFields() {
	        codeField.setText("");
	        sureNameField.setText("");
	        CityField.setText("");
	    }
}



