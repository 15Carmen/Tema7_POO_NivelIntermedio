package ejercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaramos las variables
        int segundos;

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //Creamos el objeto
        Hora hora = new Hora(23, 59, 59);

        //Le pedimos al usuario que introduzca cuantos segundos quiere incrementar la hora
        System.out.println("Introduce cuantos segundos quieres incrementar la hora");
        segundos = sc.nextInt();

        //Incrementamos la hora
        hora.incrementaSegundo(segundos);

        //Mostramos la hora
        System.out.println(hora);
    }
}