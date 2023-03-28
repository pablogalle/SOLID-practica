package com.kreitek.interfaces;

import java.util.List;

public interface FileSizeCalculator {
    int calculateSize(List<FileSystemItem> files);
}
