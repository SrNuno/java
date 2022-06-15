
package bol3_ej2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bol3_ej2.clases.Main;

@DisplayName("Application")
public class ApplicationTest {
  static Main m;

  @BeforeAll
  static void cilindro(){
    m = new Main();
  }

  @Test
  @DisplayName("Pointless test")
  void testCilindro(){
    assertEquals(62.83185, m.calcSuperficie(2, 5), 0.00001);
  }
}
