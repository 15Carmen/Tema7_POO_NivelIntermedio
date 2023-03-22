package ejercicio01;

/**
 * Clase que crea un objeto Hora con los atributos hora, minuto y segundo.
 */
public class Hora {

    //Declaramos los atributos
    /**
     * Atributo donde guaradermos la hora del objeto
     */
    int hora;
    /**
     * Atributo donde guardaremos los minutos de la hora
     */
    int minuto;
    /**
     * Atributo donde guardaremos los segundos de la hora
     */
    int segundo;

    //Declaramos el constructor sin parametros
    public Hora() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    //Declaramos el constructor con parametros
    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }


    //Declcaramos los getter y setter
    public int getHora() {
        return hora;
    }

    //Declaramos el setter de la hora para que solo se pueda introducir un valor entre 0 y 23
    public void setHora(int hora) {
        if (hora >= 0 || hora <= 23) {
            this.hora = hora;
        }
    }

    public int getMinuto() {
        return minuto;
    }

    //Declaramos el setter de los minutos para que solo se pueda introducir un valor entre 0 y 59
    public void setMinuto(int minuto) {
        if (minuto >= 0 || minuto <= 59) {
            this.minuto = minuto;
        }
    }

    public int getSegundo() {
        return segundo;
    }

    //Declaramos el setter de los segundos para que solo se pueda introducir un valor entre 0 y 59
    public void setSegundo(int segundo) {
        if (segundo >= 0 || segundo <= 59) {
            this.segundo = segundo;
        }
    }

    /**
     * Método que nos devuelve la hora en formato hh:mm:ss
     *
     * @return la hora en formato hh:mm:ss
     */
    @Override
    public String toString() {
        return "La hora actual es: " + hora + ":" + minuto + ":" + segundo;
    }

    /**
     * Método que incrementa la hora según cuantos
     *
     * @param segundos son introducidos por parámetro
     */
    public void incrementaSegundo(int segundos) {
        //Si los segundos del objeto hora son menores que 59, le sumamos los segundos introducidos por parámetro
        if (segundo <= 59) {
            segundo += segundos;
            //Si los segundos del objeto hora son mayores que 59
            if (segundo > 59) {
                //Incrementamos los minutos y le restamos 60 segundos al total de segundos
                do {
                    incrementaMinuto();
                    setSegundo(segundo - 60);
                } while (segundo > 59);

            }
        }

    }

    /**
     * Metodo que incrementa los minutos
     */
    public void incrementaMinuto() {
        //Si los minutos del objeto son menores que 59, le sumamos 1
        if (minuto <= 59) {
            minuto++;
            if (minuto > 59) {
                //Si los minutos del objeto son mayores que 59, incrementamos la hora y le restamos 60 minutos al total de minutos
                do {
                    incrementaHora();
                    setMinuto(minuto - 60);
                }while (minuto> 59);

            }
        }
    }

    /**
     * Método que incrementa los minutos
     */
    public void incrementaHora() {
        //Si la hora del objeto es menor que 23, le sumamos 1
        if (hora <= 23) {
            hora++;
            if (hora > 23) {
                //Si la hora del objeto es mayor que 23, indicamos que la hora es 0
                setHora(0);
            }
        }
    }


}
