package practica1_amc;

import Algoritmos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1_amc {

    public static void main(String[] args) {
        long inicio;
        LecturaEscritura l = new LecturaEscritura();
        String FicheroActual = " ";
        ArrayList<Punto> p;
        ArrayList<String> ListaFicheros;
        ArrayList<Punto> PuntoCoordenadas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Menus m = new Menus();

        boolean peorCaso = false;
        int opcionDyV, opcion2, opcion3, opcionPrincipal, OpciónVoraz;
        do {
            opcionPrincipal = m.menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    do {
                        opcionDyV = m.menuPrincipal1A(peorCaso, FicheroActual);
                        switch (opcionDyV) {
                            case 1:
                                ListaFicheros = LecturaEscritura.getNombreFicheros();
                                for (int i = 0; i < ListaFicheros.size(); i++) {
                                    System.out.println("\n" + ListaFicheros.get(i));
                                    System.out.println("-----------------\n");
                                    l.lectura("archivos/" + ListaFicheros.get(i));
                                }
                                break;
                            case 2:
                        try {
                                if (PuntoCoordenadas.isEmpty()) {
                                    throw new Exception();
                                }
                                System.out.println("Estrategia           Punto1             Punto2              distancia           tiempo(mseg)");
                                inicio = System.nanoTime();
                                Resultado r = AlgoritmoExhaustivo.BusquedaExhauxtiva(PuntoCoordenadas);
                                float tExha = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.println("Exhaustivo           " + r.getPunto1() + "      " + r.getPunto2() + "      " + r.getDistancia() + "      " + tExha);
                                inicio = System.nanoTime();
                                r = AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(PuntoCoordenadas);
                                float tPo = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.println("Exhaustivo Poda       " + r.getPunto1() + "      " + r.getPunto2() + "       " + r.getDistancia() + "     " + tPo);
                                inicio = System.nanoTime();
                                r = AlgoritmosDyV.DyV(PuntoCoordenadas);
                                float tDiyVi = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.println("Divide y Venceras     " + r.getPunto1() + "      " + r.getPunto2() + "      " + r.getDistancia() + "      " + tDiyVi);
                                inicio = System.nanoTime();
                                r = AlgoritmosDyV.DyVMejorado(PuntoCoordenadas);
                                float tMejorado = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.println("DyVMejorado          " + r.getPunto1() + "       " + r.getPunto2() + "       " + r.getDistancia() + "      " + tMejorado);
                            } catch (Exception e) {
                                System.out.println("ERROR: Carga un fichero");
                            }
                            break;
                            case 3:
                                do {
                                    opcion2 = m.menuEstrategias(peorCaso);
                                    inicio = 0;
                                    float tiem = 0;
                                    System.out.println("Talla   Tiempo (mseg)");
                                    for (int i = 1000; i <= 5000; i = i + 1000) {
                                        p = Punto.rellenarPuntos(i, peorCaso);
                                        tiem = 0;
                                        switch (opcion2) {
                                            case 1:
                                                for (int j = 0; j < 100; j++) {
                                                    inicio = System.nanoTime();
                                                    AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                                    tiem = System.nanoTime() - inicio;
                                                }
                                                break;
                                            case 2:
                                                // Lógica para la opción 2 (ExhaustivoPoda)
                                                for (int j = 0; j < 100; j++) {
                                                    inicio = System.nanoTime();
                                                    AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                                                    tiem = System.nanoTime() - inicio;
                                                }
                                                break;
                                            case 3:
                                                // Lógica para la opción 3 (DivideVenceras)
                                                for (int j = 0; j < 100; j++) {
                                                    inicio = System.nanoTime();
                                                    AlgoritmosDyV.DyV(p);
                                                    tiem = System.nanoTime() - inicio;
                                                }
                                                break;
                                            case 4:
                                                // Lógica para la opción 4 (DyV Mejorado)
                                                for (int j = 0; j < 100; j++) {
                                                    inicio = System.nanoTime();
                                                    AlgoritmosDyV.DyVMejorado(p);
                                                    tiem = System.nanoTime() - inicio;
                                                }
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opción no válida. Por favor, elige una opción válida.");
                                                break;
                                        }
                                        tiem = (float) tiem / 100000000;

                                        System.out.println(i + "     " + tiem);

                                    }
                                } while (opcion2 != 0);
                                break;
                            case 4:
                                inicio = 0;
                                float tiempo1 = 0;
                                float tiempo2 = 0;
                                System.out.println("Selecciona el primero: ");
                                int primero = m.menuEstrategias(peorCaso);
                                System.out.println("Selecciona el segundo: ");
                                int segundo = m.menuEstrategias(peorCaso);
                                System.out.println("Talla   Tiempo primero(mseg)    Tiempo segundo (mseg)");
                                for (int i = 1000; i <= 5000; i = i + 1000) {
                                    p = Punto.rellenarPuntos(i, peorCaso);
                                    tiempo1 = 0;
                                    tiempo2 = 0;
                                    switch (primero) {
                                        case 0:
                                            break;
                                        case 1:
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                                tiempo1 = System.nanoTime() - inicio;

                                            }
                                            break;
                                        case 2:
                                            // Lógica para la opción 2 (ExhaustivoPoda)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                                                tiempo1 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        case 3:
                                            // Lógica para la opción 3 (DivideVenceras)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmosDyV.DyV(p);
                                                tiempo1 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        case 4:
                                            // Lógica para la opción 4 (DyV Mejorado)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmosDyV.DyVMejorado(p);
                                                tiempo1 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción no válida. Introduce un número válido.");
                                            break;
                                    }

                                    switch (segundo) {
                                        case 0:
                                            break;
                                        case 1:

                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmoExhaustivo.BusquedaExhauxtiva(p);
                                                tiempo2 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        case 2:
                                            // Lógica para la opción 2 (ExhaustivoPoda)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(p);
                                                tiempo2 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        case 3:
                                            // Lógica para la opción 3 (DivideVenceras)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmosDyV.DyV(p);
                                                tiempo2 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        case 4:
                                            // Lógica para la opción 4 (DyV Mejorado)
                                            for (int j = 0; j < 100; j++) {
                                                inicio = System.nanoTime();
                                                AlgoritmosDyV.DyVMejorado(p);
                                                tiempo2 = System.nanoTime() - inicio;
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción no válida. Introduce un número válido.");
                                            break;
                                    }

                                    System.out.println(i + "    " + tiempo1 / 100000000 + "                  " + tiempo2 / 100000000);

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
                                    } else if (opcion3 > 0) {
                                        try {
                                            int i = opcion3 - 1;
                                            FicheroActual = ListaFicheros.get(i);
                                            PuntoCoordenadas = l.lectura("archivos/" + FicheroActual);
                                        } catch (Exception e) {
                                            //System.out.println("Error al cargar el archivo");
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

                    } while (opcionDyV != 0);
                    break;
                case 2:
                    do {
                        OpciónVoraz = m.menuPrincipal1B(FicheroActual);
                        switch (OpciónVoraz) {
                            case 1://cargar dataset
                                do {
                                    ListaFicheros = LecturaEscritura.getNombreFicheros();
                                    opcion3 = m.menuFicheros(ListaFicheros);
                                    if (opcion3 == -1) {
                                        System.out.println("Opción no válida. Por favor, elige una opción válida.1");
                                    } else {
                                        try {
                                            int i = opcion3 - 1;
                                            FicheroActual = ListaFicheros.get(i);
                                            PuntoCoordenadas = l.lectura("archivos/" + FicheroActual);
                                        } catch (Exception e) {
                                            System.out.println("Error al cargar el archivo");
                                        }
                                    }
                                } while (opcion3 != 0);
                                break;
                            case 2://comprobar estrategias
                                 try {
                                if (PuntoCoordenadas.isEmpty()) {
                                    throw new Exception();
                                }
                                System.out.println("Estrategia           Ruta                                                                                                  distancia                  tiempo(mseg)");
                                inicio = System.nanoTime();
                                Resultado r = AlgoritmosVoraces.Unidireccional(PuntoCoordenadas, FicheroActual);
                                float tuni = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.print("Unidireccional         ");

                                for (int i = 0; i < r.getRuta().size(); i++) {
                                    System.out.print("" + r.getRuta().get(i) + ",");
                                }
                                System.out.print("    " + r.getDistancia());
                                System.out.println("           " + tuni);

                                inicio = System.nanoTime();
                                r = AlgoritmosVoraces.Bidireccional(PuntoCoordenadas, FicheroActual);
                                float tbi = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.print("Bidireccional         ");

                                for (int i = 0; i < r.getRuta().size(); i++) {
                                    System.out.print("" + r.getRuta().get(i) + ",");
                                }
                                System.out.print("    " + r.getDistancia());
                                System.out.println("           " + tbi);

                            } catch (Exception e) {
                                System.out.println("ERROR: Carga un fichero");
                            }
                            break;
                            case 3://COMPARAR LAS ESTRATEGIAS
                                System.out.println("Comparar las estrategias voraz.");
                                System.out.println("         Unidireccional   Bidireccional");
                                System.out.println("Talla    Tiempo(mseg)     Tiempo(mseg)    ");

                                for (int i = 1000; i <= 5000; i += 1000) {
                                    float tUni = 0, tBi = 0;
                                    for (int j = 0; j < 100; j++) {

                                        p = Punto.rellenarPuntos(i, peorCaso);
                                        inicio = System.nanoTime();
                                        AlgoritmosVoraces.Unidireccional(p, "Test");
                                        tUni = System.nanoTime() - inicio;

                                        inicio = System.nanoTime();
                                        AlgoritmosVoraces.Bidireccional(p, "Test");
                                        tBi = System.nanoTime() - inicio;

                                    }
                                    tUni = (float) tUni / 100000000;
                                    tBi = (float) tBi / 100000000;

                                    System.out.println(i + "     " + tUni + "      " + tBi);
                                }
                                break;
                            case 4://CREAR FICHERO TSP ALEATORIO
                                System.out.println("Escriba el nombre del fichero: ");
                                String nombre = scanner.nextLine();
                                System.out.println("Escriba el numero de puntos: ");
                                int numero = scanner.nextInt();
                                //System.out.println("Escriba el caso que quiera PEOR: 0 /MEDIO: 1: ");
                                //int caso = scanner.nextInt();
                                LecturaEscritura.crearArchivoTSP(nombre, numero, peorCaso);
                                break;
                            case 5:
                                try {
                                if (PuntoCoordenadas.isEmpty()) {
                                    throw new Exception();
                                }
                                System.out.println("Estrategia           Ruta                                                                                                  distancia                  tiempo(mseg)");
                                inicio = System.nanoTime();
                                Resultado ver = AlgoritmoSolucionOptima.recorrerConPermutaciones(PuntoCoordenadas);
                                float top = (float) (System.nanoTime() - inicio) / 1000000;
                                System.out.print("Optimo         ");

                                for (int i = 0; i < ver.getRuta().size(); i++) {
                                    System.out.print("" + ver.getRuta().get(i) + ",");
                                }
                                System.out.print("    " + ver.getDistancia());
                                System.out.println("           " + top);
                            } catch (Exception e) {
                                System.out.println("ERROR: Carga un fichero");
                            }
                            break;
                            default:
                                System.out.println("Opción no válida. Por favor, elige una opción válida.");
                        }
                    } while (OpciónVoraz != 0);
            }

        } while (opcionPrincipal != 0);

    }

}
