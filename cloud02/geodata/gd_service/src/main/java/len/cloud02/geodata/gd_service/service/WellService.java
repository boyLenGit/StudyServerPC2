package len.cloud02.geodata.gd_service.service;

import len.cloud02.geodata.gd_service.mapper.WellDateMapper;
import len.cloud02.geodata.gd_service.pojo.OneWell;
import len.cloud02.geodata.gd_service.util.out.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WellService {

    @Autowired
    private WellDateMapper wellDateMapper;

    public OneWell queryOneWellById(int id){
        LenLog.staticInfo("queryOneWellById","id");
        OneWell oneWell = wellDateMapper.findById(id);
        return oneWell;
    }
}
