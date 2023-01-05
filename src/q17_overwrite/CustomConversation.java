package q17_overwrite;

public class CustomConversation extends Conversation{
  private int sentenceIndex;
  private final String[] sentences;

  public CustomConversation(String[] sentences) {
    this.sentences = sentences;
    sentenceIndex = 0;
  }

  protected String talk() {
    if (sentenceIndex >= sentences.length){
      sentenceIndex = 0; //This could be done slightly easier with a modulo, but this is a bit more intuitive
    }
    return sentences[sentenceIndex++];
  }

  public static void main(String[] args) {
    Conversation conversation = new CustomConversation(new String[]{"Hello", "My name is Inigo Montoya", "You killed my father", "Prepare to die!"});
    for (int i = 0; i < 10; i++) {
      System.out.println(conversation.talk());
    }
  }
}

