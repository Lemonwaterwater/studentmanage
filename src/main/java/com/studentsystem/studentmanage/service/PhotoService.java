package com.studentsystem.studentmanage.service;

import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Dao.UserRepo;
import com.studentsystem.studentmanage.Domain.User;
import com.studentsystem.studentmanage.utils.FileUtils;
import com.studentsystem.studentmanage.web.PhotoForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PhotoService {
    @Autowired
    private IndexDao indexDao;
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private UserRepo userRepo;
    public void Addproduct(PhotoForm photoForm,String userNo){
        System.out.println(userNo);
        Optional<User> users= userRepo.findById(userNo);
        User user = users.get();
//        BeanUtils.copyProperties(photoForm, user, User.class);
        user.setPhoto(fileUtils.fileUpload(photoForm.getPhotofile()));
//        user.setId(10086);
//        user.setUsername("aaa");
//        user.setPassword("aaaa");
//        user.setPassword1("aaa");
//        user.setQqemail("aa@aa.com");
        indexDao.update(user);
    }
}
