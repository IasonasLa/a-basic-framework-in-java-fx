package apalaktikh.gui;

import java.util.ArrayList;
import java.util.List;


import apalaktikh.City;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

 public class CitySceneCreator extends sceneCreator implements EventHandler<MouseEvent> {
     
	ArrayList<City> Cites;
	GridPane CityPane,inputePane;
	FlowPane ButtonPane;
	Label city,code;
	TextField cityN ,codeN;
	TableView<City> citysPane;
	Button updateBtn,DeleteBtn,newCityBtn,backBtn,tableView;

	public CitySceneCreator(double width, double hight) {
		super(width, hight);
		Cites=new ArrayList<>();
		CityPane=new GridPane();
		inputePane=new GridPane();
		ButtonPane=new FlowPane();
		city=new Label(" Cities ");
		code=new Label("Code of Cities");
		cityN=new TextField();
		codeN=new TextField();
		citysPane=new TableView<>();
		updateBtn=new Button("Update");
		DeleteBtn=new Button("Delete");
		newCityBtn=new Button("New City");
		backBtn=new Button("Back");
		tableView=new Button("View all the cities");
		
		backBtn.setOnMouseClicked(this);
		updateBtn.setOnMouseClicked(this);
		DeleteBtn.setOnMouseClicked(this);
		newCityBtn.setOnMouseClicked(this);
		
		City.MAX_CODE++;
		
		
		ButtonPane.setVgap(10);
		ButtonPane.getChildren().add(tableView);
		ButtonPane.getChildren().add(newCityBtn);
		ButtonPane.getChildren().add(DeleteBtn);
		ButtonPane.getChildren().add(updateBtn);
		ButtonPane.setAlignment(Pos.BOTTOM_CENTER);
		
		inputePane.add(city, 0, 0);
		inputePane.add(cityN, 1, 0);
		inputePane.add(code, 0, 1);
		inputePane.add(codeN, 1, 1);
		inputePane.setAlignment(Pos.TOP_RIGHT);
		inputePane.setVgap(10);
		inputePane.setHgap(10);
		
		CityPane.setVgap(10);
		CityPane.setHgap(10);
		CityPane.add(citysPane, 0, 0);
		CityPane.add(inputePane, 1, 0);
		CityPane.add(ButtonPane, 0, 2);
		CityPane.add(backBtn, 1, 2);
		
		 TableColumn <City,String> cityColumn =new TableColumn<>("City");
		    cityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		    citysPane.getColumns().add(cityColumn); 
		    
		    TableColumn <City,String> codeColumn =new TableColumn<>("Code");
		    codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
		    citysPane.getColumns().add(codeColumn); 
	}

	@Override
	public void handle(MouseEvent event) {
		
		if(event.getSource()==backBtn);
		{
			mainFX.primaryStage.setTitle("Car Renatl Servise");
		    mainFX.primaryStage.setScene(mainFX.primary);
		
	}
		if(event.getSource()==newCityBtn) {
			String  cite=cityN.getText();
			String Code=codeN.getText();
			
			createCity(cite,Code);
			tableSync();
			clearTextFields();
		}
	 if(event.getSource()==updateBtn) {
		 String name=cityN.getText();
		 String Code=codeN.getText();
		City City=citysPane.getSelectionModel().getSelectedItem();
	 
		 updateCity(name,Code);
		 tableSync();
	     clearTextFields();
	 }
	if(event.getSource()==DeleteBtn) {
		 
		
	   DeleteCity( codeN.getText());
	   tableSync();
	     clearTextFields();
	}
	}

	
	Scene createScene() {
		// TODO Auto-generated method stub
		return new Scene(CityPane,width,hight);
	}
 public void  createCity(String cite,String Code) {
City a=new City(Code,cite);
 Cites.add(a);
 
 
 }
 
 public void DeleteCity(String Code) {
 int i;
	 for(i=0;i<Cites.size();i++) {
        if(Cites.get(i).getCode()==Code){ 
        	Cites.remove(i);
        	break;
	 }}
 }
 public void tableSync() {
     List<City> items = citysPane.getItems();
     items.clear();
     for (City d : Cites) {
         if (d instanceof City) {
             items.add((City) d); 
}
         }
     }
 
 public void clearTextFields() {
     cityN.setText("");
     codeN.setText("");
     
 }
 public void updateCity(String name,String Code) {
	 for(City n : Cites ) {
	  if(n.getCityName().equals(name)) {    
	 n.setCode(Code);
 }}}}


	
	
