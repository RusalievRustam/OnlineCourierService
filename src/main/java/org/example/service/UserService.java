package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User convertToUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
    public UserDTO convertToUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO updateUser(UserDTO userDTO,Long id){
        User user = userRepository.getReferenceById(id);
        user.setUsername(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRole());
        return convertToUserDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> listUsers = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        listUsers.forEach(c -> usersDTO.add(convertToUserDTO(c)));
        return usersDTO;
    }
    public void saveUser(UserDTO userDTO){
        User user = convertToUser(userDTO);
        userRepository.save(user);
    }
}
