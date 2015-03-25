package ru.kpfu.itis.group403.khusaenov.TableViewer;

import java.util.Comparator;

public interface ModelProvider<T> {
    T[] getModel();

    Comparator<T> getComporator();


}
