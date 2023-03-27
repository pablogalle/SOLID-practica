package com.kreitek.utils;

import com.kreitek.files.*;

public class FileSystemBuilder {

    private final DirectoryItem root;
    private DirectoryItem currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
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
        DirectoryItem directory = new Directory(currentDirectory, name);
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
