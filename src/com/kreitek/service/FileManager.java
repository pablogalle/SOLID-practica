package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.files.File;
import com.kreitek.interfaces.FileSizeCalculator;
import com.kreitek.interfaces.FileSystemItem;

import java.util.List;

public class FileManager implements FileSizeCalculator {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            DirectoryItem directory = (DirectoryItem) fileSystemItem;
            for (FileSystemItem item : directory.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    @Override
    public int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {
            if (item instanceof File) {
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                DirectoryItem directory = (DirectoryItem) item;
                totalSize += calculateSize(directory.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
