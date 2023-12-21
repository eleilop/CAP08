package matematicas;

public class App {
    /**
     * Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en caso contrario.
     * @param numero Número a comprobar.
     * @return Verdadero = capicúa | Falso = NO capicúa.
     */
    public static boolean esCapicua(long numero) {
        if (numero==voltea(numero))
            return true;
        else
            return false;
    }

    /**
     * Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.
     * @param numero Es el número entero a comprobar.
     * @return Verdadero = primo | Falso = NO primo.
     */
    public static boolean esPrimo(long numero) {
        if (numero==0 || numero==1)
            return false;
        else {
            for (int i=2;i<numero;i++) {
                if (numero%i==0)
                    return false;
            }
        }
        return true;
    }

    /**
     * Devuelve el menor primo que es mayor al número que se pasa como parámetro.
     * @param numero Número desde el que comprobar.
     * @return Siguiente primo desde el número introducido.
     */
    public static long siguientePrimo(long numero) {
        numero = numero+1;
        while (true) {
            if (esPrimo(numero))
                return numero;
            else
                numero++;
        }
    }

    /**
     * Dada una base y un exponente devuelve la potencia.
     * @param base Es el número que se multiplica por sí mismo.
     * @param exponente Indica cuántas veces se debe multiplicar la base.
     * @return Es el resultado de multiplicar la base por sí misma tantas veces como indica el exponente.
     */
    public static long potencia(long base, long exponente) {
        long potencia = 1;
        if (exponente==0)
            return 1;
        else {
            for (int i=1;i<=exponente;i++)
                potencia = potencia*base;
            return potencia;
        }
    }

    /**
     * Cuenta el número de dígitos de un número entero.
     * @param numero Es el número entero a comprobar.
     * @return Dígitos del número introducido.
     */
    public static int digitos(long numero) {
        int digitos = 0;
        while (numero!=0) {
            numero = numero/10;
            digitos++;
        }
        return digitos;
    }

    /**
     * Le da la vuelta a un número.
     * @param numero Número al que darle la vuelta.
     * @return Número dado la vuelta.
     */
    public static long voltea(long numero) {
        long numAlReves = 0;
        while(true) {
            int digito = (int)(numero%10);
            numAlReves = numAlReves*10+digito;
            if (numero<10)
                break;
            else
                numero = numero/10;
        }
        return numAlReves;
    }

    /**
     * Devuelve el dígito que está en la posición n de un número entero. Se empieza contando por el 0 y de izquierda a derecha.
     * @param numero Número en el que buscar el dígito.
     * @param posicion Posición en la que buscar el dígito.
     * @return Dígito situado en la posición indicada.
     */
    public static int digitoN(long numero, int posicion) {
        numero = voltea(numero);
        int contador = 0;
        do {
            if (posicion==contador)
                return (int)(numero%10);
            else {
                numero = quitaPorDetras(numero, 1);
                contador++;
            }
        } while (true);
        
    }

    /**
     * Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se encuentra, devuelve -1.
     * @param numero Número en el que buscar el dígito.
     * @param digito Dígito a buscar en el número.
     * @return Posición de la primera ocurrencia del dígito (No está = -1).
     */
    public static int posicionDeDigito(long numero, int digito) {
        numero = voltea(numero);
        int posicion = 1;
        do {
            if (numero%10==digito)
                return posicion;
            else {
                numero = quitaPorDetras(numero, 1);
                posicion++;
            }
        } while (numero!=0);
        return -1;
    }

    /**
     * Le quita a un número n dígitos por detrás.
     * @param numero Número al que quitarle dígitos.
     * @param digitos Número de digitos a quitar.
     * @return Número recortado.
     */
    public static long quitaPorDetras(long numero, int digitos) {
        return numero/potencia(10, digitos);
    }

    /**
     * Le quita a un número n dígitos por delante.
     * @param numero Número al que quitarle dígitos.
     * @param digitos Número de digitos a quitar.
     * @return Número recortado.
     */
    public static long quitaPorDelante(long numero, int digitos) {
        return voltea(voltea(numero)/potencia(10, digitos));
    }

    /**
     * Añade un dígito a un número por detrás.
     * @param digito Digito a añadir.
     * @param numero Numero al que añadir el digito.
     * @return El número con el dígito detrás.
     */
    public static long pegaPorDetras(int digito, long numero) {
        return juntaNumeros(numero, digito);
    }

    /**
     * Añade un dígito a un número por detrás.
     * @param numero Numero al que añadir el digito.
     * @param digito Digito a añadir.
     * @return El número con el dígito delante.
     */
    public static long pegaPorDelante(long numero, int digito) {
        return juntaNumeros(digito, numero);
    }

    /**
     * Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo correspondiente.
     * @param numero Número a recortar.
     * @param inicio Posición de inicio para extraer el número.
     * @param fin Posición de fin para extraer el número.
     * @return Número recortado.
     */
    public static long trozoDeNumero(long numero, int inicio, int fin) {
        return quitaPorDetras(quitaPorDelante(numero, inicio), fin-inicio);
    }

    /**
     * Pega dos números para formar uno.
     * @param x Primer número.
     * @param y Segundo número.
     * @return Primer y segundo número juntos.
     */
    public static long juntaNumeros(long x, long y) {
        x = x*potencia(10, digitos(y));
        return x+y;
    } 
    public static void main(String[] args) throws Exception {
        boolean salir = false;

        while (!salir) {
            System.out.println("########## FUNCIONES MATEMÁTICAS ##########");
            System.out.println("1. Detector de capicúas");
            System.out.println("2. Detector de primos");
            System.out.println("3. Detector de siguiente primo");
            System.out.println("4. Calculadora de potencias");
            System.out.println("5. Calculadora de dígitos");
            System.out.println("6. Voltea números");
            System.out.println("7. Extraer dígito por posición");
            System.out.println("8. Calculadora de posición de dígitos");
            System.out.println("9. Quitar números por detrás");
            System.out.println("10. Quitar números por delante");
            System.out.println("11. Pegar números por detrás");
            System.out.println("12. Pegar números por delante");
            System.out.println("13. Extraer trozo de número");
            System.out.println("14. Juntar números");
            System.out.print("Introduce una opción: ");
            int opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d %s", numero, esCapicua(numero)==true?"es capicúa":"NO es capicúa");
                    break;
                }
                case 2:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d %s", numero, esPrimo(numero)==true?"es primo":"NO es primo");
                    break;
                }
                case 3:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.printf("El siguiente número primo a %d es %d", numero, siguientePrimo(numero));
                    break;
                }
                case 4:{
                    System.out.print("Introduce la base: ");
                    long base = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el exponente: ");
                    long exponente = Integer.parseInt(System.console().readLine());
                    System.out.printf("La potencia de base %d y exponente %d es %d", base, exponente, potencia(base, exponente));
                    break;
                }
                case 5:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d tiene %d dígitos", numero, digitos(numero));
                    break;
                }
                case 6:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d al revés es %d", numero, voltea(numero));
                    break;
                }
                case 7:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce la posición: ");
                    int posicion = Integer.parseInt(System.console().readLine());
                    System.out.printf("El dígito del número %d en la posición %d es %d", numero, posicion, digitoN(numero, posicion));
                    break;
                }
                case 8:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el dígito: ");
                    int digito = Integer.parseInt(System.console().readLine());
                    System.out.printf("La posición del dígito %d en el número %d es %d", digito, numero, posicionDeDigito(numero, digito));
                    break;
                }
                case 9:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el número de dígitos: ");
                    int digitos = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d sin %d dígitos por detrás es %d", numero, digitos, quitaPorDetras(numero, digitos));
                    break;
                }
                case 10:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el número de dígitos: ");
                    int digitos = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d sin %d dígitos por delante es %d", numero, digitos, quitaPorDelante(numero, digitos));
                    break;
                }
                case 11:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el dígito a añadir: ");
                    int digito = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d con %d por detrás es %d", numero, digito, pegaPorDetras(digito, numero));
                    break;
                }
                case 12:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el dígito a añadir: ");
                    int digito = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d con %d por delante es %d", numero, digito, pegaPorDelante(numero, digito));
                    break;
                }
                case 13:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce la posición inicial: ");
                    int inicio = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce la posición final: ");
                    int fin = Integer.parseInt(System.console().readLine());
                    System.out.printf("El número %d con las posiciones %d inicial y %d final es %d", numero, inicio, fin, trozoDeNumero(numero, inicio, fin));
                    break;
                }
                case 14:{
                    System.out.print("Introduce el número: ");
                    long numero = Integer.parseInt(System.console().readLine());
                    System.out.print("Introduce el otro número: ");
                    int numero2 = Integer.parseInt(System.console().readLine());
                    System.out.printf("El numero %d junto con el número %d es %d", numero, numero2, juntaNumeros(numero, numero2));
                    break;
                }
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            int opcion2 = 0;
            do {
                System.out.print("\n\n¿Quieres salir?\n1. Sí\n2. No\nIntroduce una opción: ");
                opcion2 = Integer.parseInt(System.console().readLine());
                switch (opcion2) {
                    case 1:
                        salir = true;
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion2!=1 && opcion2!=2);
        }
    }
}