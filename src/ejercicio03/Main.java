package ejercicio03;

public class Main {
    public static void main(String[] args) {

        //Creamos los objetos fecha
        Fecha fechaVacia = new Fecha();
        Fecha fechaHoy = new Fecha(10, 4, 2023);
        Fecha fechaErronea = new Fecha(30, 2, 2002);

        //Mostramos los tres objetos fecha
        System.out.println("Fecha vacia: " + fechaVacia);
        System.out.println("Fecha de hoy: " + fechaHoy);
        System.out.println("Fecha erronea: " + fechaErronea);
        System.out.println(fechaErronea.fechaCorrecta());

        //si la fecha es correcta
        fechaVacia.diaSiguiente();
        fechaHoy.diaSiguiente();
        fechaErronea.diaSiguiente();

        System.out.println("Fecha vacia: " + fechaVacia);
        System.out.println("Fecha de hoy: " + fechaHoy);
        System.out.println("Fecha erronea: " + fechaErronea);

    }
}
