package len.cloud02.geodata.gd_service.web;

import len.cloud02.geodata.gd_service.pojo.OneWell;
import len.cloud02.geodata.gd_service.service.WellService;
import len.cloud02.geodata.gd_service.util.out.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geodata")
public class WellController {
    @Autowired
    private WellService wellService;

    @GetMapping("/queryById/{oneWellId}")
    public OneWell queryOneWellById(@PathVariable("oneWellId")int oneWellId){
        LenLog.staticInfo("queryOneWellById", String.valueOf(oneWellId));
        OneWell oneWell = wellService.queryOneWellById(oneWellId);
        LenLog.staticInfo("queryOneWellById", oneWell.toString());
        return oneWell;
    }
}
