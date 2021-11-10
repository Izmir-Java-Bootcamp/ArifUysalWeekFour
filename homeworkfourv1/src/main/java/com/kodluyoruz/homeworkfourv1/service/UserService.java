package com.kodluyoruz.homeworkfourv1.service;
import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.dto.UserDto;
import com.kodluyoruz.homeworkfourv1.model.entity.User;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateUserRequest;
import com.kodluyoruz.homeworkfourv1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.kodluyoruz.homeworkfourv1.mapper.BasketMapper.BASKET_MAPPER;
import static com.kodluyoruz.homeworkfourv1.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserDto createUser(CreateUpdateUserRequest request) {
        User user = USER_MAPPER.createUser(request);
        return USER_MAPPER.toUserDto(repository.save(user));
    }

    public User getUserEntity( int id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }
    public UserDto getUser( int id ){
        User user = getUserEntity(id);
        return USER_MAPPER.toUserDto(user);
    }

    public List<UserDto> getUsers() {
        return USER_MAPPER.toUserDtoList(repository.findAll());
    }

    public UserDto updateUser(int id, CreateUpdateUserRequest request) {
        User user = getUserEntity(id);
        USER_MAPPER.updateUser(user,request);
        User updatedUser = repository.save(user);
        return USER_MAPPER.toUserDto(updatedUser);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public BasketDto getBasket(int id) {
        User user = repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return null;
    }
}