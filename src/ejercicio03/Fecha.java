package ejercicio03;

/**
 * Clase que crea un objeto Fecha con los atributos dia, mes y año.
 */
public class Fecha {

    //Declaramos los atributos
    /**
     * Atributo donde guardaremos el dia del objeto fecha
     */
    private int dia = 1;
    /**
     * Atributo donde guardaremos el mes del objeto fecha
     */
    private int mes = 1;
    /**
     * Atributo donde guardaremos el año del objeto fecha
     */
    private int anyo = 1970;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int anyo) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        }
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }

        this.anyo = anyo;
    }

    //Declaramos los getter y setter
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     * Método que indicará si el año del objeto Fecha es bisiesto o no
     *
     * @return true si el año es bisiesto y false si no lo es.
     */
    public boolean esBisiesto() {
        boolean esBisiesto = false;

        //Si el año es divisible entre 4 y no es divisible entre 100 o es divisible entre 400, es bisiesto.
        if ((this.anyo % 4 == 0) && (this.anyo % 100 != 0 || this.anyo % 400 == 0)) {
            esBisiesto = true;
        }

        return esBisiesto;
    }

    /**
     * Método que comprobará si la fecha introducida por parámetros es correcta.
     *
     * @return true si la fecha es correcta y false si no lo es.
     */
    public boolean fechaCorrecta() {
        boolean fechaCorrecta = false;

        switch (mes) {
            case 2 -> {                     //Si el mes es 2
                //Si el año es bisiesto y el dia es menor que 29 o si el año no es bisiesto y el dia es menor que 28
                if ((esBisiesto() && dia <= 29) || (!esBisiesto() && dia <= 28)) {
                    fechaCorrecta = true;   //La fecha es correcta
                }
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {
                fechaCorrecta = true;       //Si el mes es 1, 3, 5, 7, 8, 10 o 12 la fecha es correcta
            }
            case 4, 6, 9, 11 -> {
                if (dia <= 30) {            //Si el mes es 4, 6, 9 o 11 y el dia es menor que 30
                    fechaCorrecta = true;   //La fecha es correcta
                }
            }
        }

        //Devuelve true si la fecha es correcta y false si no lo es.
        return fechaCorrecta;
    }

    /**
     * Precondición: la fecha introducida por parámetros debe ser correcta.
     * Método que cambiará la fecha introducida por parámetros para que muestre la del día siguiente.
     * Postcondición: la fecha que devuelva el método también debe ser correcta, es decir, debe existir.
     */
    public void diaSiguiente() {
        dia++;
        switch (mes) {
            case 2 -> {                     //Si el mes es 2
                //Si el año es bisiesto y el dia es menor que 29 o si el año no es bisiesto y el dia es menor que 28
                if ((esBisiesto() && dia > 29) || (!esBisiesto() && dia > 28)) {
                    dia = 1;
                    mes++;
                }
            }
            case 1, 3, 5, 7, 8, 10 -> {
                if (dia > 31) {             //Si el mes es 1, 3, 5, 7, 8 o 10 y el dia es mayor que 31
                    dia = 1;
                    mes++;
                }
            }
            case 4, 6, 9, 11 -> {
                if (dia > 30) {            //Si el mes es 4, 6, 9 o 11 y el dia es menor que 30
                    dia = 1;
                    mes++;
                }
            }
            case 12 -> {
                if (dia > 31) {
                    dia = 1;
                    mes = 1;
                    anyo++;
                }
            }
        }
    }

    /**
     * Método que mostrará la fecha en formato dd-mm-aaaa
     *
     * @return fecha en formato dd-mm-aaaa
     */
    @Override
    public String toString() {

        String fecha = "";
        if (dia < 10) {
            fecha += "0";
        }

        fecha += dia + "-";

        if (mes < 10) {
            fecha += "0";
        }

        fecha += mes + "-" + anyo;

        return fecha;
    }
}
