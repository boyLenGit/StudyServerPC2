package len.cloud02.geodata_service.web;

import len.cloud02.geodata_service.pojo.OneWell;
import len.cloud02.geodata_service.service.WellService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geodata")
public class WellController {
    private WellService wellService;

    @GetMapping("/queryById/{oneWellId}")
    public OneWell queryOneWellById(@PathVariable("oneWellId")int oneWellId){
        OneWell oneWell = wellService.queryOneWellById(oneWellId);
        return oneWell;
    }
}
