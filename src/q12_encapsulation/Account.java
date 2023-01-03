package q12_encapsulation;

import java.util.Random;

public class Account {
  private long id;
  private String name;
  private long secretAccessKey;

  public Account(long id, String name) {
    this.id = id;
    this.name = name;
    Random random = new Random();
    this.secretAccessKey = random.nextInt();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getSecretAccessKey() {
    return secretAccessKey;
  }

  public void setSecretAccessKey(long secretAccessKey) {
    this.secretAccessKey = secretAccessKey;
  }

  public static void main(String[] args) {
     Account account = new Account(1234, "John Doe");
     account.setId(5678L);
     long secretAccessKey = account.getSecretAccessKey();
  }
}
