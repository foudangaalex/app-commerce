package co.faroty.appcommerce.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String email;
    private String imageUser;
    private String tel;
    private String passWord;
}
