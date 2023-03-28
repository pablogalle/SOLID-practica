package com.kreitek.files;

import com.kreitek.service.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements DirectoryItem {

    private static final String NO_ES_VALIDO_PARA_DIRECTORIOS = "No es válido para directorios";
    private final List<FileSystemItem> files;

    public Directory(DirectoryItem parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
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
        return FileManager.calculateSize(files);
    }
}
