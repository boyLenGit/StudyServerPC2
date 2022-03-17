package len.cloud02.geodata.gd_client.web;

import len.cloud02.geodata.gd_client.pojo.OneWell;
import len.cloud02.geodata.gd_client.service.RestOneWellService;
import len.cloud02.geodata.gd_client.util.out.LenLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geodata")
public class GetDgController {
    @Autowired
    private RestOneWellService restOneWellService;

    public OneWell queryOneWellByIdWithRest(@Param("id")int id){
        OneWell oneWell = restOneWellService.queryOneWellByIdWithRest(id);
        LenLog.staticInfo("queryOneWellByIdWithRest", oneWell.toString());
        return oneWell;
    }
}
