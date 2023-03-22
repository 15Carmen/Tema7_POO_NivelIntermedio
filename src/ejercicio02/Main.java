package ejercicio02;

public class Main {
    public static void main(String[] args) {
        //Creamos el objeto
        Contador contador = new Contador(3);
        Contador contador2 = new Contador(contador);

        contador.incrementar();
        contador2.decrementar();

        System.out.println("Contador 1: " + contador.getCont());
        System.out.println("Contador 2: " + contador2.getCont());


    }
}
