package junit.org.rapidpm.publication.javasprektrum.registration;

import junit.org.rapidpm.publication.javasprektrum.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.publication.javasprektrum.registration.Registration;
import org.rapidpm.publication.javasprektrum.registration.Registry;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {


  @Test
  void test001() {
    final Registry<String, Event> eventBus = Registry.instance();

    final String expected = "message 001";

    final AtomicInteger counter = new AtomicInteger(0);
    final String        key01   = "Consumer-01";
    final String        key02   = "Consumer-02";

    final Registration register01 = eventBus.register(key01, (event) -> {
      assertEquals(expected, event.getMessage());
      counter.incrementAndGet();
    });
    final Registration register02 = eventBus.register(key02, (event) -> {
      assertEquals(expected, event.getMessage());
      counter.incrementAndGet();
    });

    eventBus.sentEvent(new Event(expected, ""));
    Assertions.assertEquals(2, counter.get());

    register01.remove();
    eventBus.sentEvent(new Event(expected, ""));
    Assertions.assertEquals(3, counter.get());
  }
}
