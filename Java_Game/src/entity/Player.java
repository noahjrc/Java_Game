package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/entity/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/entity/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/entity/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/entity/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/entity/player/left1.png"));  
            left2 = ImageIO.read(getClass().getResourceAsStream("/entity/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/entity/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/entity/player/right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.upPr == true) {
            direction = "up";
            y -= speed;
        }
        if (keyHandler.downPr == true) {
            direction = "down";
            y += speed;
        }
        if (keyHandler.leftPr == true) {
            direction = "left";
           x -= speed;
        }
        if (keyHandler.rightPr == true) {
            direction = "right";
            x+= speed;
        }
    }

    public void draw(Graphics2D g2) {
 
        BufferedImage img = null;

        switch (direction) {
            case "up":
                img = up1;
                break;
            case "down":
                img = down1;
                break;
            case "left":       
                img = left1;
                break;
            case "right":   
                img = right1;
                break;
        }

        g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
        

    }
}
