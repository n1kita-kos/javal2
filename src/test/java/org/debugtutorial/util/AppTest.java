package org.debugtutorial.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testCalculateCosine() {
        assertEquals(1.0, App.calculateCosine(0, 3), 1e-10, "Косинус 0 должен быть 1");
        assertEquals(0.0, App.calculateCosine(Math.PI / 2, 30), 1e-10, "Косинус PI/2 должен быть 0");
        assertEquals(-1.0, App.calculateCosine(Math.PI, 30), 1e-10, "Косинус PI должен быть -1");
        assertEquals(0.0, App.calculateCosine(3 * Math.PI / 2, 30), 1e-10, "Косинус 3PI/2 должен быть 0");
        assertEquals(1.0, App.calculateCosine(2 * Math.PI, 30), 1e-10, "Косинус 2PI должен быть 1");
        assertEquals(Math.cos(1), App.calculateCosine(1, 10), 1e-10, "Косинус 1 должен совпадать с Math.cos(1)");
    }
	@Test
    public void testCalculateCosine2() {
        assertEquals(1.0, App.calculateCosine2(0, "3"), 1e-10, "Косинус 0 должен быть 1");
        assertEquals(0.0, App.calculateCosine2(Math.PI / 2, "30"), 1e-10, "Косинус PI/2 должен быть 0");
        assertEquals(-1.0, App.calculateCosine2(Math.PI, "30"), 1e-10, "Косинус PI должен быть -1");
        assertEquals(0.0, App.calculateCosine2(3 * Math.PI / 2, "30"), 1e-10, "Косинус 3PI/2 должен быть 0");
        assertEquals(1.0, App.calculateCosine2(2 * Math.PI, "30"), 1e-10, "Косинус 2PI должен быть 1");
        assertEquals(Math.cos(1), App.calculateCosine2(1, "10"), 1e-10, "Косинус 1 должен совпадать с Math.cos(1)");
    }
}

