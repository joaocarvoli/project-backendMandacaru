package br.ufc.demoday.repository;
import br.ufc.demoday.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//Anotação @Repository na Interface UsesRepository extendendo a interface JpaRepository e delegando a gerencia dos dados 
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
