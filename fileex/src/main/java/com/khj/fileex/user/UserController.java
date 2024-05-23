package com.khj.fileex.user;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/join",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String join(@Valid @RequestPart(value = "userDto") UserDto userDto,
                       @RequestPart(value = "file") MultipartFile imageFile){

        System.out.println(userDto);
        System.out.println(imageFile.getOriginalFilename());

        User user = new User();
        BeanUtils.copyProperties(userDto,user);

        System.out.println(user);
        userService.join(user,imageFile);

        return "회원가입";
    }

    @PostMapping("login")
    public String login(@RequestBody UserDto userDto){
        String result = userService.loginCheck(userDto);

        return result;
    }
}
