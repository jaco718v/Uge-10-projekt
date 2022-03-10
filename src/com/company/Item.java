package com.company;

public class Item {
  private String category;
  private String description;
  private boolean available;

  public Item(String category,String description){
    this.category=category;
    this.description=description;
    this.available=true;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String getDescription() {
    return description;
  }

  public boolean isAvailable() {
    return available;
  }

  @Override
  public String toString(){
    return category+", "+description;
  }
}
