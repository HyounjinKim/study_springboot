package com.khj.fileex.user;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String role;
    private String imagePath;
}
