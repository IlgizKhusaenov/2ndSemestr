package ru.kpfu.itis.group403.khusaenov.TableViewer;

public interface ViewProvider<T> {

    int getColumnCount();
    String  getHeader(int r);
    String getLabel(T a, int r);
}
