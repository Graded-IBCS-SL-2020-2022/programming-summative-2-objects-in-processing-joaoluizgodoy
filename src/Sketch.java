
/** MAKE SURE TO READ THE README CAREFULLY BEFORE YOU BEGIN EDITING THIS CODE */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import processing.core.PApplet;

public class Sketch extends PApplet {

  /*
   * SUMMATIVE REQUIRED Declare at least four balls, four bubbles, and four
   * snowflakes as instance variables. I have made the first ball for you.
   * 
   * SUMMATIVE OPTIONAL Use *arrays* to store the elements, rather than individual
   * variables.
   */

  Ball[] b;

  Bubble[] bl;

  Snowflake[] s;

  boolean showFlake = false;
  boolean showBall = false;
  boolean showBubble = false;

  boolean stop = false;

  public void settings() {
    size(500, 500);
  }

  /*
   * SUMMATIVE REQUIRED Initialize the balls, bubbles, and snowflakes using your
   * constructors inside of setup(). You must use a non-default-constructor at
   * least once and a default constructor at least once for each type.
   * 
   * I have done the first ball for you.
   */
  public void setup() {
    frameRate(20);
    b = new Ball[] { new Ball(this), new Ball(this), new Ball(this), new Ball(this), new Ball(this, 100, 100, 70, color(255), 0, 10, 10) };

    bl = new Bubble[] { new Bubble(this), new Bubble(this), new Bubble(this), new Bubble(this, 100, 200, 50), new Bubble(this, 100, 200, 50, color(255,150), 0, 3, -7) };

    s = new Snowflake[] { new Snowflake(this), new Snowflake(this), new Snowflake(this), new Snowflake(this), new Snowflake(this, 70, 200, 50, 255, 2, 5)};

  }

  public void draw() {
    background(backroundcol);

    /* SUMMATIVE REQUIRED Draw and move all balls, snowflakes, and bubbles */
    
    if (stop) {
    b[0].drawBall();
    b[1].drawBall();
    b[2].drawBall();
    b[3].drawBall();
    }
    else {
    b[0].drawBall();
    b[0].moveBall();
    b[1].drawBall();
    b[1].moveBall();
    b[2].drawBall();
    b[2].moveBall();
    b[3].drawBall();
    b[3].moveBall();
    }
   

    bl[0].drawBubble();
    bl[0].moveBubble();
    bl[1].drawBubble();
    bl[1].moveBubble();
    bl[2].drawBubble();
    bl[2].moveBubble();
    bl[3].drawBubble();
    bl[3].moveBubble();

    s[0].drawSnowflake();
    s[0].moveSnowflake();
    s[1].drawSnowflake();
    s[1].moveSnowflake();
    s[2].drawSnowflake();
    s[2].moveSnowflake();
    s[3].drawSnowflake();
    s[3].moveSnowflake();

    if (showFlake) {
      s[4].drawSnowflake();
      s[4].moveSnowflake();
    }

    if (showBall) {
      b[4].drawBall();
      b[4].moveBall();
    }

    if (showBubble) {
      bl[4].drawBubble();
      bl[4].moveBubble();
    }

  }

  public void keyPressed() {

    if (key == 'b') {
      showBall = !showBall;
    }

    if (key == 'l') {
      showBubble = !showBubble;
    }

    if (key == 's') {
      showFlake = !showFlake;
    }

    if (keyCode == UP) {
      frameRate(100);
    }

    if (keyCode == DOWN) {
      frameRate(5);
    }

    if (keyCode == BACKSPACE) {
      stop = !stop;
    }

  }

  public void keyReleased() {

    if (keyCode == UP) {
      frameRate(20);
    }

    if (keyCode == DOWN) {
      frameRate(20);
    }
  }

  private int backroundcol;

  public void mouseClicked() {
    backroundcol = randomColor(true);

  }

  /**
   * Convenience method to return a random color
   * 
   * @param transluscent if true, make the color transluscent, otherwise solid
   */
  public int randomColor(boolean transluscent) {
    int alpha;
    if (transluscent) {
      alpha = 125;
    } else {
      alpha = 255;
    }
    return color(random(0, 255), random(0, 255), random(0, 255), alpha);
  }

  /*
   * SUMMATIVE OPTIONAL Add a void method called mousePressed() that stops some or
   * all of the balls from moving when you click the mouse. (it will run
   * automatically when you click if the name is correct)
   * 
   * EXTRA CHALLENGE - can you make it so that only the ball you actually CLICKED
   * stops? (this is a major challenge - you can use the variables mouseX and
   * mouseY to see where the mouse was clicked.)
   */

  public static void main(String[] args) {
    PApplet.main("Sketch");
  }
}