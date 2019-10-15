package junit.org.rapidpm.publication.javasprektrum.observer;

import junit.org.rapidpm.publication.javasprektrum.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.publication.javasprektrum.observer.Observable;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObservableTest {

  @Test
  void test001() {
    final Observable<String, Event> eventBus = new Observable<>();
    final String                    expected = "message 001";

    final AtomicInteger counter = new AtomicInteger(0);
    final String        key01   = "Consumer-01";
    final String        key02   = "Consumer-02";


    eventBus.register(key01, (event) -> {
      assertEquals(expected, event.getMessage());
      counter.incrementAndGet();
    });
    eventBus.register(key02, (event) -> {
      assertEquals(expected, event.getMessage());
      counter.incrementAndGet();
    });

    eventBus.sentEvent(new Event(expected, ""));
    Assertions.assertEquals(2, counter.get());

    eventBus.unregister(key02);
    eventBus.sentEvent(new Event(expected, ""));
    Assertions.assertEquals(3, counter.get());

  }



}
