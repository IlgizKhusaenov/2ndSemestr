package ru.kpfu.itis.group403.khusaenov.DynamicList;

public class ParamElem<T> {
    private T value;
    private ParamElem<T> next;

    public ParamElem(T value, ParamElem<T> head) {
        this.value = value;
        next = head;
    }

    public ParamElem(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ParamElem getNext() {
        return next;
    }

    public void setNext(ParamElem next) {
        this.next = next;
    }

    public String toString() {
        return (String) getValue();
    }

    @Override
    public boolean equals(Object obj) {
        return ((ParamElem<T>) obj).getValue().equals(getValue());
    }
}

