public class Location {
  private int x=0;
  private int y=0;
  
  public Location(int _x, int _y){
    x=_x;
    y=_y;
  }
  
  public int getX() { return x; }
  public int getY() { return y; }
  public double distanceTo(Location l) {
    int xdiff = l.x-this.x;
    int ydiff = l.y-this.y;
    return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
  }
}
