package com.kreitek.interfaces;


public interface FileConverter {
    FileSystemItem convertMp3ToWav(FileItem file);
    FileSystemItem convertWavToMp3(FileItem file);
}
