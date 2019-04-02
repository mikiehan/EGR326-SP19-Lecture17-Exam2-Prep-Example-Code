package iterator;
import java.util.Iterator;
import java.util.List;

public class ListOfList {
    private List<List<String>> list;

    public ListOfList(List<List<String>> list){
        this.list = list;
    }

    public Iterator<String> getIterator(){
        return new MyIterator();
    }

    //Inner class that implements Iterator interface
    private class MyIterator implements Iterator<String> {
        private int outerIndex = 0;
        private int innerIndex = 0;

        public MyIterator(){
            outerIndex = 0;
            innerIndex = 0;
        }

        @Override
        public boolean hasNext() {
            if (outerIndex < list.size()) {
                List<String> innerList = list.get(outerIndex);
                return innerIndex < innerList.size();
            } else {
                return false;
            }
        }

        @Override
        public String next() {
            List<String> innerList = list.get(outerIndex);
            String str = innerList.get(innerIndex);
            innerIndex++;
            if (innerIndex == innerList.size()) {
                outerIndex++;
                innerIndex = 0;
            }
            return str;
        }
    }
}
