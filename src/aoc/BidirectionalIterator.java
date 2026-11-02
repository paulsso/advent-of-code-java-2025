package aoc;

import java.util.Iterator;

public interface BidirectionalIterator<E> extends Iterator<E> {
    boolean hasPrevious();
    E previous();
}
