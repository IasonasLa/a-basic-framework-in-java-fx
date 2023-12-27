package apalaktikh.gui;

import java.util.ArrayList;
import java.util.List;

import apalaktikh.Car;
import apalaktikh.Vihicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class VehicleSceneCreator extends sceneCreator implements EventHandler<MouseEvent> {
	static Scene vehicle;
	ArrayList<Car>  fleet;
    FlowPane buttonFlowPane;
    Button newVehicleBtn,updateBtn,deleteBtn,backBtn,view,searchb;
	ComboBox comboBox;
	Label permNumb,module,gasType,carType,cc,worth,seatHight,storageUnite,carSeat,DoorNumb;
	TextField permNumbT,moduleT,gasTypeT,carTypeT,ccT,worthT,wildCard1,wildCard2,search;
	TableView<Car> VihecleTableView;
	GridPane ViheclePane,inputeGridePane;
	
	public VehicleSceneCreator(double width, double hight) {
		super(width, hight);
	    fleet = new ArrayList<>();
	    ViheclePane= new GridPane();
	    inputeGridePane=new GridPane();
	    buttonFlowPane=new FlowPane();
	    permNumb=new Label("Permission Number");
	    module=new Label("Module");
	    gasType=new Label("Gas Type");
	    carType=new Label("car Type");
	    cc=new Label("Cc");
	    worth=new Label("Worth");
	    seatHight=new Label("Seat Hight");
	    storageUnite=new Label("Storage unite");
	    carSeat= new Label("Car seat");
	    DoorNumb=new Label("Door number");
	    permNumbT=new TextField();
	    moduleT=new TextField();
	    gasTypeT=new TextField();
	    carTypeT=new TextField();
	    ccT=new TextField();
	    worthT=new TextField();
	    wildCard1=new TextField();
	    wildCard2=new TextField();
	    searchb=new Button("Search Vehicle");
	    view=new Button("view all vehicles");
	    newVehicleBtn=new Button("New vihecle");
	    updateBtn=new Button("Update");
	    deleteBtn=new Button("Delete");
	    backBtn=new Button("Back");
	    search=new TextField();
	    VihecleTableView=new TableView<>();
	    
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Car",
			        "Two wheeled"
			        );
			final ComboBox comboBox = new ComboBox(options);
			// buttons
			buttonFlowPane.setHgap(10);
			buttonFlowPane.getChildren().add(view);
			buttonFlowPane.getChildren().add(newVehicleBtn);
			buttonFlowPane.getChildren().add(updateBtn);
			buttonFlowPane.getChildren().add(deleteBtn);
			buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
			//Input grid pane
			inputeGridePane.setAlignment(Pos.TOP_RIGHT);
			inputeGridePane.setVgap(10);
			inputeGridePane.setHgap(10);
			inputeGridePane.add(permNumb, 0, 0);
			inputeGridePane.add(permNumbT, 1, 0);
			inputeGridePane.add(module, 0, 1);
			inputeGridePane.add(moduleT, 1, 1);
			inputeGridePane.add(gasType, 0, 2);
			inputeGridePane.add(gasTypeT, 1, 2);
			inputeGridePane.add(carType, 0, 3);
			inputeGridePane.add(carTypeT, 1, 3);
			inputeGridePane.add(cc,0, 4);
			inputeGridePane.add(ccT, 1,4);
			inputeGridePane.add(worth, 0, 5);
			inputeGridePane.add(worthT, 1, 5);
			inputeGridePane.add(seatHight, 0, 6);
			inputeGridePane.add(wildCard1, 1, 6);
			inputeGridePane.add(storageUnite,0,7);
			inputeGridePane.add(wildCard2, 1, 7);
				//Vehicle grid pane
			ViheclePane.setVgap(10);
			ViheclePane.setHgap(10);
			ViheclePane.add(inputeGridePane, 1, 0);
			ViheclePane.add(searchb, 1, 2);
			ViheclePane.add(search, 1, 1);
			ViheclePane.add(VihecleTableView, 0,0);
			ViheclePane.add(buttonFlowPane, 0, 2);
		    ViheclePane.add(backBtn, 1, 2);
		    
		    
		    TableColumn <Car,String> permColumn =new TableColumn<>("Permission Number");
		    permColumn.setCellValueFactory(new PropertyValueFactory<>("permissionNumb"));
		    VihecleTableView.getColumns().add(permColumn);
		    
		    TableColumn <Car,String> moduleColumn =new TableColumn<>("Module");
		    moduleColumn.setCellValueFactory(new PropertyValueFactory<>("module"));
		    VihecleTableView.getColumns().add(moduleColumn);
		    
		    TableColumn <Car,String> gasTypeColumn =new TableColumn<>("Gas type ");
		    gasTypeColumn.setCellValueFactory(new PropertyValueFactory<>("gasType"));
		    VihecleTableView.getColumns().add(gasTypeColumn);
		    
		    TableColumn <Car,String> carTypeColumn =new TableColumn<>("Car type ");
		    carTypeColumn.setCellValueFactory(new PropertyValueFactory<>("carType"));
		    VihecleTableView.getColumns().add(carTypeColumn);
		    
		    TableColumn <Car,String> ccColumn =new TableColumn<>("cc");
		    ccColumn.setCellValueFactory(new PropertyValueFactory<>("cc"));
		    VihecleTableView.getColumns().add(ccColumn);
		    
		    TableColumn <Car,String> worthColumn =new TableColumn<>("Worth");
		    worthColumn.setCellValueFactory(new PropertyValueFactory<>("worth"));
		    VihecleTableView.getColumns().add(worthColumn);
		    
		    TableColumn <Car,String> seatColumn =new TableColumn<>("Seat hight / Car seats");
		    seatColumn.setCellValueFactory(new PropertyValueFactory<>("carSeats"));
		    VihecleTableView.getColumns().add(seatColumn);
		    
		    TableColumn <Car,String> storageColumn =new TableColumn<>("Storage unites / Door number");
		    storageColumn.setCellValueFactory(new PropertyValueFactory<>("doorsNumb"));
		    VihecleTableView.getColumns().add(storageColumn);
		    
		    backBtn.setOnMouseClicked(this);
		    newVehicleBtn.setOnMouseClicked(this);
		    updateBtn.setOnMouseClicked(this);
		    deleteBtn.setOnMouseClicked(this);
		    view.setOnMouseClicked(this);		    
			}
	
	@Override
	Scene createScene() {
		return new Scene(ViheclePane,width,hight);
	}


	
	public void handle(MouseEvent event) {
		
		
		
		
		
		
		
		
		
		
        
    if(event.getSource()==searchb) {
    	if(search.getText().isEmpty()) {
    	String name=search.getText();
    	search(name);
    	
    	
    		
    		
    }}
    	
		if(event.getSource()==backBtn);
		{
			mainFX.primaryStage.setTitle("Car Renatl Servise");
		    mainFX.primaryStage.setScene(mainFX.primary);
		}
		if(event.getSource()==newVehicleBtn) {
			String permNum =permNumbT.getText();
			String modul = moduleT.getText();
			String gas=gasTypeT.getText();
			String carT=carTypeT.getText();
			int c=Integer.parseInt(ccT.getText()); 
			int worth=Integer.parseInt(worthT.getText());
			int seat=Integer.parseInt(wildCard1.getText());
			int  unite=Integer.parseInt(wildCard2.getText());
			createVehicle(permNum,modul,gas,carT,c,worth,seat,unite);
			
			tableSync();
			clearTextFields();
		}
		if (event.getSource() == deleteBtn) {
		    deleteVehicle(permNumbT.getText());

		    tableSync();
		    clearTextFields();
	}//update
	if(event.getSource()==updateBtn) {
		String perm=permNumbT.getText();
		String modul = moduleT.getText();
		String gas=gasTypeT.getText();
		String carT=carTypeT.getText();
		int c=Integer.parseInt(ccT.getText()); 
		int worth=Integer.parseInt(worthT.getText());
		int seat=Integer.parseInt(wildCard1.getText());
		int  unite=Integer.parseInt(wildCard2.getText());
		updateVehicle(perm,modul,gas,carT,c,worth,seat,unite);
		tableSync();
		clearTextFields();
	
	
	
	
	}
	//provlima sthn emfanish tou pinaka
	if (event.getSource() == VihecleTableView) {
       Car selectedCar = VihecleTableView.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            permNumbT.setText(selectedCar.getPermissionNumb());
           moduleT.setText(selectedCar.getModule());
            ccT.setText(Integer.toString(selectedCar.getCc()));
           gasTypeT.setText(selectedCar.getGasType());
           carTypeT.setText(selectedCar.getCarType());
	       worthT.setText(Integer.toString(selectedCar.getWorth()));
           wildCard1.setText(Integer.toString(selectedCar.getCarSeats()));
           wildCard2.setText(Integer.toString(selectedCar.getDoorsNumb()));
	
	}}}
	//den prosthetei panw apo 1 antikimena
 public void createVehicle(String numb,String mod,String gas, String carT,int c, int worth,int seat,int unite){
	 Car n=new Car(numb, mod, gas, carT, c, worth, seat, unite);
	 fleet.add(n);
}
 public void tableSync() {
	 List<Car> items=VihecleTableView.getItems();
	 items.clear();
	 for (Car n : fleet) {
		 if (n instanceof Car) {
			 items.add((Car) n);
		 }
	 }
 }
 public void search(String numb) {
	
	 
	 List<Car> search=VihecleTableView.getItems();
	 search.clear();
	 for(Car n: fleet) {
	if(n.getPermissionNumb().equals(numb)) { 
	search.add((Car)n); 
	 
	 
 }}}
 
 
 
 
public void clearTextFields() {
	permNumbT.setText(" ");
	moduleT.setText(" ");
	gasTypeT.setText(" ");
	carTypeT.setText(" ");
	ccT.setText(" ");
	worthT.setText(" ");
	wildCard1.setText(" ");
	wildCard2.setText(" ");
}
public void deleteVehicle(String name) {
    for (int i = 0; i <  fleet.size(); i++) {
        if ( fleet.get(i).getPermissionNumb().contentEquals(name)) {
        	 fleet.remove(i);
            break;
}}}

public void updateVehicle(String perm,String module,String gas,String car,int c,int worth,int seat,int unite){
	for(Car n : fleet) {
    if((n.getPermissionNumb()).equals(perm)) {
      n.setModule(module);
      n.setGasType(gas);
      n.setCarType(car);
      n.setCc(c);
      n.setWorth(worth);
      n.setCarSeats(seat);
     ((Car) n).setDoorsNumb(unite);


}}}}
