package org.rapidpm.publication.javasprektrum.observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Observable<KEY, VALUE> {

  private final Map<KEY, Consumer<VALUE>> listeners = new ConcurrentHashMap<>();

  public void register(KEY key, Consumer<VALUE> listener) {
    listeners.put(key, listener);
  }

  public void unregister(KEY key) {
    listeners.remove(key);
  }

  public void sentEvent(VALUE event) {
    listeners.values()
             .forEach(listener -> listener.accept(event));
  }

}
