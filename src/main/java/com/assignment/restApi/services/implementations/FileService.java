package com.assignment.restApi.services.implementations;

import com.assignment.restApi.entities.Employee;
import com.assignment.restApi.exceptions.EmployeeNotFoundException;
import com.assignment.restApi.repository.EmployeeRepository;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

@Service
public class FileService {

    private final EmployeeRepository employeeRepository;
    @Value("${app.upload.profileImgs}")
    private String basePath;

    public FileService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public String saveProfileImage(MultipartFile file, Long Id) throws IOException {
        Path uploadPath = Paths.get(basePath);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Employee emp = employeeRepository.findById(Id).orElseThrow(() -> new EmployeeNotFoundException());
        String fileName = new String(emp.getId().toString() + "profile_img.png");
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        emp.setProfileImagePath(filePath.toString());
        employeeRepository.save(emp);
        return filePath.toString();
    }

    public ResponseEntity<Resource> getProfileImage(Long Id) throws MalformedURLException {
        Employee emp = employeeRepository.findById(Id).orElseThrow(() -> new EmployeeNotFoundException());
        String fileName = new String(emp.getId().toString() + "profile_img.png");
        Path filePath = Paths.get(basePath).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Cache-Control", "public, max-age=3600");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.IMAGE_JPEG)
//                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).cachePublic())
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void processFile(String filePath) {
        try {
            File file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
