package PetStore;

import Utility.ExcelUtiles;

import java.io.IOException;

public class DD_Stores {

   public static void main(String[] args) throws IOException {
       System.out.println(ExcelUtiles.getExcelDataAsListOfMap("StoreData", "Sheet1"));

   }
}
