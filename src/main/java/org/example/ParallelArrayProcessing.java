package org.example;

import java.util.Arrays;

public class ParallelArrayProcessing {
    public static void main(String[] args) {
        int[] numbers = {7, 2, 10, 4, 1, 6, 8}; // آرایه نمونه

        // ترد اول: محاسبه مجموع اعداد آرایه
        Thread sumThread = new Thread(() -> {
            int sum = Arrays.stream(numbers).sum();
            System.out.println("Sum of the array: " + sum);
        });

        // ترد دوم: پیدا کردن بزرگ‌ترین عدد آرایه
        Thread maxThread = new Thread(() -> {
            int max = Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
            System.out.println("Max of the array: " + max);
        });

        // شروع تردها
        sumThread.start();
        maxThread.start();

        // منتظر ماندن برای اتمام هر دو ترد
        try {
            sumThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have completed.");
    }
}
/*توضیحات کد:
آرایه نمونه: آرایه‌ای از اعداد صحیح تعریف شده است که می‌توانید آن را تغییر دهید.

ترد اول: با استفاده از کتابخانه Arrays.stream مجموع اعداد آرایه محاسبه و چاپ می‌شود.

ترد دوم: با استفاده از متد Arrays.stream.max بزرگ‌ترین عدد آرایه محاسبه و چاپ می‌شود.

join(): اطمینان حاصل می‌کند که برنامه اصلی منتظر اتمام هر دو ترد می‌ماند*/