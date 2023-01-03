package q12_encapsulation;

public class Rectangle {
  private int height;
  private int width;

  public Rectangle(int height, int width) throws BadParameterException {
    if (height <= 0 || width <= 0) {
      throw new BadParameterException();
    }
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) throws BadParameterException {
    if (height <= 0) {
      throw new BadParameterException();
    }
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) throws BadParameterException {
    if (width <= 0) {
      throw new BadParameterException();
    }
    this.width = width;
  }

  public int getArea() {
    return width * height;
  }

  public static void main(String[] args) throws BadParameterException {
    Rectangle rectangle = new Rectangle(12, 30);
    rectangle.setHeight(15);
    rectangle.getArea();
  }
}
