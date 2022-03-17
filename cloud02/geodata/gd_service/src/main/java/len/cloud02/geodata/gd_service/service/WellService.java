package len.cloud02.geodata.gd_service.service;

import len.cloud02.geodata.gd_service.mapper.WellDateMapper;
import len.cloud02.geodata.gd_service.pojo.OneWell;
import org.springframework.stereotype.Service;

@Service
public class WellService {
    private WellDateMapper wellDateMapper;

    public OneWell queryOneWellById(int id){
        OneWell oneWell = wellDateMapper.findById(id);
        return oneWell;
    }
}
