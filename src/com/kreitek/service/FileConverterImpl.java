package com.kreitek.service;

import com.kreitek.files.File;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.DirectoryItem;
import com.kreitek.interfaces.FileConverter;
import com.kreitek.interfaces.FileItem;
import com.kreitek.interfaces.FileSystemItem;

public class FileConverterImpl implements FileConverter {

    @Override
    public FileSystemItem convertMp3ToWav(FileItem file) {
        if (!"mp3".equalsIgnoreCase(file.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = file.getName().lastIndexOf(".");
        String nameWithoutExtension = file.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = file.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileItem result = new File((DirectoryItem) file.getParent(), newFileName, this);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
    @Override
    public FileSystemItem convertWavToMp3(FileItem file) {
        if (!"wav".equalsIgnoreCase(file.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = file.getName().lastIndexOf(".");
        String nameWithoutExtension = file.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = file.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileItem result = new File((DirectoryItem) file.getParent(), newFileName, this);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

}
