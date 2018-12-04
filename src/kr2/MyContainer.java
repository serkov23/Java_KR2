package kr2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MyContainer<T extends Automobile> extends ArrayList<T> {
    public int frequency(T element) {
        return Collections.frequency(this, element);
    }

    public T binSearch(T element) throws EmptyContainerException, NoSuchElementException {
        if (isEmpty())
            throw new EmptyContainerException("Empty container");
        MyContainer<T> tmp = (MyContainer<T>) clone();
        Collections.sort(tmp);
        int res = Collections.binarySearch(tmp, element);
        if (res >= size() || res < 0 || !(tmp.get(res).compareTo(element)==0))
            throw new NoSuchElementException("no element found");
        return tmp.get(res);
    }

    public T min() throws EmptyContainerException {
        if (isEmpty())
            throw new EmptyContainerException("Empty container");
        return Collections.min(this);
    }

    public void print(FileWriter out) throws IOException {
        for (var i : this)
            i.println(out);
    }
}
