import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.example.examen2.Calculadora;

public class ExampleUnitTest {

    // Pruebas para el método convertirADestino
    @Test
    public void testConvertirADestino_Binario() {
        assertEquals("1010", Calculadora.convertirADestino(10, 0)); // 10 decimal a binario = 1010
        assertEquals("1111", Calculadora.convertirADestino(15, 0)); // 15 decimal a binario = 1111
    }

    @Test//121
    public void testConvertirADestino_Octal() {
        assertEquals("12", Calculadora.convertirADestino(10, 1)); // 10 decimal a octal = 12
        assertEquals("17", Calculadora.convertirADestino(15, 1)); // 15 decimal a octal = 17
    }

    @Test
    public void testConvertirADestino_Decimal() {
        assertEquals("10", Calculadora.convertirADestino(10, 2)); // 10 decimal a decimal = 10
        assertEquals("15", Calculadora.convertirADestino(15, 2)); // 15 decimal a decimal = 15
    }

    @Test
    public void testConvertirADestino_Hexadecimal() {
        assertEquals("a", Calculadora.convertirADestino(10, 3)); // 10 decimal a hexadecimal = a
        assertEquals("f", Calculadora.convertirADestino(15, 3)); // 15 decimal a hexadecimal = f
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertirADestino_BaseNoSoportada() {
        Calculadora.convertirADestino(10, 4); // Base no soportada
    }

    // Pruebas para el método realizarOperacion
    @Test
    public void testRealizarOperacion_Suma() {
        assertEquals(15, Calculadora.realizarOperacion(10, 5, "+")); // 10 + 5 = 15
    }

    @Test
    public void testRealizarOperacion_Resta() {
        assertEquals(5, Calculadora.realizarOperacion(10, 5, "-")); // 10 - 5 = 5
    }

    @Test
    public void testRealizarOperacion_Multiplicacion() {
        assertEquals(50, Calculadora.realizarOperacion(10, 5, "*")); // 10 * 5 = 50
    }

    @Test
    public void testRealizarOperacion_Division() {
        assertEquals(2, Calculadora.realizarOperacion(10, 5, "/")); // 10 / 5 = 2
    }

    @Test(expected = ArithmeticException.class)
    public void testRealizarOperacion_DivisionPorCero() {
        Calculadora.realizarOperacion(10, 0, "/"); // División por cero
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRealizarOperacion_OperadorNoSoportado() {
        Calculadora.realizarOperacion(10, 5, "%"); // Operador no soportado
    }

    // Pruebas para el método convertirNumero
    @Test
    public void testConvertirNumero_Binario() {
        assertEquals(5, Calculadora.convertirNumero("101", 0)); // 101 binario = 5 decimal
        assertEquals(10, Calculadora.convertirNumero("1010", 0)); // 1010 binario = 10 decimal
    }

    @Test
    public void testConvertirNumero_Octal() {
        assertEquals(8, Calculadora.convertirNumero("10", 1)); // 10 octal = 8 decimal
        assertEquals(64, Calculadora.convertirNumero("100", 1)); // 100 octal = 64 decimal
    }

    @Test
    public void testConvertirNumero_Decimal() {
        assertEquals(123, Calculadora.convertirNumero("123", 2)); // 123 decimal = 123 decimal
        assertEquals(0, Calculadora.convertirNumero("0", 2)); // 0 decimal = 0 decimal
    }

    @Test
    public void testConvertirNumero_Hexadecimal() {
        assertEquals(255, Calculadora.convertirNumero("FF", 3)); // FF hexadecimal = 255 decimal
        assertEquals(4096, Calculadora.convertirNumero("1000", 3)); // 1000 hexadecimal = 4096 decimal
    }

    @Test
    public void testConvertirNumero_BaseNoSoportada() {
        assertEquals(-1, Calculadora.convertirNumero("101", 4)); // Base no soportada
    }
//
    @Test
    public void testConvertirNumero_InputInvalido() {
        assertEquals(-1, Calculadora.convertirNumero("2AB", 0)); // Input no válido en binario
        assertEquals(-1, Calculadora.convertirNumero("89", 1)); // Input no válido en octal
        assertEquals(-1, Calculadora.convertirNumero("12.3", 2)); // Input no válido en decimal
        assertEquals(-1, Calculadora.convertirNumero("GHI", 3)); // Input no válido en hexadecimal
    }

    @Test
    public void testConvertirNumero_InputVacio() {
        assertEquals(-1, Calculadora.convertirNumero("", 2)); // Input vacío en decimal
    }

    @Test
    public void testConvertirNumero_InputNull() {
        assertEquals(-1, Calculadora.convertirNumero(null, 2)); // Input nulo en decimal
    }

    //Pruebas unitarias para el metodo buscar en lista

    @Test
    public void testEncuentra_ElementoPresente() {
        int[] lista = {1, 2, 3, 4, 5};
        assertEquals(true, Calculadora.Encuentra(lista, 3)); // El elemento 3 está en la lista
    }

    @Test
    public void testEncuentra_ElementoNoPresente() {
        int[] lista = {1, 2, 3, 4, 5};
        assertEquals(false, Calculadora.Encuentra(lista, 6)); // El elemento 6 no está en la lista
    }

    @Test
    public void testEncuentra_ListaVacia() {
        int[] lista = {};
        assertEquals(false, Calculadora.Encuentra(lista, 3)); // No hay elementos en la lista
    }

    @Test
    public void testEncuentra_ElementoPresenteAlInicio() {
        int[] lista = {3, 1, 2, 4, 5};
        assertEquals(true, Calculadora.Encuentra(lista, 3)); // El elemento 3 está al inicio de la lista
    }

    @Test
    public void testEncuentra_ElementoPresenteAlFinal() {
        int[] lista = {1, 2, 4, 5, 3};
        assertEquals(true, Calculadora.Encuentra(lista, 3)); // El elemento 3 está al final de la lista
    }

    @Test
    public void testEncuentra_ElementoDuplicado() {
        int[] lista = {1, 2, 3, 3, 5};
        assertEquals(true, Calculadora.Encuentra(lista, 3)); // El elemento 3 aparece varias veces en la lista
    }

    @Test
    public void testEncuentra_ElementoUnico() {
        int[] lista = {3};
        assertEquals(true, Calculadora.Encuentra(lista, 3)); // La lista contiene solo el elemento 3
    }

    @Test
    public void testEncuentra_ElementoNoPresenteUnico() {
        int[] lista = {1};
        assertEquals(false, Calculadora.Encuentra(lista, 3)); // La lista contiene solo un elemento diferente
    }
}
