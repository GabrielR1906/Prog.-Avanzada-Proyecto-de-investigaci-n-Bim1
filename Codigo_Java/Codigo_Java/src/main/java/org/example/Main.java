package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Crea un pool de 2 hilos

        // Tarea 1: Sumar los números del 1 al 5
        Future<Integer> future1 = executor.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
                Thread.sleep(100); // Simula un cálculo costoso
            }
            return sum;
        });

        // Tarea 2: Sumar los números del 6 al 10
        Future<Integer> future2 = executor.submit(() -> {
            int sum = 0;
            for (int i = 6; i <= 10; i++) {
                sum += i;
                Thread.sleep(100); // Simula un cálculo costoso
            }
            return sum;
        });

        // Obtiene los resultados de las tareas y los suma
        int totalSum = future1.get() + future2.get();
        System.out.println("La suma total es " + totalSum);

        executor.shutdown(); // Cierra el ExecutorService
}
}