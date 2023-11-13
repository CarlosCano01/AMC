package practica1_amc;

import java.util.ArrayList;
import java.util.Scanner;


public class Menus {

    private Scanner scanner = new Scanner(System.in);
    private int opcion;

    
    public int menuPrincipal() {
        System.out.println(" *** AMC. Practica 1. Curso 23/24 ****");
        System.out.println(" Alumnos: Carlos Cano Espinosa y Ignacio Velazquez Muñoz");
        System.out.println(" ***     MENU PRINCIPAL    ***");
        System.out.println(" 1.- MENU DYV y EXHAUSTIVO ");
        System.out.println(" 2.- MENU VORAZ");
        System.out.println(" 0.- Salir");
        System.out.println(" ---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }
    
    public int menuPrincipal1A(boolean peorCaso,String FicheroActual) {
        System.out.println(" *** AMC. Practica 1. Curso 23/24 ****");
        System.out.println(" Alumnos: Carlos Cano Espinosa y Ignacio Velazquez Muñoz");
        System.out.println(" ***     MENU PRINCIPAL DYV y EXHAUSTIVO   ***");
        System.out.println(" PEOR CASO: " + (peorCaso ? "ON" : "OFF")+(FicheroActual.isBlank() ? " " : "\t\tFichero actual: "+FicheroActual));
        System.out.println(" 1.- COMPROBAR TODOS LOS FICHEROS");//AÑADIDO
        System.out.println(" 2.- COMPROBAR ESTRATEGIAS");
        System.out.println(" 3.- ESTUDIAR 1 ESTRATEGIA");//AÑADIDO
        System.out.println(" 4.- COMPARAR 2 ESTRATEGIAS");
        System.out.println(" 5.- COMPARAR TODAS LAS ESTRATEGIAS");
        System.out.println(" 6.- ACTIVAR/DESACTIVAR PEOR CASO (TODOS LOS PUNTOS EN LA MISMA VERTICAL)");//AÑADIDO
        System.out.println(" 7.- CREAR FICHERO TSP ALEATORIO");
        System.out.println(" 8.- CARGAR UN DATASER EN MEMORIA");
        System.out.println(" 0.- Salir");
        System.out.println(" ---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }
    
    public int menuPrincipal1B(String FicheroActual) {
        System.out.println(" *** AMC. Practica 1. Curso 23/24 ****");
        System.out.println(" Alumnos: Carlos Cano Espinosa y Ignacio Velazquez Muñoz");
        System.out.println(" ***     MENU PRINCIPAL VORAZ ***");
        System.out.println((FicheroActual.isBlank() ? " " : "\t\tFichero actual: "+FicheroActual));
        System.out.println(" 1.- CARGAR UN DATASER EN MEMORIA");
        System.out.println(" 2.- COMPROBAR ESTRATEGIAS");
        System.out.println(" 3.- COMPARAR LAS ESTRATEGIAS ");
        System.out.println(" 4.- CREAR FICHERO TSP ALEATORIO");
        System.out.println(" 0.- Salir");
        System.out.println(" ---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }
    
    

    public int menuEstrategias(boolean peorCaso) {
        
        System.out.println("*** Estrategia a estudiar para el "+(peorCaso ? "caso peor ***" :"caso medio ***"));
        System.out.println("1.- Exhaustivo");
        System.out.println("2.- ExhaustivoPoda");
        System.out.println("3.- DivideVenceras");
        System.out.println("4.- DyV Mejorado");
        System.out.println("0.- Volver al menu anterior");
        System.out.println("---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }
    
    public int menuFicheros(ArrayList<String> ListaFicheros) {
        
        System.out.println("*** LISTA DE FICHEROS QUE TENEMOS ***\n");
        for (int i = 0; i < ListaFicheros.size(); i++) {
            System.out.println((i+1)+".- "+ListaFicheros.get(i));
        }
        System.out.println("0.- Volver al menu anterior");
        System.out.println("---------");
        System.out.print("Elige el fichero que deseas cargar: ");

        opcion = scanner.nextInt();
        if (opcion>ListaFicheros.size()) {
            opcion=-1;
        }
        return opcion;
    }
}
