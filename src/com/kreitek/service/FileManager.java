package com.kreitek.service;

import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileItem;import com.kreitek.interfaces.FilesSizeCalculator;
import com.kreitek.interfaces.FileSystemItem;

import java.util.List;

public class FileManager implements FilesSizeCalculator {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof FileItem) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof DirectoryItem) {
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
            if (item instanceof FileItem) {
                totalSize += item.getSize();
            } else if (item instanceof DirectoryItem) {
                DirectoryItem directory = (DirectoryItem) item;
                totalSize += calculateSize(directory.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
