package com.company;

import java.util.Scanner;

public class TestSharedRessources {

  public static void main(String[] args) {
    //Katalog størrelse
    Catalogue catalogue = new Catalogue(10);

    //Create items and add to catalogue
    Item item1 = new Item("Sport", "Skateboard");
    catalogue.addItem(item1);
    Item item2 = new Item("Sport", "Mountainbike");
    catalogue.addItem(item2);
    Item item3 = new Item("Tøj", "Smoking");
    catalogue.addItem(item3);
    Item item4 = new Item("Tøj", "Pailletkjole");
    catalogue.addItem(item4);


    // Read user choice
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    while (choice != 6) {
      System.out.println();
      System.out.println("Hvad kunne du tænke dig?");
      System.out.println("1. Se hele kataloget");
      System.out.println("2. Se hvad der er ledigt");
      System.out.println("3. Opret ting til udlån");
      System.out.println("4. Lån ting");
      System.out.println("5. Aflever ting");
      System.out.println("6. Afslut program");
      System.out.println("Vælg en handling. (1-6)");
      choice = sc.nextInt();
      // Decide what to do based on user choice
      if (choice == 1) { // get all items in catalogue
        Item[] allItems = catalogue.getFullList();
        for (int i = 0; i < allItems.length; i++) {
          if (allItems[i] == null) {
          } else {
            System.out.println(allItems[i]);
          }
        }
      } else if (choice == 2) { // get available items in catalogue
        Item[] availableItems = catalogue.getAvailableItems();
        for (int i = 0; i < availableItems.length; i++) {
          System.out.println(availableItems[i]);
        }
      } else if (choice == 3) { // Add new Item to catalogue
        System.out.println("Indtast kategori");
        String kategori = sc.next();
        System.out.println("Indtast beskrivelse");
        String beskrivelse = sc.next();
        catalogue.addItem(new Item(kategori, beskrivelse));
        System.out.println("Vare tilføjet");

      } else if (choice == 4) { // make item unavailable
        System.out.println("Indtast beskrivelse af objekt til lån");
        String beskrivelseTilLån = sc.next();
        Item found = catalogue.findItem(beskrivelseTilLån);
        if (found != null && found.isAvailable()) {   // Kunne opdeles i to og give anden besked.
          catalogue.borrowItem(found);
          System.out.println("Lån registreret");
        } else {
          System.out.println("Beskrivelsen matcher ikke noget, der kan lånes "); // Kunne bruge loop
        }
      } else if (choice == 5) { // make item available again
        System.out.println("Indtast beskrivelse af objekt til retur");
        String beskrivelseTilRetur = sc.next();
        Item found = catalogue.findItem(beskrivelseTilRetur);
        if (found != null && !found.isAvailable()) {   // Kunne opdeles i to og give anden besked.
          catalogue.returnItem(found);
          System.out.println("Retur registreret");}   //
        else {
          System.out.println("Beskrivelsen matcher ikke noget returbart");  //Kunne bruge loop
        }
      } else if (choice != 6) { // invalid choice
        System.out.println("Du foretog et ugyldigt valg. Vælg en handling (1-6).");
      }
    }
    System.out.println("Du afsluttede programmet");
  }
}