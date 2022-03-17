package len.cloud02.geodata.gd_client.web;

import len.cloud02.geodata.gd_client.pojo.OneWell;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geodata")
public class GetDgController {


    public OneWell queryOneWellByIdWithRest(@Param("id")int id){

    }
}
