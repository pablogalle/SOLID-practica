package com.kreitek.interfaces;

import java.util.List;

public interface FilesSizeCalculator {
    int calculateSize(List<FileSystemItem> files);
}
