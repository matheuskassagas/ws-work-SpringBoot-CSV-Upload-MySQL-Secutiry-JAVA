package testWsWork.SpringCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testWsWork.SpringCar.repositories.entities.Car;

@Repository
public interface CarUploadRepositoyJPA extends JpaRepository<Car, Integer> {
}
