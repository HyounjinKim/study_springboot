package com.khj.fileex.file;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final Path imagePath;

    public FileController() {
        imagePath = Paths.get("src/main/resources/static/images/upload/")
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/upload")
    public EntityModel<FileDto> uploadFile(MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(imagePath + "/" + file.getOriginalFilename());

            File dest = new File(imagePath + "/" + file.getOriginalFilename());
            file.transferTo(dest);

            EntityModel<FileDto> entityModel = EntityModel.of(new FileDto(file.getOriginalFilename()));
            entityModel.add(
                    WebMvcLinkBuilder
                            .linkTo(
                                    WebMvcLinkBuilder
                                            .methodOn(FileController.class)
                                            .getImage(file.getOriginalFilename())
                            )
                            .withRel("download"));
            return entityModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        Path filePath = this.imagePath.resolve(fileName).normalize();
        Resource resource = null;

        try {
            resource = new UrlResource(filePath.toUri());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(resource);
    }

}
