package pl.zulwik.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.zulwik.driver.exception.FileStorageException;
import pl.zulwik.driver.exception.MyFileNotFoundException;
import pl.zulwik.driver.model.DbFile;
import pl.zulwik.driver.repository.DbFileRepository;

import java.io.IOException;

@Service
public class DbFileStorageService {
    @Autowired
    private DbFileRepository dbFileRepository;

    public DbFile storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            DbFile dbFile = new DbFile(fileName, file.getContentType(), file.getBytes());
            return dbFileRepository.save(dbFile);
        }catch (IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
    public DbFile getFile(String fileId){
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}