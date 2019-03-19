package pkg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class Sprite { //all characters inherit from these general traits of a sprite

    private Timer deathAnimationTimer;

    private boolean isVisible;
    private BufferedImage image; //image of sprite (change color?)
    private int xPos;
    private int yPos;
    private boolean isDying;

    private final String explImagePath = "src/alienExpl.png";

    boolean isVisible() {
        return isVisible;
    }

    void setVisible(boolean visible) {
        isVisible = visible;
    }


    void die() {
        try {
            image = ImageIO.read(new File(explImagePath));
        } catch (IOException ex) {
            System.err.println("No explosion image found. Make sure the file is in the src folder");
            return;
        }
        setImage(image);
        deathAnimationTimer = new Timer();
        deathAnimationTimer.schedule(alienDeathAnimation, 300);
        //isVisible = false;
    }


    private TimerTask alienDeathAnimation = new TimerTask() {
        @Override
        public void run() {
            setVisible(false);
        }
    };


    BufferedImage getImage() {
        return image;
    }

    void setImage(BufferedImage image) {
        this.image = image;
    }

    int getxPos() {
        return xPos;
    }

    void setxPos(int xPos) {
        this.xPos = xPos;
    }

    int getyPos() {
        return yPos;
    }

    void setyPos(int yPos) {
        this.yPos = yPos;
    }

    boolean isDying() {
        return isDying;
    }

    void setDying(boolean dying) {
        isDying = dying;
    }
}
