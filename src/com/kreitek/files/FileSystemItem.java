package com.kreitek.files;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(DirectoryItem directory);
    String getFullPath();
    int getSize();
}
