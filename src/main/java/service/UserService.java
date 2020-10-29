package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import model.dao.iUserDao;
import model.dao.impl.UserDao;
import model.dto.UserDTO;
import model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import util.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private iUserDao dao = new UserDao();

    public List<UserDTO> getAllUser() {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : dao.findAll()) {
            dtos.add(convertToDTO(user));
        }
        return dtos;
    }

    public List<UserDTO> getTopUser(){
        List<UserDTO> dtos = new ArrayList<>();
        for(User user: dao.findTopUser()){
            dtos.add(convertToDTO(user));
        }
        return dtos;
    }

    public UserDTO getUser(String username) {
        User user = dao.findOne(username);
        return convertToDTO(user);
    }

    //check login and store to session if success
    public boolean login(HttpServletRequest req, String username, String password) {
        User user = dao.findOne(username);
        if (user == null)
            return false;
        else if (BCrypt.checkpw(password, user.getPassword())) {
            AppUtils.storeLoginedUser(req.getSession(), user);
            return true;
        }
        return false;
    }

    public boolean checkPass(String pass, String password){
        return BCrypt.checkpw(password, pass);
    }

    public int changePass(String username, String password){

        return dao.changePassword(username, BCrypt.hashpw(password,BCrypt.gensalt(12)));
    }

    public boolean changeProfile(HttpServletRequest req, String json){
        UserDTO dto = jsonToDTO(json);
        if(updateUser(dto) == 1){
            AppUtils.storeLoginedUser(req.getSession(), convertToEntity(dto));
            return true;
        }
        return false;
    }


    public int saveUser(UserDTO dto) {
        User user = convertToEntity(dto);
        return dao.insert(user);
    }

    public int updateUser(UserDTO dto) {
        User user = convertToEntity(dto);
        return dao.update(user);
    }


    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setStatus(dto.getStatus());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAvt(dto.getAvt());
        user.setPhone(dto.getPhone());
        java.sql.Date sqlDate = new java.sql.Date(dto.getDob().getTime());
        user.setDob(sqlDate);
        return user;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setStatus(user.getStatus());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAvt(user.getAvt());
        dto.setPhone(user.getPhone());
        dto.setDob(user.getDob());
        dto.setUpVotes(user.getUpVotes());
        dto.setPosts(user.getPosts());
        return dto;
    }

    private UserDTO jsonToDTO(String json){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ObjectReader reader = mapper.reader(UserDTO.class);
            MappingIterator elements = reader.readValues(json);
            UserDTO user = (UserDTO) elements.next();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
