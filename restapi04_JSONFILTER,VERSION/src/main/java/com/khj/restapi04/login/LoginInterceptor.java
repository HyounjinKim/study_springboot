package com.khj.restapi04.login;

import com.khj.restapi04.exception.ErrorCode;
import com.khj.restapi04.exception.UsersException;
import com.khj.restapi04.users.User;
import com.khj.restapi04.users.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("asd");
        String password = request.getHeader("password");
        String email = request.getHeader("email");

        System.out.println(password);
        System.out.println(email);

        User dbuser = userRepository.findByEmailAndPassword(email,password);
        if(dbuser == null){
            throw new UsersException(ErrorCode.LOGINFAILED);
        }

        return true;
    }
}
