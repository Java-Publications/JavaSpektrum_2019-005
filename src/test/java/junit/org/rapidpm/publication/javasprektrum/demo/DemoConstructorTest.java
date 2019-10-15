package junit.org.rapidpm.publication.javasprektrum.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.publication.javasprektrum.demo.DemoConstructor;

public class DemoConstructorTest {

  @Test
  void test001() {
    final DemoConstructor.MainView mainView = new DemoConstructor.MainView();
    final DemoConstructor.SubView  subView  = new DemoConstructor.SubView(mainView);

    //user interaction
    final String input = "from InputField";
    subView.buttonClicked(input);

    Assertions.assertEquals(input, mainView.getInputValue());
  }
}
