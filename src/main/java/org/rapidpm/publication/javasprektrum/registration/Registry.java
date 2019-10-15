package org.rapidpm.publication.javasprektrum.registration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Registry<KEY, VALUE> {

  private final Map<KEY, Consumer<VALUE>> listeners = new ConcurrentHashMap<>();

  public static <K, V> Registry<K, V> instance() {
    return new Registry<>();
  }

  public Registration register(KEY key, Consumer<VALUE> listener) {
    listeners.put(key, listener);
    return () -> listeners.remove(key);
  }

  public void sentEvent(VALUE event) {
    listeners.values()
             .forEach(listener -> listener.accept(event));
  }

}
