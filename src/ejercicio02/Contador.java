package ejercicio02;

/**
 * Clase que crea un objeto Contador con el atributo cont.
 */
public class Contador {

    //Declaramos los atributos

    /**
     * Atributo contador
     */
    private int cont;

    //Constructor por defecto
    public Contador() {
    }

    //Constructor con parámetros
    public Contador(int cont) {
        if (cont<0) {
            this.cont = 0;
        }else{
            this.cont = cont;
        }
    }

    //Constructor copia
    public Contador(Contador objContador){
        this.cont = objContador.getCont();
    }

    //Métodos getter y setter
    public int getCont() {
        return cont;
    }
    public void setCont(int cont) {
        this.cont = cont;
    }

    /**
     * Método que incrementa el contador en una unidad
     */
    public void incrementar(){
        this.cont++;
    }

    /**
     * Método que decrementa el contador en una unidad
     */
    public void decrementar(){
        if (cont>0){
            this.cont--;
        }else {
            setCont(0);
        }
    }

    /**
     * Método que imprime por pantalla el objeto
     * @return
     */
    @Override
    public String toString() {
        return "" + cont;
    }
}
