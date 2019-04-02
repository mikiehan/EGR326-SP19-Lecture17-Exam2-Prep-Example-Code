package singleton;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
//Make this class Singleton + thread-safe!
public class SomeClass {
    private List<List<String>> list;
    private Map<Integer, String> map;
    private Point p;
    private volatile static SomeClass uniqueInstance;

    public static SomeClass getInstance(){
        if(uniqueInstance == null){
            synchronized (SomeClass.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new SomeClass();
                }
            }
        }
        return uniqueInstance;
    }

    private SomeClass(){
        list = new ArrayList<>();
        map = new TreeMap<>();
        p = new Point(10,20);
    }
    /// more codes here
}
