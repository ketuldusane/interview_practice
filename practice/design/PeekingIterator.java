package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Peeking Iterator
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next()
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */

public class PeekingIterator<T> implements Iterator<T> {
  private T nextVal;
  private boolean containsNext;
  private Iterator<T> iterator;

  public PeekingIterator(Iterator<T> iterator) {
    // initialize any member here.
    this.iterator = iterator;
  }

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3));
    PeekingIterator<Integer> p = new PeekingIterator<>(l.iterator());
    System.out.println(p.next());
    System.out.println(p.peek());
    System.out.println(p.next());
    System.out.println(p.next());
    System.out.println(p.hasNext());
  }

  // Returns the next element in the iteration without advancing the iterator.
  public T peek() {
    if (!containsNext) {
      containsNext = true;
      nextVal = iterator.next();
    }
    return nextVal;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public T next() {
    if (!containsNext) {
      return iterator.next();
    }
    T result = nextVal;
    nextVal = null;
    containsNext = false;
    return result;
  }

  @Override
  public boolean hasNext() {
    return containsNext || iterator.hasNext();
  }
}

//public class PeekingIterator implements Iterator<Integer> {
//  private Integer nextVal;
//  private boolean containsNext;
//  private Iterator<Integer> iterator;
//
//  public PeekingIterator(Iterator<Integer> iterator) {
//    // initialize any member here.
//    this.iterator = iterator;
//  }
//
//  // Returns the next element in the iteration without advancing the iterator.
//  public Integer peek() {
//    if (!containsNext) {
//      containsNext = true;
//      nextVal = iterator.next();
//    }
//    return nextVal;
//  }
//
//  // hasNext() and next() should behave the same as in the Iterator interface.
//  // Override them if needed.
//  @Override
//  public Integer next() {
//    if (!containsNext) {
//      return iterator.next();
//    }
//    Integer result = nextVal;
//    nextVal = null;
//    containsNext = false;
//    return result;
//  }
//
//  @Override
//  public boolean hasNext() {
//    return containsNext || iterator.hasNext();
//  }
//}
