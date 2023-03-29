package com.kreitek.utils;

import com.kreitek.files.*;
import com.kreitek.interfaces.*;

public class FileSystemBuilder {

    private final DirectoryItem root;
    private DirectoryItem currentDirectory;
    private FilesSizeCalculator filesSizeCalculator;
    private FileConverter fileConverter;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "", filesSizeCalculator);
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileItem file = new File(currentDirectory, name, fileConverter);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        DirectoryItem directory = new Directory(currentDirectory, name, filesSizeCalculator);
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
