package ma.fpl.tp2ex11.controller;

import ma.fpl.tp2ex11.entity.nombre;
import ma.fpl.tp2ex11.service.nombreservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class nombrecontroller {
    @Autowired
    private nombreservice nombreservice;


    @GetMapping("/somme")
    public ResponseEntity<Map<String, Double>> some(@RequestParam double n1, @RequestParam double n2) {
        nombre n = new nombre(n1, n2);
        Map<String, Double> responseJson = new HashMap<>();
        responseJson.put("result", nombreservice.some(n));
        return ResponseEntity.ok(responseJson);
    }

}
