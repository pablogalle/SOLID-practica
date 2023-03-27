# ERRORES

 ---
### *Liskov substitution*

La superclase `FileSystemItemBase` y la interfaz `FileSystemItem` tenian metodos 
que deberian haber sido propios de la clase `File`

```java 
    @Override
    public void open() {
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
```




