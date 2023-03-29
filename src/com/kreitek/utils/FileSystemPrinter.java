package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileSystemItem;
import com.kreitek.service.FilesManager;

public class FileSystemPrinter {

    private final FilesManager fileManager;

    public FileSystemPrinter() {
        this.fileManager = new FilesManager();
    }

    public static void print(FileSystemItem item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FilesManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof Directory) {
            DirectoryItem directory = (DirectoryItem) item;
            for (FileSystemItem subitem: directory.listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
