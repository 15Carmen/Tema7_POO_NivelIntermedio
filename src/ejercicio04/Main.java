package ejercicio04;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Para añadir nuevo disco se piden los datos por teclado y se añade a la primera posición del array donde esté libre.
 * Para ello se debe crear un contador en el programa principal. Este contador debe aumentar cuando insertamos un disco
 * nuevo y disminuir cuando borramos un disco y es el código con el que se guarda el disco.
 *
 * Para modificar un disco debemos de buscarlo por su código y pedir al usuario por teclado los nuevos datos del disco.
 *
 * Para borrarlo debemos pedir al usuario el código del disco a borrar y poner en su código la palabra “LIBRE”,
 * así estará disponible para insertar nuevos discos.
 *
 * Comprueba que funciona correctamente introduciendo valores a los discos y probando las opciones del CRUD.
 */

/**
 * Clase principal
 */
public class Main {

    /**
     * Declaramos el scanner para poder leer por teclado
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int opc;                //Variable donde vamos a guardar la opción del menú que el usuario elija
        boolean salir = false;  //Variable que usaremos para salir del menú
        int contador = 0;       //Variable que usaremos para contar los discos que hay en el array

        //Declaramos un array de discos tipo Disco de 10 posiciones
        Disco[] arrayDiscos = new Disco[10];

        //Crear u objeto tipo disco y asignarlo a cada posición del array
        for (int i = 0; i < arrayDiscos.length; i++) {
            arrayDiscos[i] = new Disco();
        }

        //Mientras salir sea false, seguimos ejecutando el menú
        do {
            //Mostramos el menú por pantalla
            pintarMenu();
            opc = sc.nextInt();

            //Según la opción que elija el usuario, ejecutamos el código correspondiente
            switch (opc) {
                case 1: {   //Listado de los discos introducidos en el array
                    listado(arrayDiscos);
                    break;
                }
                case 2: {   //Introducimos un nuevo disco en el array
                    //Primero tenemos que ver que posicion del array está libre
                    posicionLibre(arrayDiscos);

                    //Si el contador es menor que 0, es que no hay más espacio en el array
                    if (contador < 0) {
                        System.out.println("No hay más espacio en el array");
                    } else {   //Si el contador es mayor o igual que 0, es que hay espacio en el array
                        //Llamamos al método que nos permite añadir un nuevo disco
                        nuevoDisco(arrayDiscos, contador);
                    }
                    break;
                }

                case 3: {    //Modificamos un disco del array
                    modificarDisco(arrayDiscos);
                    break;
                }
                case 4: {    //Borramos un disco del array

                    //Pedimos el código del disco que queremos borrar
                    System.out.println("Introduce el código del disco que quieres borrar: ");
                    String codigo = sc.next();

                    //Buscamos el disco en el array
                    for (int i = 0; i < arrayDiscos.length; i++) {
                        if (arrayDiscos[i].getCodigo().equals(codigo)) {
                            //Borramos el disco del array
                            arrayDiscos[i] = null;
                            contador--;
                            break;
                        }
                    }
                    break;
                }
                case 5: {    //Salimos del menú
                    System.out.println("Hasta pronto!");
                    salir = true;
                    break;
                }
                default: {   //Si el usuario introduce una opción no válida, mostramos un mensaje de error
                    System.out.println("Opción no válida");
                }
            }
        } while (!salir);  //Fin del do-while

    }//Fin del main

    /**
     * Método para mostrar el menú
     */
    private static void pintarMenu() {
        System.out.println("""
                COLECCIÓN DE DISCOS
                ===================
                1. Listado.
                2. Nuevo Disco.
                3. Modificar.
                4. Borrar.
                5. Salir.
                """);
    }

    /**
     * Método para mostrar el listado de discos
     *
     * @param arrayDiscos
     */
    private static void listado(Disco[] arrayDiscos) {
        for (Disco disco : arrayDiscos) {
            if (!disco.getCodigo().equals("LIBRE")) {
                System.out.println(disco);
            }else {
                System.out.println("No hay discos");
            }
        }
    }

    /**
     * Método para añadir un nuevo disco al array de discos
     *
     * @param discos   Array de discos
     * @param contador Contador de la posición del array
     * @return Devuelve el contador
     */
    private static int nuevoDisco(Disco[] discos, int contador) {

        //Declaramos las variables
        String codigo;          //Variable donde vamos a guardar el código del disco
        String autor;           //Variable donde vamos a guardar el autor del disco
        String titulo;          //Variable donde vamos a guardar el título del disco
        String genero;          //Variable donde vamos a guardar el género del disco
        int duracion;           //Variable donde vamos a guardar la duración del disco

        codigo = String.valueOf(contador);

        //Pedimos los datos del disco al usuario

        System.out.println("Introduce el autor del disco: ");
        autor = sc.next();

        System.out.println("Introduce el título del disco: ");
        titulo = sc.next();

        System.out.println("Introduce el género del disco: ");
        genero = sc.next();

        System.out.println("Introduce la duración del disco: ");
        sc.nextLine();
        duracion = sc.nextInt();

        //Creamos el objeto disco
        discos[posicionLibre(discos)] = new Disco(codigo, autor, titulo, genero, duracion);

        contador++;

        return contador;

    }

    /**
     * Metodo para buscar la primera posición libre del array
     *
     * @param arrayDisco array de discos
     * @return la posición libre del array si hay alguna, -1 si el array está lleno
     */
    private static int posicionLibre(Disco[] arrayDisco) {
        //Declaramos la variable
        int posicion = 0;

        //Recorremos el array hasta encontrar una posición libre
        while (posicion < arrayDisco.length && !arrayDisco[posicion].getCodigo().equals("LIBRE")) {
            posicion++;
        }

        //Si el array está lleno, devolvemos -1
        if (posicion == arrayDisco.length) {
            posicion = -1;
        }

        return posicion;
    }

    /**
     * Método que modificará un disco elegido por el usuario del array de discos
     *
     * @param arrayDiscos Array de discos
     */
    private static void modificarDisco(Disco[] arrayDiscos) {

        //Pedimos el código del disco que queremos modificar
        System.out.println("Introduce el código del disco que quieres modificar: ");
        int codigo = sc.nextInt();

        //Buscamos el disco en el array

        if (!arrayDiscos[codigo].getCodigo().equals("LIBRE")) {
            //Pedimos los nuevos datos del disco al usuario
            System.out.println("Introduce el autor del disco: ");
            String autor = sc.next();
            System.out.println("Introduce el título del disco: ");
            String titulo = sc.next();
            System.out.println("Introduce el género del disco: ");
            String genero = sc.next();
            System.out.println("Introduce la duración del disco: ");
            int duracion = sc.nextInt();

            //Modificamos el disco en el array
            arrayDiscos[codigo] = new Disco(String.valueOf(codigo), autor, titulo, genero, duracion);
        }else {
            System.out.println("No existe ningún disco con ese código");
        }

    }

}//Fin de la clase

