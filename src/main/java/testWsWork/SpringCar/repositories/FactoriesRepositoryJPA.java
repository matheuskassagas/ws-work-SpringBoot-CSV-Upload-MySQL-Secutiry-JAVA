package testWsWork.SpringCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testWsWork.SpringCar.repositories.entities.Factorie;

@Repository
public interface FactoriesRepositoryJPA extends JpaRepository<Factorie, Integer> {
}
