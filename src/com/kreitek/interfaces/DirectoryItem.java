package com.kreitek.interfaces;

import java.util.List;

public interface DirectoryItem extends FileSystemItem{
    List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);

}
