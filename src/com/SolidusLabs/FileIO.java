package com.SolidusLabs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    protected static List<GiftItem> readFile(String arg) {
        File file = new File(arg);
        List<GiftItem> menu= new LinkedList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String data[]=scanner.nextLine().split(", ");
                menu.add(new GiftItem(data[0],Integer.parseInt(data[1])));
            }
            scanner.close();

        }catch (FileNotFoundException e) {
            System.out.println("File Not found: " + arg);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menu;
    }
}
