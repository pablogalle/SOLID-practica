package com.kreitek.utils;

import com.kreitek.files.*;
import com.kreitek.interfaces.*;
import com.kreitek.service.FileConverterImpl;
import com.kreitek.service.FilesManager;

public class FileSystemBuilder {

    private final DirectoryItem root;
    private DirectoryItem currentDirectory;
    private final FilesSizeCalculator filesSizeCalculator;
    private final FileConverter fileConverter;

    public static FileSystemBuilder getBuilder() {

        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        filesSizeCalculator = new FilesManager();
        fileConverter = new FileConverterImpl();

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
