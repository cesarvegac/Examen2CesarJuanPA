import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.example.examen2.Calculadora;


public class ExampleUnitTest {

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
}
