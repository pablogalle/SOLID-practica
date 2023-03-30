package com.kreitek.interfaces;

import java.util.List;

public interface FilesSizeCalculator {
    //int calculateSize(FileSystemItem file);
    int calculateSize(List<FileSystemItem> files);
}
