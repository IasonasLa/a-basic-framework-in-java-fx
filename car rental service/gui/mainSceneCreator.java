package apalaktikh.gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class mainSceneCreator extends sceneCreator implements EventHandler<MouseEvent> {
	FlowPane mainFlow;
    Button vhlBtn,rnlBtn,ctcBtn,storesBtn,clientBtn;

	public mainSceneCreator(double width, double hight) {
		super(width, hight);
		//initiallaze 
		mainFlow=new FlowPane();
		vhlBtn=new Button("Vehicle");
		rnlBtn=new Button("Rental");
		ctcBtn=new Button("Cities");
		storesBtn=new Button("Stores");
		clientBtn=new Button("Client");
		
		// costumize button flow pane
		mainFlow.getChildren().add(clientBtn);
		mainFlow.getChildren().add(storesBtn);
		mainFlow.getChildren().add(vhlBtn);
		mainFlow.getChildren().add(rnlBtn);
		mainFlow.getChildren().add(ctcBtn);
		
		
		//attach event
		clientBtn.setOnMouseClicked(this);
		vhlBtn.setOnMouseClicked(this);
		rnlBtn.setOnMouseClicked(this);
		ctcBtn.setOnMouseClicked(this);
		storesBtn.setOnMouseClicked(this);
		
		mainFlow.setAlignment(Pos.CENTER);
        mainFlow.setHgap(10);
	}

	
	Scene createScene() {
		return new Scene(mainFlow,width,hight);
	}

	
	public void handle(MouseEvent event) {
		if(event.getSource()==storesBtn) {
			mainFX.primaryStage.setTitle("Store managment");
			mainFX.primaryStage.setScene(mainFX.StoreScene);
		}
		if(event.getSource()==vhlBtn) {
			mainFX.primaryStage.setTitle("Vehicle Managment");
			mainFX.primaryStage.setScene(mainFX.VehicleScene);
			
		}
		if(event.getSource()==rnlBtn) {
			
			mainFX.primaryStage.setTitle("Rental Managment");
			mainFX.primaryStage.setScene(mainFX.RentalScene);
		}
		if(event.getSource()==ctcBtn) {
			mainFX.primaryStage.setTitle("Citites Managment");
			mainFX.primaryStage.setScene(mainFX.CitiesScene);
	}
	if(event.getSource()==clientBtn) {
		mainFX.primaryStage.setTitle("Client Managment");
		mainFX.primaryStage.setScene(mainFX.ClientScene);
		
		
		
	}}

}
