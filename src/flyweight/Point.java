package flyweight;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

//flyweight and immutable + thread-safe
public final class Point {
    private final int x;
    private final int y;
    private final Rectangle rec; //non primitive type
    private volatile static Map<String,Point> map = new HashMap<>();

    public static Point getInstance(int x, int y, Rectangle rec){
        String key = x + "," + y + "," + rec;
        if (!map.containsKey(key)) {
            synchronized (Point.class) {
                if (!map.containsKey(key)) {
                    map.put(key, new Point(x, y, rec));
                }
            }
        }
        return map.get(key);
    }

    private Point(int x, int y, Rectangle rec) {
        this.x = x;
        this.y = y;
        this.rec = new Rectangle(rec); //rec.clone()
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRec() {
        return new Rectangle(rec);  //rec.clone();
    }

}
