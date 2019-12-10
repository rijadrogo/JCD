package numberArray;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class NumberArray<T extends Number> implements Iterable<T> {

    private T[] arrayNumber;
    private int currentSize;

    private void resize(int size) {
        if (size < this.size())
            return;

        // prva alokacija
        if (arrayNumber == null) {
            arrayNumber = (T[]) new Number[size];

        } else {
            // vec imamo neke elemente u nizu treba realocirat i kopirati stare elemente
            arrayNumber = Arrays.copyOf(arrayNumber, size);
        }

    }

    public NumberArray() {
    }

    public NumberArray(int capacity) {
        arrayNumber = (T[]) new Number[capacity];// Unckhecked cast
    }

    public NumberArray(Collection<? extends T> c) {
        this.addAll(c);
    }

    public boolean add(T number) {
        this.add(currentSize, number);
        return true;
    }

    public void add(int index, T number) {
        // ako nemam dovoljan broj elemenata povecaj duzinu
        // duzinu povecam za 1.5 cisto nako
        if (currentSize == this.size())
            this.resize((int) ((1 + currentSize) * 1.5F));
        // pomjeram sve elemente udesno da bi napravio mjesto za element
        for (int i = currentSize; i > index; --i) {
            arrayNumber[i] = arrayNumber[i - 1];
        }
        // dodajem element
        arrayNumber[index] = number;
        ++currentSize;
    }

    // NOTE what to do when arrayNumber is emmpty and index != 0
    // BUG implement simpler
    public boolean addAll(int index, Collection<? extends T> c) {
        if (currentSize == 0) {
            this.resize(c.size());
            currentSize = this.size();
            int i = 0;
            for (T e : c) {
                arrayNumber[i++] = e;
            }
            return true;

        } // ako nemam dovoljno prostora alociraj
        else if (currentSize + c.size() > this.size()) {
            arrayNumber = Arrays.copyOf(arrayNumber, currentSize + c.size());
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
        return this.addAll(currentSize, c);
    }

    public T remove(int index) {
        // spasavamo element koji vracamo
        T temp = arrayNumber[index];
        // prepisujemo elemente preko njega
        for (int i = index + 1; i < currentSize; ++i) {
            arrayNumber[i - 1] = arrayNumber[i];
        }
        // azuriramo velicinu
        --currentSize;
        return temp;
    }

    public boolean remove(T number) {
        // nalazim poziciju elementa number
        int i = this.indexOf(number);
        // ako ga nema vrati false
        if (i == -1) {
            return false;
        }
        // u suprotnom izbaci i vrati true
        this.remove(i);
        return true;
    }

    public void removeAll(T number) {
        // metoda remove izbacuje prvo pojavljivanje elmenta number i vrati true ako ga je uzbacila
        // a ako ne postoji u nizu vraca false
        while (this.remove(number)) {
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
        // idemo sa kraja niza i trazimo element number, zatim vracamo njegov index
        for (int i = currentSize - 1; i >= 0; --i) {
            if (arrayNumber[i].equals(number)) {
                return i;
            }
        }
        // ako ne postoji vracamo -1
        return -1;
    }

    public boolean contains(T number) {
        return this.indexOf(number) != -1;
    }


    public boolean retainAll(Collection<? extends T> c) {
        boolean flag = false;
        // prolazim kroz niz
        for (int i = 0; i < currentSize; ++i) {
            // ako elmenent unutar niza ne postoji u kolekciji c izbaci ga
            if (!c.contains(arrayNumber[i])) {
                this.remove(i);
                flag = true;
            }
        }
        return flag;
    }

    public int indexOf(T number) {
        // prolazim kroz niz i trazim element number i vracam njegov indeks
        for (int i = 0; i < currentSize; ++i) {
            if (arrayNumber[i].equals(number)) {
                return i;
            }
        }
        // ako ne postoji vracam -1
        return -1;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        for (int i = fromIndex; toIndex < currentSize; ++i, ++toIndex) {
            arrayNumber[i] = arrayNumber[toIndex];
        }
    }

    public boolean removeAll(@NotNull Collection<? extends T> c) {
        // izbacujem sve elmente koje se nalaze u kolekciji iz niza
        for (T t : c) {
            this.remove(t);
        }
        return true;
    }

    public int size() {
        return currentSize;
    }

    public void ensureCapacity(int requiredCapacity) {
        this.resize(requiredCapacity);
        if (requiredCapacity < currentSize) {
            currentSize = this.size();
        }
    }

    public void trimToSize() {
        arrayNumber = Arrays.copyOf(arrayNumber, currentSize);
    }

    public NumberArray<T> subList(int fromIndex, int toIndex) {
        // vracam podniz koji se sastoji od elemenata na pozicji fromIndex do toIndex
        NumberArray<T> newNA = new NumberArray<>(toIndex - fromIndex);
        for (int i = 0; i < newNA.size(); ++i) {
            newNA.set(i, arrayNumber[toIndex++]);
        }
        return newNA;
    }

    public void clear() {
        arrayNumber = null;
    }

    public boolean removeIf(Predicate<? super T> filter) {
        boolean flag = false;
        // prolazim kroz kolekciju
        for (int i = 0; i < currentSize; ++i) {
            // izbacujem elmente koji zadovoljavaju uslov
            if (filter.test(arrayNumber[i])) {
                this.remove(i);
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

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort(arrayNumber, c);
    }

    public Object[] toArray() {
        return Arrays.copyOf(arrayNumber, this.currentSize);
    }


    // Bug?? is this ok?
    public <U extends Number> U[] toArray(U[] array) {
        if (array.length < currentSize) {
            return (U[]) Arrays.copyOf(arrayNumber, this.currentSize, array.getClass());
        }
        System.arraycopy(arrayNumber, 0, array, 0, this.currentSize);
        if (array.length > this.currentSize) {
            array[this.currentSize] = null;
        }
        return array;
    }

    // TODO implement
    // public Object clone();
    // public Spliterator<T> spliterator();
}

