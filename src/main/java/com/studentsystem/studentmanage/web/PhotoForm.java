package com.studentsystem.studentmanage.web;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PhotoForm {
    private MultipartFile photofile;
}
