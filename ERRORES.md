# ERRORES

 ---
### *Principio de segregación de interfaz (ISP)*

La interfaz `FileSystemItem` se ha dividido en interfaces más específicas; 
`FileItem` y `DirectoryItem`. De esta forma la clase `File`tendran que implementar 
solo los métodos necesarios para los archivos, mientras que la clase `Directory` 
tendran que implementar solo los métodos necesarios para los directorios.

```java
import com.kreitek.files.FileSystemItem;

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




