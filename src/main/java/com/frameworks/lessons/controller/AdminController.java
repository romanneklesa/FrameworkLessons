package com.frameworks.lessons.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.Role;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.AccountService;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by papus on 28.07.2018.
 */
@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/getusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){

        return userService.listUsers();
    }

    @PostMapping(value = "/deleteuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean deleteUser(@RequestBody String s){
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(s, JsonNode.class); // парсинг текста
            String message = rootNode.get("user_id").asText();
            userService.delete(userService.findById(Integer.parseInt(message)));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/updateaccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean updateAccount(@RequestBody String s){
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(s, JsonNode.class); // парсинг текста
            String account_id = rootNode.get("account_id").asText();
            String amount = rootNode.get("account_id").asText();
            Account account = accountService.getById(Integer.parseInt(account_id));
            account.setAmount(Integer.parseInt(amount));
            accountService.update(account);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/updateuserrole", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean updateUserRole(@RequestBody String s){
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(s, JsonNode.class); // парсинг текста
            String user_id = rootNode.get("user_id").asText();
            User user = userService.findById(Integer.parseInt(user_id));
            List<String> roleList = mapper.readValue(rootNode.get("new_roles").toString(), mapper.getTypeFactory().constructCollectionType(List.class, String.class));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
