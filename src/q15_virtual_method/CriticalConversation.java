package q15_virtual_method;

import java.util.Random;

public class CriticalConversation extends VirtualConversation{
  private final String[] sentences = {
    "Take a bath",
    "You're weird",
    "You have the fifth-ugliest nose I've ever seen",
    "Well, everyone's good for something, some as a good example, and some as a bad",
  };
  @Override
  protected String talk() {
    Random random = new Random();
    return sentences[random.nextInt(sentences.length)];
  }


  public static void main(String[] args) {
    VirtualConversation conversation = new CriticalConversation();
    System.out.println(conversation.talk());
  }
}
