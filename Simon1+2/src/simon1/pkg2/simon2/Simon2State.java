/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon1.pkg2.simon2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import simon1.pkg2.Simon12;
import simon1.pkg2.State;

/**
 *
 * @author Warren
 */
public class Simon2State extends State {

    int camx = 0, camy = 0;
    int posx = 0, posy = 0;
    int camwidth = Simon12.screenwidth, camheight = Simon12.screenheight;
    int maxX = 0;
    int maxY = 0;

    Map mainmap = new Map(100, 100);

    public Simon2State(String name) {
        super(name);
        mainmap.mapdata[0][4] = 1;
        mainmap.mapdata[1][4] = 2;
        mainmap.mapdata[0][10] =3;
        mainmap.mapdata[4][6] = 1;
         mainmap.mapdata[5][6] = 1;
          mainmap.mapdata[10][6] = 2;
           mainmap.mapdata[20][6] = 1;

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.AZURE);
        gc.fillRect(0, 0, Simon12.screenwidth, Simon12.screenheight);
        drawMap(gc);
    }

    @Override
    public void update() {

    }

    public void drawMap(GraphicsContext gc) {
        gc.setFill(Color.BROWN);
       

        int spriteScreenX = Simon12.screenwidth / 2;
        int spriteScreenY = Simon12.screenheight / 2;

        int maxX = mainmap.height * mainmap.tilesize - this.camwidth;
        this.maxY = mainmap.width * mainmap.tilesize - this.camheight;

        int x = posx - spriteScreenX;
        int y = posy - spriteScreenY;

        x = Math.max(0, Math.min(x, maxX));
        y = Math.max(0, Math.min(y, maxY));

        if (posx< this.camwidth / 2
                || posx > this.maxX + this.camwidth / 2) {
            spriteScreenX = posx - x;
        }
        // top and bottom sides
        if (posy < this.camheight/ 2
                || posy > this.maxY + this.camheight / 2) {
            spriteScreenY = posy - y;
        }
        this.camx = x;
        this.camy = y;
        
        int startCol = (int) Math.floor(this.camx / mainmap.tilesize);
        int endCol = startCol + (this.camwidth / mainmap.tilesize);
        int startRow = (int) Math.floor(this.camy / mainmap.tilesize);
        int endRow = startRow + (this.camheight / mainmap.tilesize);

        int offsetX = -this.camx + startCol * mainmap.tilesize;
        int offsetY = -this.camy + startRow * mainmap.tilesize;
        
        for (int c = startCol; c < endCol; c++) {
            for (int r = startRow; r < endRow; r++) {

                int tile = mainmap.mapdata[c][r];
                int x1 = (c - startCol) * mainmap.tilesize + offsetX;
                int y1 = (r - startRow) * mainmap.tilesize + offsetY;
                if (tile != 0) { // 0 => empty tile
                    switch(tile){
                        case 1:
                            gc.setFill(mainmap.color1);
                            break;
                        case 2:
                            gc.setFill(mainmap.color2);
                            break;
                        case 3:
                            gc.setFill(mainmap.color3);
                            break;
                    }
                    gc.fillRect(x1, y1, mainmap.tilesize, mainmap.tilesize);
                    /* this.ctx.drawImage(
                     this.tileAtlas, // image
                     (tile - 1) * map.tsize, // source x
                     0, // source y
                     map.tsize, // source width
                     map.tsize, // source height
                     Math.round(x), // target x
                     Math.round(y), // target y
                     map.tsize, // target width
                     map.tsize // target height
                     );*/
                }
            }
        }
        gc.fillRect(spriteScreenX, spriteScreenY, 30,30);
    }

    @Override
    public void handle(KeyEvent arg0) {
        if (arg0.getCode() == KeyCode.DOWN) {
            this.posy += 30;
        }
        if (arg0.getCode() == KeyCode.UP) {
            this.posy -= 30;
        }
        if (arg0.getCode() == KeyCode.LEFT) {
            this.posx -= 30;
        }
        if (arg0.getCode() == KeyCode.RIGHT) {
            this.posx += 30;
        }
    }

}
