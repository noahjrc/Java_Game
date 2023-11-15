package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.world_x + entity.solid_area.x;
        int entityRightWorldX = entity.world_x + entity.solid_area.x + entity.solid_area.width;
        int entityTopWorldY = entity.world_y + entity.solid_area.y;
        int entityBottomWorldY = entity.world_y + entity.solid_area.y + entity.solid_area.height;

        int entityLeftTileCol = entityLeftWorldX / gp.tileSize;
        int entityRightTileCol = entityRightWorldX / gp.tileSize;

        int entityTopTileRow = entityTopWorldY / gp.tileSize;
        int entityBottomTileRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopTileRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapTileNum[entityLeftTileCol][entityTopTileRow];
                tileNum2 = gp.tm.mapTileNum[entityRightTileCol][entityTopTileRow];
                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    entity.collision_on = true;
                }
                break;
            case "down":

                break;
            case "left":

                break;
            case "right":

                break;

        }

    }
};
