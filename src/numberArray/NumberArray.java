package numberArray;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class NumberArray<T extends Number> implements Iterable<T> {
    private T[] arrayNumber;
    private int currentSize;
    private int currentCapacity;

    private void resizeIfNecessary() {
        if (currentSize == currentCapacity) {
            float growthFactor = 1.5F;
            currentCapacity = (int) (currentSize * growthFactor + 0.5F);
            arrayNumber = Arrays.copyOf(arrayNumber, currentCapacity);
        }
    }

    public NumberArray() {
    }

    public NumberArray(int newLength) {

    }

    public boolean add(T number) {
        add(currentSize, number);
        return true;
    }

    public void add(int index, T number) {
        // ako nemam dovoljan broj elemenata povecaj duzinu
        resizeIfNecessary();
        // pomjeram sve elemente udesno da bi napravio mjesto za element
        for (int i = currentSize; i > index; --i) {
            arrayNumber[i] = arrayNumber[i - 1];
        }
        // dodajem element
        arrayNumber[index] = number;
        ++currentSize;
    }

    boolean addAll(int index, Collection<? extends T> c) {
        // ako nemam dovoljno prostora alociraj
        if (currentSize + c.size() > currentCapacity) {
            currentCapacity = currentSize + c.size();
            arrayNumber = Arrays.copyOf(arrayNumber, currentCapacity);
        }

        // pomjeri udesno koliko je potrebno
        int k = currentSize + c.size() - 1;
        for (int i = currentSize - 1; i >= index; --i, ++k) {
            arrayNumber[k] = arrayNumber[i];
        }

        // prepisi kolekciju u moj niz
        k = index;
        for (T t : c) {
            arrayNumber[k++] = t;
        }
        // azuriraj velicinu
        currentSize += c.size();
        return true;
    }

    boolean addAll(Collection<? extends T> c) {
        return addAll(currentSize, c);
    }

    public void remove(int index) {
        for (int i = index + 1; i < currentSize; ++i) {
            arrayNumber[i - 1] = arrayNumber[i];
        }
        --currentSize;
    }

    public boolean remove(T number) {
        int i = indexOf(number);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public void removeAll(T number) {
        while (remove(number)) {
        }
    }

    public T atIndex(int index) {
        return arrayNumber[index];
    }

    public void set(int index, T number) {
        arrayNumber[index] = number;
    }

    T get(int index) {
        return arrayNumber[index];
    }

    boolean isEmpty() {
        return currentSize == 0;
    }

    int lastIndexOf(T o) {
        for (int i = currentSize - 1; i >= 0; --i) {
            if (arrayNumber[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    boolean contains(T o) {
        return indexOf(o) != -1;
    }

    boolean retainAll(Collection<? extends T> c) {
        boolean flag = false;
        for (int i = 0; i < currentSize; ++i) {
            if (!c.contains(arrayNumber[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    int indexOf(T o) {
        for (int i = 0; i < currentSize; ++i) {
            if (arrayNumber[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        for (int i = fromIndex; toIndex < currentSize; ++i, ++toIndex) {
            arrayNumber[i] = arrayNumber[toIndex];
        }
    }

    boolean removeAll(Collection<? extends T> c) {
        for (T t : c) {
            remove(t);
        }
        return true;
    }

    int size() {
        return currentSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < currentSize;
        }

        @Override
        public T next() {
            T temp = arrayNumber[current];
            ++current;
            return temp;
        }
    }

}
