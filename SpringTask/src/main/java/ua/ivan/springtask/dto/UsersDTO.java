package ua.ivan.springtask.dto;

import lombok.*;
import ua.ivan.springtask.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UsersDTO {
    private List<User> users;
}
