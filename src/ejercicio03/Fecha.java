package ejercicio03;

/**
 * Clase que crea un objeto Fecha con los atributos dia, mes y año.
 */
public class Fecha {

    //Declaramos los atributos
    /**
     * Atributo donde guardaremos el dia del objeto fecha
     */
    private int dia;
    /**
     * Atributo donde guardaremos el mes del objeto fecha
     */
    private int mes;
    /**
     * Atributo donde guardaremos el año del objeto fecha
     */
    private int anyo;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    //Declaramos los getter y setter
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
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
    public boolean esBisiesto(int year) {
        boolean esBisiesto = false;

        //Si el año es divisible entre 4 y no es divisible entre 100 o es divisible entre 400, es bisiesto.
        if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
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


        if (dia >= 1 && dia <= 31) {    //Si el dia es mayor que 0 y menor que 31
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8    //Y si el mes es 1, 3, 5, 7, 8, 10 o 12
                    || mes == 10 || mes == 12) {
                fechaCorrecta = true;            //La fecha es correcta
            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {   //Si el mes es 4, 6, 9 o 11
                if (dia <= 30) {            //Y el dia es menor que 30
                    fechaCorrecta = true;   //La fecha es correcta
                }
            } else if (mes == 2) {          //Si el mes es 2
                if (dia <= 28) {            //Y el dia es menor que 28
                    fechaCorrecta = true;   //La fecha es correcta
                } else if (dia == 29 && esBisiesto(this.anyo)) {    //Si el dia es 29 y el año es bisiesto
                    fechaCorrecta = true;                           //La fecha es correcta
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
     *
     * @param fecha : Objeto Fecha que vamos a crear.
     */
    public void diaSiguiente(Fecha fecha) {
        if (fecha.fechaCorrecta()) {
            if (this.dia == 31 && this.mes == 12) {
                setDia(1);
                setMes(1);
                this.anyo++;
            } else if (this.dia == 31 && (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8
                    || this.mes == 10 || this.mes == 12)) {
                setDia(1);
                this.mes++;
            } else if (this.dia == 30 && (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11)) {
                setDia(1);
                this.mes++;
            } else if (this.dia == 28 && this.mes == 2 && !esBisiesto(this.anyo)) {
                setDia(1);
                this.mes++;
            } else if (this.dia == 29 && this.mes == 2 && esBisiesto(this.anyo)) {
                setDia(1);
                this.mes++;
            } else {
                this.dia++;
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

        String fecha = dia + "-" + mes + "-" + anyo;

        //Si el día o el mes son menores que 10, añadimos un 0 delante.
        if (dia < 10 && mes < 10) {
            fecha = "0" + dia + "-0" + mes + "-" + anyo;
        }else if (dia < 10) {   //Si solo el día es menor que 10, añadimos un 0 solo delante del día.
            fecha = "0" + dia + "-" + mes + "-" + anyo;
        }else if (mes < 10) {   //Si solo el mes es menor que 10, añadimos un 0 solo delante del mes.
            fecha = dia + "-0" + mes + "-" + anyo;
        }

        return fecha;
    }
}
