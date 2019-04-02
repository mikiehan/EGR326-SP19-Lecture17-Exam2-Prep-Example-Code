package iterator;
import java.util.Iterator;
import java.util.List;

public class ListOfList implements Iterator<String> {
    private List<List<String>> list;
    private int outerIndex;
    private int innerIndex;

    public ListOfList(List<List<String>> list){
        this.list = list;
        outerIndex = 0;
        innerIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if(outerIndex < list.size()){
            List<String> innerList = list.get(outerIndex);
            return innerIndex < innerList.size();
        }else{
            return false;
        }
    }

    @Override
    public String next() {
        List<String> innerList = list.get(outerIndex);
        String str = innerList.get(innerIndex);
        innerIndex++;
        if(innerIndex == innerList.size()) {
            outerIndex++;
            innerIndex = 0;
        }
        return str;
    }
}
