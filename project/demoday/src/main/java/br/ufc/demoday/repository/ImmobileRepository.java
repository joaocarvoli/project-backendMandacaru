package br.ufc.demoday.repository;
import br.ufc.demoday.model.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImmobileRepository extends JpaRepository<Immobile, Integer>{
}
