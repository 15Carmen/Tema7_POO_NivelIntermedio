package ejercicio03;

public class Main {
    public static void main(String[] args) {

        //Creamos un objeto fecha
        Fecha fecha = new Fecha(30, 4, 2002);

        //si la fecha es correcta
        if (fecha.fechaCorrecta()) {
            //Indicamos que la fecha es correcta y mostramos la fecha actual así como la fecha del día siguiente
            System.out.println("La fecha introducida es correcta.");
            System.out.println("La fecha actual es: " + fecha);
            fecha.diaSiguiente(fecha);
            System.out.println("La fecha del día siguiente es: " + fecha);
        } else {    //Si la fecha no es correcta mostramos un mensaje de error
            System.out.println("La fecha introducida no es correcta.");
        }



    }
}
