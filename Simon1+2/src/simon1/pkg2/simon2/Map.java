/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2.simon2;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


/**
 *
 * @author Warren
 */
public class Map {
    
    public int[][] mapdata;
    public int width,height;
    public int tilesize = 30;
    
    public Paint color1 = Color.GREEN,color2 = Color.BLUE,color3 = Color.BROWN;
    
    public Map(int width,int height){
        mapdata = new int[width][height];
        this.width = width;
        this.height = height;
    }
}
