package com.bbshare.back.mutation;

import com.bbshare.back.model.User;
import com.bbshare.back.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class UserMutation {

    @Autowired
    private UserService userService;

    @DgsMutation
    public User createUser(@InputArgument String lastname, @InputArgument String firstname) {
        return userService.addUser(lastname, firstname);
    }
}