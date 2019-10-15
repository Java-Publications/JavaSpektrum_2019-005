package junit.org.rapidpm.publication.javasprektrum.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.publication.javasprektrum.demo.DemoRegistry;

public class DemoRegistryTest {

  @Test
  void test001() {

    final DemoRegistry.MainView mainView = new DemoRegistry.MainView();
    final String                inputValue = "inputValue";
    mainView.subView.buttonClicked(inputValue);

    Assertions.assertEquals(inputValue, mainView.getInputValue());
  }
}
