package practica1_amc;

import Algoritmos.AlgoritmoExhaustivo;
import Algoritmos.AlgoritmosDyV;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1_amc {

    public static void main(String[] args) {
        long inicio;
        AlgoritmoExhaustivo AExhauxtivo = new AlgoritmoExhaustivo();
        LecturaEscritura l = new LecturaEscritura();
        String FicheroActual = " ";
        ArrayList<Punto> p;
        ArrayList<String> ListaFicheros;
        ArrayList<Punto> PuntoCoordenadas=new ArrayList<>();
        System.out.println("MEDIO CASO");

        System.out.println("----------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        Menus m = new Menus();

        boolean peorCaso = false;
        int opcion, opcion2, opcion3;
        do {
            opcion = m.menuPrincipal(peorCaso, FicheroActual);
            switch (opcion) {
                case 1:
                    ListaFicheros = LecturaEscritura.getNombreFicheros();
                    for (int i = 0; i < ListaFicheros.size(); i++) {
                        System.out.println("\n" + ListaFicheros.get(i));
                        System.out.println("-----------------\n");
                        l.lectura("archivos/" + ListaFicheros.get(i));
                    }
                    break;
                case 2:
                    try{
                        if(PuntoCoordenadas.size()==0){
                            throw new Exception();
                        }
                        System.out.println("Estrategia           Punto1             Punto2              distancia           tiempo(mseg)");
                        inicio = System.nanoTime();
                        Resultado r=AlgoritmoExhaustivo.BusquedaExhauxtiva(PuntoCoordenadas);
                        float tExha =(float) (System.nanoTime() - inicio)/1000000;
                        System.out.println("Exhaustivo           "+r.getPunto1()+"      "+r.getPunto2()+"   "+r.getDistancia()+"      "+tExha);
                        inicio = System.nanoTime();
                        r=AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(PuntoCoordenadas);
                        float tPo =(float) (System.nanoTime() - inicio)/1000000;
                        System.out.println("Exhaustivo Poda       "+r.getPunto1()+"      "+r.getPunto2()+"   "+r.getDistancia()+"    "+tPo);
                        inicio = System.nanoTime();
                        r=AlgoritmosDyV.DyV(PuntoCoordenadas);
                        float tDiyVi =(float) (System.nanoTime() - inicio)/1000000;
                        System.out.println("Divide y Venceras       "+r.getPunto1()+"      "+r.getPunto2()+"   "+r.getDistancia()+"       "+tDiyVi);
                        inicio = System.nanoTime();
                        r=AlgoritmosDyV.DyVMejorado(PuntoCoordenadas);
                        float tMejorado =(float) (System.nanoTime() - inicio)/1000000;
                        System.out.println("Divide y Venceras   Mejorado       "+r.getPunto1()+"      "+r.getPunto2()+"   "+r.getDistancia()+"     "+tMejorado);
                    }catch(Exception e){
                        System.out.println("ERROR: Carga un fichero");
                    }
                    break;
                case 3:
                    do {
                        opcion2 = m.menuEstrategias(peorCaso);
                        switch (opcion2) {
                            case 1:
                                // Lógica para la opción 1 (Exhaustivo)
                                System.out.println("Has seleccionado la opción 1 (Exhaustivo).");
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(PuntoCoordenadas);
                                break;
                            case 2:
                                // Lógica para la opción 2 (ExhaustivoPoda)
                                System.out.println("Has seleccionado la opción 2 (ExhaustivoPoda).");
                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(PuntoCoordenadas);
                                break;
                            case 3:
                                // Lógica para la opción 3 (DivideVenceras)
                                System.out.println("Has seleccionado la opción 3 (DivideVenceras).");
                                AlgoritmosDyV.DyV(PuntoCoordenadas);
                                break;
                            case 4:
                                // Lógica para la opción 4 (DyV Mejorado)
                                System.out.println("Has seleccionado la opción 4 (DyV Mejorado).");
                                AlgoritmosDyV.DyVMejorado(PuntoCoordenadas);
                                break;
                            case 0:
                                System.out.println("Volviendo al menu anterior.");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, elige una opción válida.");
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 4:
                    inicio = 0;
                    long tiempo1 = 0;
                    long tiempo2 = 0;
                    System.out.println("Selecciona el primero: ");
                    int primero = m.menuEstrategias(peorCaso);
                    System.out.println("Selecciona el segundo: ");
                    int segundo = m.menuEstrategias(peorCaso);
                    for (int i = 100; i <= 700; i = i + 100) {
                        p = Punto.rellenarPuntos(i, peorCaso);
                        switch (primero) {
                            case 0:
                                break;
                            case 1:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.print(" PRIMERA: Exhauxtiva ");
                                break;
                            case 2:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.print(" PRIMERA: Poda ");
                                break;
                            case 3:
                                inicio = System.nanoTime();
                                AlgoritmosDyV.DyV(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.print(" PRIMERA: DyV ");
                                break;
                            case 4:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.print(" PRIMERA: DyV mejorado ");
                                break;
                            default:
                                System.out.println("Opción no válida. Introduce un número válido.");
                                break;
                        }

                        switch (segundo) {
                            case 0:
                                break;
                            case 1:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.println(" SEGUNDO: Exhauxtiva ");
                                break;
                            case 2:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.println(" SEGUNDA: Poda ");
                                break;
                            case 3:
                                inicio = System.nanoTime();
                                AlgoritmosDyV.DyV(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.println(" SEGUNDA: DyV ");
                                break;
                            case 4:
                                inicio = System.nanoTime();
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                tiempo1 = System.nanoTime();
                                tiempo1 = tiempo1 - inicio;
                                System.out.println(" SEGUNDA: DyV mejorado ");
                                break;
                            default:
                                System.out.println("Opción no válida. Introduce un número válido.");
                                break;
                        }
                        System.out.println("Talla   Tiempo primero(mseg)    Tiempo segundo (mseg)");
                        System.out.println(i + "    " + tiempo1 + "         " + tiempo2);

                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado la opción 5.");
                    System.out.println("Comparar todas las estrategias.");
                    System.out.println("         Exhaustivo   ExhaustivoPoda  DivideVenceras   DyV Mejorado");
                    System.out.println("Talla   Tiempo(mseg)   Tiempo(mseg)    Tiempo(mseg)     Tiempo(mseg)");

                    for (int i = 1000; i <= 5000; i += 1000) {
                        float tEx = 0, tPoda = 0, tDyV = 0, tMejora = 0;
                        for (int j = 0; j < 100; j++) {

                            p = Punto.rellenarPuntos(i, peorCaso);

                            inicio = System.nanoTime();
                            AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                            tEx = System.nanoTime() - inicio;

                            inicio = System.nanoTime();
                            AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                            tPoda = System.nanoTime() - inicio;

                            inicio = System.nanoTime();
                            AlgoritmosDyV.DyV(p);
                            tDyV = System.nanoTime() - inicio;

                            inicio = System.nanoTime();
                            AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                            tMejora = System.nanoTime() - inicio;
                        }
                        tEx = (float) tEx / 100000000;
                        tPoda = (float) tPoda / 100000000;
                        tDyV = (float) tDyV / 100000000;
                        tMejora = (float) tMejora / 100000000;
                        System.out.println(i + "     " + tEx + "      " + tPoda + "        " + tDyV + "         " + tMejora);
                    }
                    break;
                case 6:
                    if (peorCaso == true) {
                        peorCaso = false;
                    } else {
                        peorCaso = true;
                    }
                    break;
                case 7:
                    System.out.println("Escriba el nombre del fichero: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Escriba el numero de puntos: ");
                    int numero = scanner.nextInt();
                    //System.out.println("Escriba el caso que quiera PEOR: 0 /MEDIO: 1: ");
                    //int caso = scanner.nextInt();
                    LecturaEscritura.crearArchivoTSP(nombre, numero, peorCaso);
                    break;
                case 8:
                    System.out.println("Has seleccionado la opción 8.");
                    do {
                        ListaFicheros = LecturaEscritura.getNombreFicheros();
                        opcion3 = m.menuFicheros(ListaFicheros);
                        if (opcion3 == -1) {
                            System.out.println("Opción no válida. Por favor, elige una opción válida.1");
                        } else {
                            try {
                                int i=opcion3 - 1; 
                                FicheroActual = ListaFicheros.get(i);
                                PuntoCoordenadas = l.lectura("archivos/" + FicheroActual);
                            } catch (Exception e) {
                               System.out.println("Error al cargar el archivo");
                            }
                        }
                    } while (opcion3 != 0);

                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }

        } while (opcion!= 0);

    }

}
