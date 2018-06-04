package ru.aryukov.romanchick.sync;

import java.io.*;
import java.io.IOException;

public class Resource {
    private FileWriter fileWriter;

    public Resource(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public synchronized void writing(String str, int i){
        try {
            fileWriter.append(str + i);
            System.out.println(str + i);
            Thread.sleep((long) (Math.random() * 50));
            System.out.println("->" + i + " ");
        }catch (InterruptedException e){
            System.err.print("error thread: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
