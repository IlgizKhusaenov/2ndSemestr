package ru.kpfu.itis.group403.khusaenov.quickMultiply;

public class QuickMultiply {

    public static int quickMultiply(int x, int y, int m) {
        int a, b, c;

        int r = (int) (Math.signum(x) * Math.signum(y));
        x = Math.abs(x);
        y = Math.abs(y);

        if (m == 1) {
            if (x == 1 && y == 1) {
                return r;
            }
            return 0;
        }

        int n1 = x >> (m / 2);
        int n2 = (x << (64 - (m / 2)));
        n2 = n2 >>> (64 - (m / 2));
        int n3 = y >> (m / 2);
        int n4 = (y << (64 - (m / 2)));
        n4 = n4 >>> (64 - (m / 2));

        a = quickMultiply(n1, n3, m / 2);
        b = quickMultiply(n1 - n2, n4 - n3, m / 2);
        c = quickMultiply(n2, n4, m / 2);
        return r * (a * (int) (Math.pow(2, m)) + (a + b + c) * (int) (Math.pow(2, m / 2)) + c);
    }


    public static void main(String[] args) {
        int k = quickMultiply(7, -7, 32);
        System.out.println(k);
    }


}