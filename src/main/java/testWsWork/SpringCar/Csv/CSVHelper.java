package testWsWork.SpringCar.Csv;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;
import testWsWork.SpringCar.repositories.entities.Car;
import testWsWork.SpringCar.repositories.entities.Factorie;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "MarcaId", "MarcaNome", "Modelo", "Ano", "Combustivel", "NumPortas", "ValorFipe", "Cor"};

    //hasCSVFormat usado para verificar se o formato do arquivo é CSV ou não.
    public static boolean hasCSVFormat(MultipartFile file){
        if(TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")){
            return true;
        }
        return false;
    }

    public static List<Car> csvToCar (InputStream is){
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){

        List<Car> carList = new ArrayList<>();
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();
        for (CSVRecord csvRecord : csvRecords){
            Factorie factorie = new Factorie();
            factorie.setId(Integer.parseInt(csvRecord.get("MarcaId")));
            factorie.setName(csvRecord.get("MarcaNome"));
            Car car = new Car();
            car.setId(Integer.parseInt(csvRecord.get("Id")));
            car.setFactorie(factorie);
            car.setModel(csvRecord.get("Modelo"));
            car.setYear(csvRecord.get("Ano"));
            car.setFuel(csvRecord.get("Combustivel"));
            car.setDoors(csvRecord.get("NumPortas"));
            car.setCost(csvRecord.get("ValorFipe"));
            car.setColor(csvRecord.get("Cor"));

            carList.add(car);
        }
        return carList;

        }catch (IOException e){
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}