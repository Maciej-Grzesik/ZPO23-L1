import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    @Test
    void testAdd() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(1, 2);
        ComplexNumber result = ComplexNumber.add(cn1, cn2);
        assertEquals(4, result.Re());
        assertEquals(6, result.Im());
    }
    @Test
    void testAddZero() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexNumber.add(cn1, cn2);
        assertEquals(3, result.Re());
        assertEquals(4, result.Im());
    }

    @Test
    void testSubtract() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(1, 2);
        ComplexNumber result = ComplexNumber.subtract(cn1, cn2);
        assertEquals(2, result.Re());
        assertEquals(2, result.Im());
    }
    @Test
    void testSubtractZero() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexNumber.subtract(cn1, cn2);
        assertEquals(3, result.Re());
        assertEquals(4, result.Im());
    }

    @Test
    void testMultiply() {
        ComplexNumber cn1 = new ComplexNumber(3, 2);
        ComplexNumber cn2 = new ComplexNumber(1, 4);
        ComplexNumber result = ComplexNumber.multiply(cn1, cn2);
        assertEquals(-5, result.Re());
        assertEquals(14, result.Im());
    }
    @Test
    void testMultiplyZero() {
        ComplexNumber cn1 = new ComplexNumber(3, 2);
        ComplexNumber cn2 = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexNumber.multiply(cn1, cn2);
        assertEquals(0, result.Re());
        assertEquals(0, result.Im());
    }

    @Test
    void testDivide() {
        ComplexNumber cn1 = new ComplexNumber(3, 2);
        ComplexNumber cn2 = new ComplexNumber(1, 4);
        ComplexNumber result = ComplexNumber.divide(cn1, cn2);
        assertEquals(0.647, result.Re(), 0.01);
        assertEquals(-0.588, result.Im(), 0.01);
    }

    @Test
    void testDivideZero() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(0, 0);
        assertThrows(ArithmeticException.class, () -> ComplexNumber.divide(cn1, cn2));
    }

    @Test
    void testPower() {
        ComplexNumber cn = new ComplexNumber(3, 2);
        ComplexNumber result = cn.power(3);
        assertEquals(-9, result.Re(), 0.01);
        assertEquals(46, result.Im(), 0.01);
    }

    @Test
    void testPowerZero() {
        ComplexNumber cn = new ComplexNumber(3, 4);
        ComplexNumber result = cn.power(0);
        assertEquals(1, result.Re());
        assertEquals(0, result.Im());
    }

    @Test
    void testPowerNegative() {
        ComplexNumber cn = new ComplexNumber(3, 2);
        ComplexNumber result = cn.power(-2);
        assertEquals(0.0295, result.Re(), 0.001);
        assertEquals(-0.0710, result.Im(), 0.001);
    }

    @Test
    void testEquals() {
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(3, 4);
        assertTrue(cn1.equals(cn2));
    }

    @Test
    void testEqualsFalse(){
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(1, 4);
        assertFalse(cn1.equals(cn2));
    }

    @Test
    void testToString() {
        ComplexNumber cn = new ComplexNumber(3, 4);
        assertEquals("3.0 + i4.0", cn.toString());
    }

    @Test
    void testInput() throws InvalidComplexNumberFormat {
        ByteArrayInputStream in = new ByteArrayInputStream("3-i5".getBytes());
        System.setIn(in);
        ComplexNumber result = ComplexNumber.Input();
        assertEquals(3, result.Re());
        assertEquals(-5, result.Im());
    }

    @Test
    void testInvalidComplexNumberFormat() {
        // Przygotowanie danych do zasymulowania nieprawidłowego formatu liczby zespolonej
        ByteArrayInputStream in = new ByteArrayInputStream("1++i1".getBytes());
        System.setIn(in);

        // Sprawdzenie, czy metoda rzuci oczekiwany wyjątek dla nieprawidłowego formatu
        assertThrows(InvalidComplexNumberFormat.class, ComplexNumber::Input);
    }
    // Dodaj testy dla metody Input() w przypadku poprawnego i niepoprawnego formatu liczby zespolonej
    @Test
    void testExp() {
        ComplexNumber cn = new ComplexNumber(3, 4);
        assertEquals(cn.exp(), "5.0e(0.9272952180016122i)");
    }

    @Test
    void testPolar() {
        ComplexNumber cn = new ComplexNumber(3, 4);
        assertEquals("z = (5.0,0.9272952180016122)", cn.polar());
    }

    @Test
    void testInputWithZeroImaginaryPart() throws InvalidComplexNumberFormat {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        ComplexNumber result = ComplexNumber.Input();
        assertEquals(3, result.Re());
        assertEquals(0, result.Im());
    }
}
