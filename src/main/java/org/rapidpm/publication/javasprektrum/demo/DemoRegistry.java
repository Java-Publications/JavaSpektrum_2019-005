package org.rapidpm.publication.javasprektrum.demo;

import org.rapidpm.publication.javasprektrum.registration.Registration;
import org.rapidpm.publication.javasprektrum.registration.Registry;

import java.util.function.Consumer;

public class DemoRegistry {

  private DemoRegistry() {
  }

  public static final Registry<String, Event> EVENT_BUS = Registry.instance();

  public static class Event {
    private String value;

    public Event(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public static class MainView {
    //for demo public
    public SubView subView = new SubView();
    private String inputValue;
    private Registration registration = subView.register(event -> inputValue = event.getValue());

    public String getInputValue() {
      return inputValue;
    }

    public void release() {
      registration.remove();
    }
  }

  public static class SubView {
    private final String registrationKey = "ABC";

    public void buttonClicked(String input) {
      EVENT_BUS.sentEvent(new Event(input));
    }

    public Registration register(Consumer<Event> listener) {
      return EVENT_BUS.register(registrationKey, listener);
    }
  }
}
