/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Warren
 */
public abstract class State {
    String name;

    public State(String name) {
        this.name = name;
    }
    public abstract void render(GraphicsContext gc);
    public abstract void update();
    public abstract void handle(KeyEvent arg0);
}
