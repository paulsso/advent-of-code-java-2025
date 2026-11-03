package aoc.collections;

import java.util.ArrayList;

/**
 * An extension of ArrayList that acts as a factory for a bidirectional iterator.
 */
public class BidirectionalArrayList<E> extends ArrayList<E> {

    /**
     * Factory method to instantiate the custom iterator.
     *
     * @return A new instance of a bidirectional iterator bound to this list.
     */
    public BidirectionalIterator<E> bidirectionalIterator() {
        int i = this.size() / 2;
        return new CustomBiDirIterator(i);
    }

    /**
     * Private inner class encapsulating the iteration state.
     * It holds an implicit reference to the enclosing aoc.collections.BidirectionalArrayList instance.
     */
    private class CustomBiDirIterator implements BidirectionalIterator<E> {

        // Internal state mapping to the traversal position
        private int cursor;

        CustomBiDirIterator(int initialCursor) {
            CustomBiDirIterator.this.cursor = initialCursor;
        }

        @Override
        public boolean hasNext() {
            return cursor < BidirectionalArrayList.this.size() - 1 && BidirectionalArrayList.this.size() > 0;
        }

        @Override
        public E next() {
            E e;
            if ( hasNext() ) {
                ++cursor;
                e = BidirectionalArrayList.this.get(cursor);
            } else if ( cursor == BidirectionalArrayList.this.size() - 1 ) {
                cursor = 0;
                e = BidirectionalArrayList.this.get(cursor);
            }
            else {
                throw new ArrayIndexOutOfBoundsException("The array is empty");
            }

            return e;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0 && BidirectionalArrayList.this.size() > 0;
        }

        @Override
        public E previous() {
            E e;
            if ( hasPrevious() ) {
                --cursor;
                e = BidirectionalArrayList.this.get(cursor);
            } else if ( cursor == 0 ) {
                cursor = BidirectionalArrayList.this.size() - 1;
                e = BidirectionalArrayList.this.get(cursor);
            }
            else {
                throw new ArrayIndexOutOfBoundsException("The array is empty");
            }
            return e;
        }
    }
}