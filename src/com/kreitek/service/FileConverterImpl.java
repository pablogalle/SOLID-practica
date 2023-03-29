package com.kreitek.service;

import com.kreitek.files.File;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileConverter;
import com.kreitek.interfaces.FileItem;
import com.kreitek.interfaces.FileSystemItem;

public class FileConverterImpl implements FileConverter {

    private final FileItem FILE;
    public FileConverterImpl(FileItem file) {
        this.FILE = file;
    }

    @Override
    public FileSystemItem convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(FILE.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = FILE.getName().lastIndexOf(".");
        String nameWithoutExtension = FILE.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = FILE.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileItem result = new File((DirectoryItem) FILE.getParent(), newFileName, this);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
    @Override
    public FileSystemItem convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(FILE.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = FILE.getName().lastIndexOf(".");
        String nameWithoutExtension = FILE.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = FILE.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileItem result = new File((DirectoryItem) FILE.getParent(), newFileName, this);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

}
