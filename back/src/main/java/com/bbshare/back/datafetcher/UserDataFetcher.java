package com.bbshare.back.datafetcher;

import com.bbshare.back.model.User;
import com.bbshare.back.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class UserDataFetcher {

    @Autowired
    private UserService userService;

    @DgsQuery
    public List<User> users(@InputArgument List<String> ids) {
        return userService.getUsers(ids);
    }

    @DgsQuery
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

}