package apalaktikh.gui;

import java.util.ArrayList;
import java.util.List;

import apalaktikh.Car;
import apalaktikh.Rental;
import apalaktikh.Vihicle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class RentalSceneCreator extends sceneCreator implements EventHandler<MouseEvent>{
	//arxikopoihsh
	ArrayList<Rental>reserve;
	FlowPane mainFlow;
    Button newRentalBtn,viewBtn,DeleteBtn,backBtn;
    GridPane inputePane,rentalPane;
    Label reserv,reservCar,reservNumb,pick,date,time,amount,returnD,returnH;
    TextField reservT,reservCarT,reservNumbT,pickT,timeT,dateT,amountT,returnDT,returnHT;
    TableView<Rental> reserveTableView;
	public RentalSceneCreator(double width, double hight) {
		super(width, hight);
		//initiallaze
		reserve=new ArrayList<>();
		mainFlow=new FlowPane();
		newRentalBtn=new Button("new Rental");
		viewBtn=new Button("View All Renatls");
		DeleteBtn=new Button("Delete");
		backBtn=new Button("Back");
		inputePane=new GridPane();
		rentalPane=new GridPane();
		reserv=new Label("Reservation ");
		reservCar=new  Label("Reserved Car");
		reservNumb=new Label("Reservatio Number");
		pick=new Label("Pick up Place");
		date=new Label("pick up Date");
		time=new Label("pick up hour");
		amount=new Label("Amount to be Payed");
		returnD=new Label("Return Date");
		returnH=new Label("Return Hour");
		reservT=new TextField();
		reservCarT=new TextField();
		reservNumbT=new TextField();
		pickT=new TextField();
		dateT=new TextField();
		timeT=new TextField();
		amountT=new TextField();
		returnDT=new TextField();
		returnHT=new TextField();
		reserveTableView=new TableView<>();
		
		//costumize buttonFlowPane
		mainFlow.setHgap(10);
		mainFlow.getChildren().add(newRentalBtn);
		mainFlow.getChildren().add(viewBtn);
		mainFlow.getChildren().add(DeleteBtn);
		mainFlow.setAlignment(Pos.BOTTOM_CENTER);
		//customize iputeGridePane 
		inputePane.setAlignment(Pos.TOP_RIGHT);
		inputePane.setVgap(10);
		inputePane.setHgap(10);
		inputePane.add(reserv, 0, 0);
		inputePane.add(reservT, 1, 0);
		inputePane.add(reservCar, 0, 1);
		inputePane.add(reservCarT, 1, 1);
		inputePane.add(reservNumb, 0, 2);
		inputePane.add(reservNumbT, 1, 2);
		inputePane.add(pick, 0, 3);
		inputePane.add(pickT, 1, 3);
		inputePane.add(date,0, 4);
		inputePane.add(dateT, 1,4);
		inputePane.add(amount, 0, 5);
		inputePane.add(amountT, 1, 5);
		inputePane.add(returnD, 0, 6);
		inputePane.add(returnDT, 1, 6);
		inputePane.add(returnH,0,7);
		inputePane.add(returnHT, 1, 7);
		//customize generalGridePane
		rentalPane.setVgap(10);
		rentalPane.setHgap(10);
		rentalPane.add(inputePane, 1, 0);
		rentalPane.add(reserveTableView, 0,0);
		rentalPane.add(mainFlow, 0, 2);
	    rentalPane.add(backBtn, 1, 2);
		//customize tableView
	    TableColumn <Rental,String> reservColumn =new TableColumn<>("Reservation");
	    reservColumn.setCellValueFactory(new PropertyValueFactory<>("reservation"));
	    reserveTableView.getColumns().add(reservColumn);
	    
	    TableColumn <Rental,String>reservedCarColumn =new TableColumn<>("Reserved Car");
	   reservedCarColumn.setCellValueFactory(new PropertyValueFactory<>("reservedCar"));
	    reserveTableView.getColumns().add(reservedCarColumn);
	    
	    TableColumn <Rental,String> reservationColumn =new TableColumn<>("Reservation Name ");
	    reservationColumn.setCellValueFactory(new PropertyValueFactory<>("reservationName"));
	    reserveTableView.getColumns().add(reservationColumn);
	    
	    TableColumn <Rental,String> pickColumn =new TableColumn<>("Pick Up Place ");
	    pickColumn.setCellValueFactory(new PropertyValueFactory<>("pickUpplace"));
	    reserveTableView.getColumns().add(pickColumn);
	    
	    TableColumn <Rental,String> dateColumn =new TableColumn<>("Date");
	    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
	    reserveTableView.getColumns().add(dateColumn);
	    
	    TableColumn <Rental,String> timeColumn =new TableColumn<>("Time of pick up ");
	    timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
	    reserveTableView.getColumns().add(timeColumn);
	    
	    TableColumn <Rental,String> amountColumn =new TableColumn<>("Amount to be payed");
	   amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
	    reserveTableView.getColumns().add(amountColumn);
	   
	    
	    //attache events
	    backBtn.setOnMouseClicked(this);
	    newRentalBtn.setOnMouseClicked(this);
	    viewBtn.setOnMouseClicked(this);
	    DeleteBtn.setOnMouseClicked(this);
	}

	
	public void handle(MouseEvent event) {
		//back button
		if(event.getSource()==backBtn);
		{
			mainFX.primaryStage.setTitle("Car Renatl Servise");
		    mainFX.primaryStage.setScene(mainFX.primary);
		}
		//new rental button
		if(event.getSource()==newRentalBtn)
		{
			String re1 =reservT.getText();
			String re2 = reservCarT.getText();
			String re3=reservNumbT.getText();
			String re4=pickT.getText();
			String re5=dateT.getText(); 
			String re6=timeT.getText();
			String re7=amountT.getText();
			String  re8=returnDT.getText();
			String re9=returnHT.getText();
			createRental(re1,re2,re3,re4,re5,re6,re7);
			
			tableSync();
			clearTextFields();
		}
		//delete button
		if(event.getSource()==DeleteBtn) {
		deleteRental(reservT.getText());
			
		 tableSync();
         clearTextFields();
			
	}}

	
	Scene createScene() {
		
		return new Scene(rentalPane,width,hight);
	}
	
 public void deleteRental(String numb) {
	for(int i=0; i<reserve.size();i++) {
	if(reserve.get(i).getReservation().equals(numb)) {
	reserve.remove(i);
	break;
		
	 
 }}}
	public void clearTextFields() {
		reservT.setText(" ");
		reservCarT.setText(" ");
		reservNumbT.setText(" ");
		pickT.setText(" ");
		amountT.setText(" ");
		timeT.setText(" ");
		dateT.setText(" ");
		returnDT.setText(" ");
		returnHT.setText(" ");
	}
	public void tableSync() {
		 List<Rental> items=reserveTableView.getItems();
		 items.clear();
		 for (Rental n : reserve) {
			 if (n instanceof Rental) {
				 items.add((Rental) n);
			 }
		 }
	 }
	public void createRental(String re1,String re2,String re3 ,String re4 ,String re5 ,String re6, String re7
			) {
	Rental n =new Rental(re1,re2,re3,re4,re5,re6,re7);
	
	reserve.add(n);}
	 
}
