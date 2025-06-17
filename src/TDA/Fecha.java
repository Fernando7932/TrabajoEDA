package TDA;

import java.util.Scanner;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        dia = 1;
        mes = 1;
        anio = 1900;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    /*
    Leer datos del teclado
     */
    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el Dia: ");
        dia = sc.nextInt();
        System.out.print("Ingrese el Mes: ");
        mes = sc.nextInt();
        System.out.print("Ingrese el Año: ");
        anio = sc.nextInt();
    }
}
