package matematicas;

public class App {/* 
    public static boolean esCapicua() {}*/

    /**
     * Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.
     * @param numero Es el número entero a comprobar.
     * @return Verdadero si es primo, falso en caso contrario.
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

    /*
    public static long voltea() {}
    public static int digitoN() {}
    public static int posicionDeDigito() {}
    public static long quitaPorDetras() {}
    public static long quitaPorDelante() {}*/

    /**
     * Añade un dígito a un número por detrás.
     * @param digito Digito a añadir.
     * @param numero Numero al que añadir el digito.
     * @return El número con el dígito detrás.
     */
    public static long pegaPorDetras(int digito, long numero) {
        return juntaNumeros(digito, numero);
    }

    /**
     * Añade un dígito a un número por detrás.
     * @param numero Numero al que añadir el digito.
     * @param digito Digito a añadir.
     * @return El número con el dígito delante.
     */
    public static long pegaPorDelante(long numero, int digito) {
        return juntaNumeros(numero, digito);
    }

    /*public static long trozoDeNumero() {}*/

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
        
    }
}