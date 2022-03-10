package com.company;

public class Catalogue {
  private Item[] catalogue;

  public Catalogue(int size){
    this.catalogue = new Item[size];
  }

  public void addItem(Item item){     //Jeg burde nok bruge while-loop
    for(int i = 0; i< catalogue.length; i++)
    if(catalogue[i]==null){
      catalogue[i]=item;
      i = catalogue.length;
    }
  }

  public Item[] getFullList(){
    return catalogue;
  }

  public Item[] getAvailableItems(){
    int count = 0;
    for (Item item : catalogue) {
      if (item != null && item.isAvailable()) {     //Counts available items
        count++;
      }
    }
    Item[] availableItems = new Item[count]; //Creates array based on count
    count=0;
    for (Item item : catalogue) { //Adds available items to array
      if (item != null && item.isAvailable()) {
        if (availableItems[count] == null) {
          availableItems[count++] = item;
        }
      }
    }
    return availableItems;
  }

  public Item findItem(String description){
    for (Item item : catalogue) {
      if (item != null && description.equalsIgnoreCase(item.getDescription())) {
        return item;
      }
    }
    return null;
  }

  public void borrowItem(Item item){
    item.setAvailable(false);
  }

  public void returnItem(Item item){
    item.setAvailable(true);
  }
}
