package len.cloud02.geodata.gd_client.service;

import len.cloud02.geodata.gd_client.pojo.OneWell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestOneWellService {
    @Autowired
    private RestTemplate restTemplate;

    public OneWell queryOneWellByIdWithRest(int id){
        String url = "http://geodataservice/geodata/queryById/" + id;
        OneWell oneWell = restTemplate.getForObject(url, OneWell.class);
        return oneWell;
    }
}
