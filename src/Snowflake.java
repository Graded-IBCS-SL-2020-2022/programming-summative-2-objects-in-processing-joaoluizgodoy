/* YOU SHOULD COMPLETE AND UNDERSTAND THE Ball.java and Bubble.java parts first! */
/* DON'T FORGET TO RENAME THE FILE TO Snowflake.java WHEN READY TO TEST! */

class Snowflake {

  private Sketch s;
    private float diameter;
    private float x;
    private float y;
    private int col; 
    private float speedY;
    private float speedX;

    /*
     * SUMMATIVE REQUIRED Implement this entire class. ONLY drawSnowflake() and
     * moveSnowflake() have been implemented for you! I recommend using your
     * Bubble.java as a template. Start by creating your instance variables and
     * constructors.
     */
    /** Draws the flake. */

    public Snowflake(Sketch sketch) {
      s = sketch;
        diameter = s.random(50, 150); // random diameter between 50 and 150
        x = s.random(diameter / 2, s.width - diameter / 2);
        y = s.random(diameter / 2, s.height - diameter / 2);
        col = s.randomColor(false);

        speedX = s.random(1,6);
        speedY = s.random(1,6);
    }

    public float getRadius(){
      return diameter / 2;
    }


    public void drawSnowflake() {
        s.stroke(col);
        s.line(x - getRadius() / 2, y - getRadius() / 2, x + getRadius() / 2, y + getRadius() / 2);
        s.line(x - getRadius() / 2, y + getRadius() / 2, x + getRadius() / 2, y - getRadius() / 2);
        s.line(x - getRadius(), y, x + getRadius(), y);
        s.line(x, y - getRadius(), x, y + getRadius());
    }

    public Snowflake(Sketch sketch, float X, float Y, float snowflakeDiam, int snowflakeColor, float sx, float sy){
      s = sketch;
      x = X;
      y = Y;
      diameter = snowflakeDiam;
      col = snowflakeColor;
      speedX = sx;
      speedY = sy;
    }

    /** Moves the flake */
    public void moveSnowflake() {
        if (x > (s.width - getRadius()) || x < getRadius()) {
            speedX = -speedX;
        }
        if (y < (-getRadius())) {
            y = s.height + getRadius();
        }
        if (y > (s.height + getRadius())) {
            y = -getRadius();
        }
        x += speedX;
        y += speedY;

    }
}
