package q17_overwrite;

import java.util.Random;

public class RandomConversation extends Conversation{
  private final String[] sentences = {
      "Man, this weather is nice.",
      "Have you ever been to Boston in the Fall?",
      "Hello",
      "No, I've never painted daisies on a big red rubber ball",
      "What's your name?",
  };

  @Override
  protected String talk() {
    Random random = new Random();
    return sentences[random.nextInt(sentences.length)];
  }

  public static void main(String[] args) {
    Conversation conversation = new RandomConversation();
    for (int i = 0; i < 10; i++) {
      System.out.println(conversation.talk());
    }
  }
}
