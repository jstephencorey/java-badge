package q17_overwrite;

import q15_virtual_method.CriticalConversation;

public class Conversation{
  private int sentenceIndex;
  private final String[] sentences = {
      "Hello",
      "What's your name?",
      "Very nice to meet you!",
      "Man, this weather is nice.",
      "Well, it was good talking with you",
      "Goodbye!",
  };

  protected String talk() {
    if (sentenceIndex >= sentences.length){
      sentenceIndex = 0; //This could be done slightly easier with a modulo, but this is a bit more intuitive
    }
    return sentences[sentenceIndex++];
  }
  public Conversation() {
    sentenceIndex = 0;
  }

  public static void main(String[] args) {
    Conversation conversation = new Conversation();
    for (int i = 0; i < 10; i++) {
      System.out.println(conversation.talk());
    }
  }
}
