
package bol3_ej3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bol3_ej3.clases.Main;

@DisplayName("Application")
public class ApplicationTest {
  static Main menu;
  
  @BeforeAll
  static void testMenu(){
    menu = new Main();
  }

  @Test
  void testBisiesto(){
    assertFalse(menu.bisiesto(1800));
    assertTrue(menu.bisiesto(2000));
    assertTrue(menu.bisiesto(2004));
    assertFalse(menu.bisiesto(2006));
    assertFalse(menu.bisiesto(2021));
  }
}
