package org.example;

/*
پنج شنبه
۱ آذر

برنامه‌ای بنویسید که:
        • یک آرایه از اعداد صحیح را دریافت کند.
        • دو ترد ایجاد کند:
        1.ترد اول مجموع اعداد آرایه را محاسبه کند.
        2. ترد دوم بزرگ‌ترین عدد آرایه را پیدا کند.
        • نتیجه هر دو ترد را به ترتیب چاپ کند.
        */
public class ParallelExecution {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 2, 15, 6, 23, 9, 12};

        final int[] sumResult = new int[1];
        final int[] maxResult = new int[1];

        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int number : numbers) {
                    sum += number;
                }
                sumResult[0] = sum;
            }
        });
        Thread maxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int max = Integer.MIN_VALUE;
                for (int number : numbers) {
                    if (max < number) {
                        max = number;
                    }
                }
                maxResult[0] = max;
            }
        });

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("Sum: " + sumResult[0]);
        System.out.println("Max: " + maxResult[0]);
    }
}

