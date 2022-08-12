package br.ufc.demoday.service;
import br.ufc.demoday.repository.UserRepository;
import br.ufc.demoday.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

//Anotação @Sevice para referenciar camada de Negócio
@Service
public class UserService {
  
	//Injeção automática de dependências spring na interface UserRepository
	@Autowired
    UserRepository userRepository;

	//Tratativas vindas da camada controller,  Classe UserController
	
    public void save(int idUser, User entity){
        if (idUser != 0) {
            entity.setIdUser(idUser); //Requer implementação da classe User
        }
        userRepository.save(entity);
    }

    public void update(int idUser, User entity){
        // Falta finalizar esse método pois é preciso que a classe User esteja pronta
        User user = userRepository.find(idUser);
        //user.
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
        Optional<User> user = userRepository.findById(idUser);  // Necessário utilizar o método find e instanciar o objeto user sem o container Optional 
        if(user.isPresent()){//Requer alterar a condição lógica
            userRepository.delete(user); 
        }
    }
}
