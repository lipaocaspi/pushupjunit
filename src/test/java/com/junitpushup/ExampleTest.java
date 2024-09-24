package com.junitpushup;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    // 1.
    @Test
    public void testSumar() {
        int numberA = 5;
        int numberB = 10;
        int result = example.sumar(numberA, numberB);

        assertNotNull(result);
        assertEquals(15, result);
        assertInstanceOf(Integer.class, result);
    }

    // 2.
    @Test
    public void testCheckPositivo() {
        int number = 50;
        boolean result = example.checkPositivo(number);
        assertEquals(true, result);
    }

    @Test
    public void testExcepcionCheckPositivo() {
        int number = -50;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.checkPositivo(number));
        String actual = exception.getMessage();
        String expected = "El número no puede ser negativo";

        assertEquals(expected, actual);
    }

    // 3.
    @Test
    public void testContarLetrasA() {
        assertAll(
                () -> assertEquals(0, example.contarLetrasA("Pinzon")),
                () -> assertEquals(9, example.contarLetrasA("La araña atrapa al abejorro")));
    }

    // 4.
    @Test
    public void testContieneElemento() {
        List<String> list = Arrays.asList("Camilo", "Carlos", "Pedro", "Liliana", "Paola");
        assertAll(
                () -> assertEquals(true, example.contieneElemento(list, "Pedro")),
                () -> assertEquals(false, example.contieneElemento(list, "lipaocaspi")));
    }

    // 5.
    @Test
    public void testRevertirCadena() {
        assertAll(() -> assertEquals("ipsacoapil", example.revertirCadena("lipaocaspi")));
    }

    // 6.
    @Test
    public void testFactorial() {
        assertAll(
                () -> assertEquals(3628800, example.factorial(10)),
                () -> assertEquals(5040, example.factorial(7)));
    }

    @Test
    public void testExcepcionFactorial() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.factorial(-1));
        String actual = exception.getMessage();
        String expected = "Factorial no definido para números negativos";

        assertEquals(expected, actual);
    }

    // 7.
    @Test
    public void testEsPrimo() {
        assertAll(
                () -> assertEquals(true, example.esPrimo(7)),
                () -> assertEquals(true, example.esPrimo(13)),
                () -> assertEquals(false, example.esPrimo(9)));
    }

    // 8.
    @Test
    public void testMensajeConRetraso() throws InterruptedException {
        assertAll(
                () -> assertTimeout(Duration.ofMillis(5050), () -> example.mensajeConRetraso()),
                () -> assertEquals("Listo después de retraso", example.mensajeConRetraso()));
    }

    // 9.
    @Test
    public void testConvertirAString() {
        List<Integer> integers = Arrays.asList(6, 5, 4, 3, 2, 1);
        List<String> strings = Arrays.asList("6", "5", "4", "3", "2", "1");
        assertArrayEquals(strings.toArray(new String[strings.size()]),
                example.convertirAString(integers).toArray(new String[integers.size()]));
    }

    // 10.
    @Test
    public void testCalcularMedia() {
        List<Integer> integers = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        assertEquals(5.5, example.calcularMedia(integers));
    }

    // 11.
    @Test
    public void testConvertirListaAString() {
        List<String> strings = Arrays.asList("5","4","3","2","1");
        assertEquals("5,4,3,2,1", example.convertirListaAString(strings));
    }
}