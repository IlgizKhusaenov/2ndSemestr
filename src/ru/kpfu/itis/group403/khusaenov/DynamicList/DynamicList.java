package ru.kpfu.itis.group403.khusaenov.DynamicList;

import java.util.*;

public class DynamicList<T> implements List<T> {

    private ParamElem<T> head;
    private ParamElem<T> tail;

    private int size;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        ParamElem p = head;
        while (p != null)
            if (o.equals(p.getValue()))
                return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T t) {
        ParamElem p = new ParamElem<T>(t);
        if (head == null && tail == null) {
            head = p;
            tail = p;
        } else {
            tail.setNext(p);
            tail = p;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        ParamElem p = head;
        if (o.equals(head.getValue())) {
            head = head.getNext();
            size--;
            return true;
        }
        while (p.getNext().getNext() != null) {
            if (o.equals(p.getNext().getValue())) {
                p.setNext(p.getNext().getNext());
                size--;
                return true;
            }
            p = p.getNext();
        }
        if (o.equals(p.getNext())) {
            p.setNext(null);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object a : c)
            if (!add(((ParamElem<T>) a).getValue()))
                return false;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public T[] toArray(Object[] a) {
        return null;
    }
}
