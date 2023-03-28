package com.kreitek.utils;

import com.kreitek.files.*;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileItem;
import com.kreitek.interfaces.FileSizeCalculator;
import com.kreitek.interfaces.FileSystemItem;

public class FileSystemBuilder {

    private final DirectoryItem root;
    private DirectoryItem currentDirectory;
    private FileSizeCalculator fileSizeCalculator;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "", fileSizeCalculator);
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileItem file = new File(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        DirectoryItem directory = new Directory(currentDirectory, name, fileSizeCalculator);
        currentDirectory.addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = (DirectoryItem) currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
