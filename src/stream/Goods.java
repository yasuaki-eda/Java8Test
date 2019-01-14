package stream;

public class Goods {

  private int typeId;
  private String name;
  private long value;
  private int id;

  public Goods(int id, int typeId, String name, int value) {
    this.id = id;
    this.typeId = typeId;
    this.name = name;
    this.value = value;
  }

  public int getTypeId() {
    return typeId;
  }
  public void setTypeId(int typeId) {
    this.typeId = typeId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public long getValue() {
    return value;
  }
  public void setValue(long value) {
    this.value = value;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

}
