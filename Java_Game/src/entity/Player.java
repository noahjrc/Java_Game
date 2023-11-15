package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public final int screen_x;
    public final int screen_y;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;

        screen_x = (gp.screenWidth / 2) - (gp.tileSize / 2);
        screen_y = (gp.screenHeight / 2) - (gp.tileSize / 2);

        solid_area = new Rectangle();
        solid_area.x = 8;
        solid_area.y = 16;
        solid_area.width = 32;
        solid_area.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        world_x = gp.tileSize * 23;
        world_y = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/player/right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.upPr == true || keyHandler.downPr == true || keyHandler.leftPr == true
                || keyHandler.rightPr == true) {

            if (keyHandler.upPr == true) {
                direction = "up";
            }
            if (keyHandler.downPr == true) {
                direction = "down";
            }
            if (keyHandler.leftPr == true) {
                direction = "left";
            }
            if (keyHandler.rightPr == true) {
                direction = "right";
            }

            collision_on = false;
            gp.cChecker.checkTile(this);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE

            if (collision_on == false) {
                switch (direction) {
                    case "up":
                        world_y -= speed;
                        break;
                    case "down":
                        world_y += speed;
                        break;
                    case "left":
                        world_x -= speed;
                        break;
                    case "right":
                        world_x += speed;
                        break;

                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage img = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    img = up1;
                }
                if (spriteNum == 2) {
                    img = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    img = down1;
                }
                if (spriteNum == 2) {
                    img = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    img = left1;
                }
                if (spriteNum == 2) {
                    img = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    img = right1;
                }
                if (spriteNum == 2) {
                    img = right2;
                }
                break;
        }

        g2.drawImage(img, screen_x, screen_y, gp.tileSize, gp.tileSize, null);

    }
}
