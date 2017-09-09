/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2.simon2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import simon1.pkg2.Simon12;
import simon1.pkg2.State;

/**
 *
 * @author Warren
 */
public class Simon2State extends State{

    public Simon2State(String name) {
        super(name);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.AZURE);
        gc.fillRect(0, 0, Simon12.screenwidth, Simon12.screenheight);
    }
    @Override
    public void update() {
        
    }

    @Override
    public void handle(KeyEvent arg0) {
        
    }
    
}
