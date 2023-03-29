package com.kreitek.files;

import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileConverter;
import com.kreitek.interfaces.FileItem;
import com.kreitek.interfaces.FileSystemItem;

public class File extends FileSystemItemBase implements FileItem {

    private int size = 0;
    private boolean isOpen = false;
    private int position = 0;
    private final FileConverter fileConverter;

    public File(DirectoryItem parent, String name, FileConverter fileConverter) {
        super(parent, name);
        this.fileConverter = fileConverter;
    }

    @Override
    public String getExtension() {
        String extension = "";
        int indexOfLastDot = getName().lastIndexOf(".");
        if (indexOfLastDot > 0) {
            extension = getName().substring(indexOfLastDot + 1);
        }
        return extension;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void open() {
        isOpen = true;
        // Aquí vendría código que actualizaría también this.size
    }

    @Override
    public void setPosition(int numberOfBytesFromBeginning) {
        if (!isOpen) {
            throw new UnsupportedOperationException("Debe abrir el fichero primero");
        }
        if (numberOfBytesFromBeginning > size) {
            throw new UnsupportedOperationException("La posición no puede ser mayor que el tamaño del fichero");
        }
        this.position = numberOfBytesFromBeginning;
    }

    @Override
    public byte[] read(int numberOfBytesToRead) {
        if (position + numberOfBytesToRead > size) {
            numberOfBytesToRead = size - position;
        }
        // Aquí habría lógica que lee el contenido del fichero
        byte[] buffer = new byte[numberOfBytesToRead];
        position += numberOfBytesToRead;
        return buffer;
    }

    @Override
    public void write(byte[] buffer) {
        // Aquí habría lógica que escribiría en el fichero
        size += buffer.length;
        position += buffer.length;
    }

    @Override
    public void close() {
        isOpen = false;
    }

    public FileSystemItem convertMp3ToWav(){
        return fileConverter.convertMp3ToWav();
    }

    public FileSystemItem convertWavToMp3() {
        return fileConverter.convertWavToMp3();
    }

}
