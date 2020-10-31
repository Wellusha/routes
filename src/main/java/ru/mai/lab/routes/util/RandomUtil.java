package ru.mai.lab.routes.util;


public class RandomUtil {

    public static int nextInt(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    public static double nextDouble(double min, double max) {
        return min + (Math.random() * max);
    }

}
