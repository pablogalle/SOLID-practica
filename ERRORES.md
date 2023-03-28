# ERRORES

 ---
### *Principio de segregación de interfaz (ISP)*

La interfaz `FileSystemItem` se ha dividido en interfaces más específicas; 
`FileItem` y `DirectoryItem`. De esta forma la clase `File`tendran que implementar 
solo los métodos necesarios para los archivos, mientras que la clase `Directory` 
tendran que implementar solo los métodos necesarios para los directorios.

```java
import com.kreitek.interfaces.FileSystemItem;

import java.util.List;

class Directory {
    // METODOS ELIMINADOS DE LA CLASE DIRECTORY

    @Override
    public void open() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    @Override
    public String getExtension() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    @Override
    public void setPosition(int numberOfBytesFromBeginning) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    @Override
    public byte[] read(int numberOfBytesToRead) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    @Override
    public void write(byte[] buffer) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);

    }

    public void close() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }
}

class File {
    // METODOS ELIMINADOS DE LA CLASE FILE

    @Override
    public List<FileSystemItem> listFiles() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_FICHEROS);
    }

    @Override
    public void addFile(FileSystemItem file) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_FICHEROS);

    }

    @Override
    public void removeFile(FileSystemItem file) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_FICHEROS);

    }
}
```

### *Principio de inversión de dependencia (DIP)*
 
La clase `Directory` depende directamente de la clase `File Manager`.
```java
class Directory{
    
    public int getSize() {
        return FileManager.calculateSize(files);
    }
}

class FileManager{
    
    public static int calculateSize(List<FileSystemItem> files) {
        // Aqui estaria el codigo de calculateSize
    }
}

```

Creamos la interaz `FileSizeCalculator` con el metodo `calculateSize()` para que asi la clase 
`FileManager` implemente esta interfaz. `Directory` tendrá una dependencia a la misma en lugar
de a la clase `FileManager` directamente.





