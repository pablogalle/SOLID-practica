package com.kreitek.interfaces;

public interface FileItem extends FileSystemItem{
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);
    String getExtension();

}
