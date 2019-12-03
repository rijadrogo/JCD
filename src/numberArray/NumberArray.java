package numberArray;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class NumberArray<T extends Number> implements Iterable<T> {
    private T[] arrayNumber;
    private int currentSize;
    private int currentCapacity;
    private final float growthFactor = 1.5F;

    private void resizeIfNecessary() {
        if (currentSize == currentCapacity) {
            currentCapacity = (int) (currentSize * growthFactor + 0.5F);
            arrayNumber = Arrays.copyOf(arrayNumber, currentCapacity);
        }
    }


    public boolean add(T number) {
        // ako nemam dovoljan broj elemenata povecaj duzinu
        resizeIfNecessary();
        // ima dovoljan broj samo dodaj na kraj
        arrayNumber[currentSize] = number;
        ++currentSize;
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

    public void remove(int index) {
        for (int i = index + 1; i < currentSize; ++i) {
            arrayNumber[i - 1] = arrayNumber[i];
        }
        --currentSize;
    }

    public void remove(T number) {
        for (int i = 0; i < currentSize; ++i) {
            if (arrayNumber[i].equals(number)) {
                remove(i);
                --i;
            }
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
        for (T elem : arrayNumber) {
            if (elem.equals(o)) {
                return true;
            }
        }
        return false;
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
