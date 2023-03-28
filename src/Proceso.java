
/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #8
 * 27/03/2023
 * Clase que almacena la informacion de los procesos
 */

public class Proceso implements Comparable<Proceso>{

    private String nomProceso;
    private String nomUs;
    private int valorN;
    private int valorPR;

    /**
     * Parametros de la clase
     * @param nomProceso almacena el nombre del proceso
     * @param nomUs almacena el nombre del usuario
     * @param valorN almacena el valor nice el proceso
     * @param valorPR almacena el valor de la prioridad
     */

    /**
     * Constructor de la clase e instanciador de un proceso
     */
    public Proceso(String nomProceso, String nomUs, int valorN) {
        this.nomProceso = nomProceso;
        this.nomUs = nomUs;
        this.valorN = valorN;
        this.valorPR = valorN + 120;
    
    }

    /**
     * @return String
     */
    public String getNomProceso() {
        return nomProceso;
    }

    /**
     * @param nomProceso
     */
    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    /**
     * @return String
     */
    public String getNomUs() {
        return nomUs;
    }

    /**
     * @param nomUs
     */
    public void setNomUs(String nomUs) {
        this.nomUs = nomUs;
    }

    /**
     * @return int
     */
    public int getValorN() {
        return valorN;
    }

    /**
     * @param valorN
     */
    public void setValorN(int valorN) {
        this.valorN = valorN;
    }

    /**
     * @return int
     */
    public int getValorPR() {
        return this.valorPR;
    }

    /**
     * @param valorPR
     */
    public void setValorPR(int valorPR) {
        this.valorPR = valorPR;
    }

    /**
     * @param other
     * @return int
     */
    @Override
    public int compareTo(Proceso other) {
        if (this.valorN < other.valorN) {
            return -1;
        } else if (this.valorN > other.valorN) {
            return 1;
        } else {
            return 0;
        }
    }
}