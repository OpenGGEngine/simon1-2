/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2;

import simon1.pkg2.simon2.Simon2State;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import simon1.pkg2.MainMenuState;
import simon1.pkg2.simon1.Simon1State;
import simon1.pkg2.State;
import simon1.pkg2.StateMachine;

/**
 *
 * @author Warren
 */
public class Simon12 extends Application implements EventHandler <KeyEvent>{
    public static final int screenwidth = 1200, screenheight = 550;
    final static Canvas screen = new Canvas(screenwidth, screenheight);
    final GraphicsContext gc = screen.getGraphicsContext2D();
    
    public static StateMachine sm = new StateMachine();
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();

        Scene scene = new Scene(root, screenwidth, screenheight);
        root.getChildren().add(screen);
        
        //Set Up States
        
        State mm  = new MainMenuState("mainmenu");
        State s1 = new Simon1State("simon1");
        State s2 = new Simon2State("simon2");
        
        sm.addState(mm);   sm.addState(s1);   sm.addState(s2);
        
        sm.setState("mainmenu");
        
        scene.setOnKeyPressed(this);
        
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, screenwidth, screenheight);
                sm.render(gc);
            }
        }.start();
        
        
        
        
        primaryStage.setTitle("Simon's Quest 1 + 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        sm.handle(event);
    }
    
}
