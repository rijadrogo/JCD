package numberArray;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class NumberArray<T extends Number> implements Iterable<T> {

    private T[] arrayNumber;
    private int currentSize;
    private int currentCapacity;

    private void resize(int size) {
        if (size < currentCapacity)
            return;

        if (arrayNumber == null) {
            arrayNumber = (T[]) new Number[currentCapacity];
            currentCapacity = size;
        } else {
            float growthFactor = 1.5F;
            currentCapacity = (int) (currentSize * growthFactor + 0.5F);
            arrayNumber = Arrays.copyOf(arrayNumber, currentCapacity);
        }

    }

    public NumberArray() {
    }

    public NumberArray(int capacity) {
        resize(capacity);
        currentSize = capacity;
    }

    public boolean add(T number) {
        add(currentSize, number);
        return true;
    }

    public void add(int index, T number) {
        // ako nemam dovoljan broj elemenata povecaj duzinu
        resize(currentSize + 1);
        // pomjeram sve elemente udesno da bi napravio mjesto za element
        for (int i = currentSize; i > index; --i) {
            arrayNumber[i] = arrayNumber[i - 1];
        }
        // dodajem element
        arrayNumber[index] = number;
        ++currentSize;
    }

    // BUG what to do when arrayNumber is emmpty and index != 0
    public boolean addAll(int index, Collection<? extends T> c) {
        if (currentSize == 0) {
            resize(c.size());
            currentSize = currentCapacity;
            Iterator<? extends T> iter = c.iterator();
            int i = 0;
            for (T e : c) {
                arrayNumber[i++] = e;
            }
            return true;

        } // ako nemam dovoljno prostora alociraj
        else if (currentSize + c.size() > currentCapacity) {
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

    public T remove(int index) {
        T temp = arrayNumber[index];
        for (int i = index + 1; i < currentSize; ++i) {
            arrayNumber[i - 1] = arrayNumber[i];
        }
        --currentSize;
        return temp;
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

    public T get(int index) {
        return arrayNumber[index];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int lastIndexOf(T number) {
        for (int i = currentSize - 1; i >= 0; --i) {
            if (arrayNumber[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T number) {
        return indexOf(number) != -1;
    }

    public boolean retainAll(Collection<? extends T> c) {
        boolean flag = false;
        for (int i = 0; i < currentSize; ++i) {
            if (!c.contains(arrayNumber[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    public int indexOf(T number) {
        for (int i = 0; i < currentSize; ++i) {
            if (arrayNumber[i].equals(number)) {
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

    public boolean removeAll(Collection<? extends T> c) {
        for (T t : c) {
            remove(t);
        }
        return true;
    }

    public int size() {
        return currentSize;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public void ensureCapacity(int requiredCapacity) {
        resize(requiredCapacity);
        if (requiredCapacity < currentSize) {
            currentSize = currentCapacity;
        }
    }

    public void trimToSize() {
        arrayNumber = Arrays.copyOf(arrayNumber, currentSize);
        currentCapacity = currentSize;
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

    public Object[] toArray() {
        return arrayNumber;
    }

    public NumberArray(Collection<? extends T> c) {
        addAll(c);
    }

    public NumberArray<T> subList(int fromIndex, int toIndex) {
        NumberArray<T> newNA = new NumberArray<>(toIndex - fromIndex);
        for (int i = 0; i < newNA.size(); ++i) {
            newNA.set(i, get(toIndex++));
        }
        return newNA;
    }

    public void clear() {
        arrayNumber = null;
        currentCapacity = currentSize = 0;
    }

    public boolean removeIf(Predicate<? super T> filter) {
        boolean flag = false;
        for (int i = 0; i < currentSize; ++i) {
            if (filter.test(arrayNumber[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;

    }

    public void replaceAll(UnaryOperator<T> operator) {
        for (int i = 0; i < currentSize; ++i) {
            arrayNumber[i] = operator.apply(arrayNumber[i]);
        }
    }

    // TODO implement
    // public <T> T[] toArray(T[] a)
    // public Object clone();
    // public void sort(Comparator<? super T> c);
    // public Spliterator<T> spliterator();
}

