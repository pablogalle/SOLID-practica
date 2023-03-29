package com.kreitek.files;

import com.kreitek.interfaces.FilesSizeCalculator;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileSystemItem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements DirectoryItem {
    private final List<FileSystemItem> files;
    private final FilesSizeCalculator filesSizeCalculator;

    public Directory(DirectoryItem parent, String name, FilesSizeCalculator filesSizeCalculator) {
        super(parent, name);
        files = new ArrayList<>();
        this.filesSizeCalculator = filesSizeCalculator;
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        return filesSizeCalculator.calculateSize(files);
    }
}
