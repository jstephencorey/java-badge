package q15_virtual_method;
import java.util.Random;

public class PositiveConversation extends VirtualConversation{
  private final String[] sentences = {
      "You're so cool",
      "I like being around you",
      "You're a good person",
      "You uplift me",
  };
  @Override
  protected String talk() {
    Random random = new Random();
    return sentences[random.nextInt(sentences.length)];
  }


  public static void main(String[] args) {
    VirtualConversation conversation = new PositiveConversation();
    System.out.println(conversation.talk());
  }
}