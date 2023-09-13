package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
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
            
               
            File imgFile = new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/src/resources/player/up_1.png");
            if (!imgFile.exists()) {
                System.out.println("Image file NOT FOUND at: " + imgFile.getAbsolutePath());}
            else if (!imgFile.canRead()) {
                System.out.println("No READ perms for file at: " + imgFile.getAbsolutePath());
            } else {
                System.out.println("Loading valid image file from: " + imgFile.getAbsolutePath());
            }

            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/right_2.png"));
            



            /*
            up1 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/up_1.png"));
            up2 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/up_2.png"));
            down1 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/down_1.png"));
            down2 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/down_2.png"));
            left1 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/left_1.png"));
            left2 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/left_2.png"));
            right1 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/right_1.png"));
            right2 = ImageIO.read(new File("/Users/Noah/Documents/GIT/Java_Game/Java_Game/resources/player/right_2.png"));
            */
            
            
 

            


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
