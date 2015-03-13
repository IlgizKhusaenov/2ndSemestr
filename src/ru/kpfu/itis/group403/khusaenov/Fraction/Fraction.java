package ru.kpfu.itis.group403.khusaenov.Fraction;

import java.util.Scanner;

public class Fraction {

    int euclidAlgorithm(int a, int b) throws ArithmeticException{
        if (b == 0)
            throw new ArithmeticException("Division by zero");
        int r;
        while (b != 0) {
            r = a%b;
            a = b; b = r;
        }
        return a;
    }

    void fraction(int a, int b) {
        int aux = euclidAlgorithm(a, b);
        a /= aux; b /= aux;
        System.out.println(a + "/" + b);
    }

    public static void main(String[] args) {
        Fraction f = new Fraction();
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        f.euclidAlgorithm(a, b);
        f.fraction(a, b);
    }
}
