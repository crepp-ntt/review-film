package model.service;

import model.dao.iUserDao;
import model.dao.impl.UserDao;
import model.dto.UserDTO;
import model.entity.User;

public class UserService {
    private iUserDao dao = new UserDao();

    public UserDTO getUser(String username) {
        User user = dao.findOne(username);
        return convertToDTO(user);
    }

    public boolean login(String username, String password) {
        User user = dao.findOne(username);
        if (user == null)
            return false;
        else return password.equals(user.getPassword());
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
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAvt(dto.getAvt());
        user.setPhone(dto.getPhone());
        user.setDob(dto.getDob());
        return user;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAvt(user.getAvt());
        dto.setPhone(user.getPhone());
        dto.setDob(user.getDob());
        return dto;
    }
}