package br.ufc.demoday.service;
import br.ufc.demoday.repository.UserRepository;
import br.ufc.demoday.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(int idUser, User entity){
        if (idUser != 0) {
            entity.setIdUser(idUser);
        }
        userRepository.save(entity);
    }

    public User find(int idUser){
        if(idUser == 0){
            return null;
        }
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public void delete(int idUser){
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            userRepository.delete(user);
        }
    }
}
