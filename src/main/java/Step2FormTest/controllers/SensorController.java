package Step2FormTest.controllers;

import Step2FormTest.domain.SensorDomain;
import Step2FormTest.models.Component;
import Step2FormTest.models.ControlStructure;
import Step2FormTest.models.Sensor;
import Step2FormTest.repositories.ComponentRepository;
import Step2FormTest.repositories.ControlStructureRepository;
import Step2FormTest.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private final SensorRepository sensorRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    @Autowired
    private final ControlStructureRepository controlStructureRepository;

    @Autowired
    public SensorController(SensorRepository sensorRepository, ComponentRepository componentRepository, ControlStructureRepository controlStructureRepository) {
        this.sensorRepository = sensorRepository;
        this.componentRepository = componentRepository;
        this.controlStructureRepository = controlStructureRepository;
    }

    @GetMapping
    public List findAll(){
        return sensorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return sensorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sensor create(@RequestBody SensorDomain sensorDomain){
        Sensor sensor = new Sensor();
        sensor.setName(sensorDomain.getName());
        try{
            Optional<Component> father = componentRepository.findById(sensorDomain.getFather_id());
            sensor.setFather(father.get());
            father.get().setControlStructure(true);
        }catch (Exception ex){
            sensor.setFather(null);
        }
        sensor.setBorder(sensorDomain.getBorder());
        sensor.setIsVisible(sensorDomain.getIsVisible());
        Optional<ControlStructure> c1 = controlStructureRepository.findById(sensorDomain.getControl_structure_id());
        c1.get().getComponents().add(sensor);
        controlStructureRepository.save(c1.get());
        return sensor;
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Sensor sensorParam) {
        return sensorRepository.findById(id)
                .map(record -> {
                    record.setName(sensorParam.getName());
                    Sensor updated = sensorRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return sensorRepository.findById(id)
                .map(record -> {
                    sensorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
