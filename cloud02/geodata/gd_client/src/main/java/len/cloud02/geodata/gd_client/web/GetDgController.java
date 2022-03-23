package len.cloud02.geodata.gd_client.web;

import len.cloud02.geodata.gd_client.pojo.OneWell;
import len.cloud02.geodata.gd_client.service.RestOneWellService;
import len.cloud02.geodata.gd_client.util.out.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geodata")
public class GetDgController {
    @Autowired
    private RestOneWellService restOneWellService;

    // Test:http://localhost:8088/geodata/queryByIdRest/5
    @GetMapping("/queryByIdRest/{oneWellId}")
    public OneWell queryOneWellByIdWithRest(@PathVariable("oneWellId")int oneWellId){
        OneWell oneWell = restOneWellService.queryOneWellByIdWithRest(oneWellId);
        LenLog.staticInfo("queryOneWellByIdWithRest", oneWell.toString());
        return oneWell;
    }
}
