package apalaktikh.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; 


public class mainFX extends Application 
{//arxikopoihsh stage and scene
     static Stage primaryStage;
     static Scene primary;
	static Scene VehicleScene;
	static Scene RentalScene;
	static Scene CitiesScene;
     static Scene StoreScene;
     static Scene ClientScene;
     
     
     
     
     public static void main(String[] args) {
 		launch(args);
 	
     }
     
     
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		//desimo neon skinwn me kuria
		sceneCreator mainSceneCreator=new mainSceneCreator(650,400);
		primary=mainSceneCreator.createScene();
		
		sceneCreator VehicleSceneCreator=new VehicleSceneCreator(650,450);
        VehicleScene =VehicleSceneCreator.createScene();
		 
        sceneCreator RentalSceneCreator=new RentalSceneCreator(650,450);
        RentalScene = RentalSceneCreator.createScene();
        
        sceneCreator CitySceneCreator=new CitySceneCreator(650,450);
        CitiesScene=CitySceneCreator.createScene();
		  
     sceneCreator StoresSceneCreator=new StoresSceneCreator(650,450);
     StoreScene=StoresSceneCreator.createScene();
     
     sceneCreator ClientSceneCreator=new ClientSceneCreator(650,450);
     ClientScene=ClientSceneCreator.createScene();
     
        //emfanish 
		primaryStage.setTitle("Car Rental Servise");
		primaryStage.setScene(primary);
		primaryStage.show();
			
	}
	
}

