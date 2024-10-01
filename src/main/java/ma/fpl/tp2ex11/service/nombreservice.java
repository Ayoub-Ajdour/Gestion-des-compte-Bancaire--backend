package ma.fpl.tp2ex11.service;

import ma.fpl.tp2ex11.entity.nombre;
import org.springframework.stereotype.Service;

@Service
public class nombreservice {
public double some(nombre n){
    return n.getN1()+n.getN2();
}

}
