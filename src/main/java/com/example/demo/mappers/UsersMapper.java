package com.example.demo.mappers;

import com.example.demo.pojos.User;
import com.example.demo.responses.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersMapper {

    public List<UserResponse> mapUsers(Iterable<User> all)
    {
        List<UserResponse> users = new ArrayList<>();
        for(User user : all) {
            UserResponse userResponse = mapUserToUserResponse(user);
            users.add(userResponse);
        }
        return users;
    }

    public UserResponse mapUserToUserResponse(User user)
    {
        return new UserResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getNumberOfBookings(),
                        mapStatus(user)
                );
    }

    public String mapStatus(User user)
    {
        return String.valueOf(user.getStatus()).toLowerCase();
    }

}
