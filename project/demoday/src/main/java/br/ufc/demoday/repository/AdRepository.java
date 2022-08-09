package br.ufc.demoday.repository;
import br.ufc.demoday.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdRepository extends JpaRepository<Ad, Integer>{
}
