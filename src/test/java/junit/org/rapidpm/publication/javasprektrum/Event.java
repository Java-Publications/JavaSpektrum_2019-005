package junit.org.rapidpm.publication.javasprektrum;

public class Event {
  private String message;
  private String details;

  public Event(String message, String details) {
    this.message = message;
    this.details = details;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }
}
