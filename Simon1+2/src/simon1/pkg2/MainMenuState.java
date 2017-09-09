/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Warren
 */
public class MainMenuState extends State{

    public MainMenuState(String name) {
        super(name);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, Simon12.screenwidth, Simon12.screenheight);
        
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font(30));
        gc.fillText("Press 1 for Simon's Quest 1.\nPress 2 for Simon's Quest 2", Simon12.screenwidth/3, Simon12.screenheight/3);
    }

    @Override
    public void update() {
       
    }

    @Override
    public void handle(KeyEvent arg0) {
         if (arg0.getCode() == KeyCode.DIGIT1)
            {
                Simon12.sm.setState("simon1");
            }
          if (arg0.getCode() == KeyCode.DIGIT2)
            {
                Simon12.sm.setState("simon2");
            }
    }
    
}
