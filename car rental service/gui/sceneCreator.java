package apalaktikh.gui;

import javafx.scene.Scene;

public abstract class sceneCreator {
    double width;
    double hight;
    public sceneCreator(double width,double hight) {
    	this.width=width;
    	this.hight=hight;
    }
    abstract Scene createScene();
}
