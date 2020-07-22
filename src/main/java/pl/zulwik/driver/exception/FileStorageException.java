package pl.zulwik.driver.exception;

import org.apache.tomcat.jni.File;

public class FileStorageException extends RuntimeException {
    public FileStorageException(String message){
        super(message);
    }
    public FileStorageException(String message, Throwable cause){
        super(message,cause);
    }
}
