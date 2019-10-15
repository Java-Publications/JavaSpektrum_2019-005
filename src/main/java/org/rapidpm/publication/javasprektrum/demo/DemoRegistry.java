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
    public  SubView      subView      = new SubView();
    private Registration registration = subView.register("keyXYZ", e -> inputValue = e.getValue());
    private String       inputValue;

    public String getInputValue() {
      return inputValue;
    }

    public void release() {
      registration.remove();
    }
  }

  public static class SubView {

    public void buttonClicked(String input) {
      EVENT_BUS.sentEvent(new Event(input));
    }

    public Registration register(String key, Consumer<Event> listener) {
      return EVENT_BUS.register(key, listener);
    }
  }
}
