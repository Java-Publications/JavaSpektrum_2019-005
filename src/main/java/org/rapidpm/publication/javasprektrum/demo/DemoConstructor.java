package org.rapidpm.publication.javasprektrum.demo;

public class DemoConstructor {

  public static class MainView {
    private String inputValue;

    public String getInputValue() {
      return inputValue;
    }

    public void setInputValue(String input) {
      this.inputValue = input;
    }
  }

  public static class SubView {

    private MainView mainView;

    public SubView(MainView mainView) {
      this.mainView = mainView;
    }

    public void buttonClicked(String input) {
      mainView.setInputValue(input);
    }
  }


}
