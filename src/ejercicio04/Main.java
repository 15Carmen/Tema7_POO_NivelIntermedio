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

        //Declaramos el array de discos
        Disco[] discos = new Disco[10];

        //Mientras salir sea false, seguimos ejecutando el menú
        do {
            //Mostramos el menú por pantalla
            pintarMenu();
            opc = sc.nextInt();

            //Según la opción que elija el usuario, ejecutamos el código correspondiente
            switch (opc) {
                case 1: {   //Listado de los discos introducidos en el array
                    System.out.println(Arrays.asList(discos));
                    break;
                }
                case 2: {   //Introducimos un nuevo disco en el array

                    //Pedimos los datos del disco al usuario
                    System.out.println("Introduce el código del disco: ");
                    String codigo = sc.next();

                    System.out.println("Introduce el autor del disco: ");
                    String autor = sc.next();

                    System.out.println("Introduce el título del disco: ");
                    String titulo = sc.next();

                    System.out.println("Introduce el género del disco: ");
                    String genero = sc.next();

                    System.out.println("Introduce la duración del disco: ");
                    int duracion = sc.nextInt();

                    //Creamos el objeto disco
                    Disco disco = new Disco(codigo, autor, titulo, genero, duracion);

                    //Añadimos el disco al array

                    if (discos[contador] == null) {
                        discos[contador] = disco;
                        contador++;
                        break;
                    }

                }

                case 3: {    //Modificamos un disco del array

                    //Pedimos el código del disco que queremos modificar
                    System.out.println("Introduce el código del disco que quieres modificar: ");
                    String codigo = sc.next();

                    //Buscamos el disco en el array
                    for (int i = 0; i < discos.length; i++) {
                        if (discos[i].getCodigo().equals(codigo)) {
                            //Pedimos los nuevos datos del disco al usuario
                            System.out.println("Introduce el código del disco: ");
                            codigo = sc.next();
                            System.out.println("Introduce el autor del disco: ");
                            String autor = sc.next();
                            System.out.println("Introduce el título del disco: ");
                            String titulo = sc.next();
                            System.out.println("Introduce el género del disco: ");
                            String genero = sc.next();
                            System.out.println("Introduce la duración del disco: ");
                            int duracion = sc.nextInt();

                            //Creamos el objeto disco
                            Disco disco = new Disco(codigo, autor, titulo, genero, duracion);

                            //Modificamos el disco en el array
                            discos[i] = disco;
                            break;
                        }
                    }
                    break;
                }
                case 4: {    //Borramos un disco del array

                    //Pedimos el código del disco que queremos borrar
                    System.out.println("Introduce el código del disco que quieres borrar: ");
                    String codigo = sc.next();

                    //Buscamos el disco en el array
                    for (int i = 0; i < discos.length; i++) {
                        if (discos[i].getCodigo().equals(codigo)) {
                            //Borramos el disco del array
                            discos[i] = null;
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
    public static void pintarMenu() {
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
}//Fin de la clase

