package testWsWork.SpringCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import testWsWork.SpringCar.Csv.CSVHelper;
import testWsWork.SpringCar.repositories.CarUploadRepositoyJPA;
import testWsWork.SpringCar.repositories.entities.Car;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    private CarUploadRepositoyJPA carUploadRepositoyJPA;

    public void save (MultipartFile file){

        try{
            List<Car> carList = CSVHelper.csvToCar(file.getInputStream());
            carUploadRepositoyJPA.saveAllAndFlush(carList);
        }catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


    public List<Car> getAllCarUpload(){
        return carUploadRepositoyJPA.findAll();
    }
}
