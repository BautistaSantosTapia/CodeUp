package com.mindhub.todolist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
}

/*
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll(){
        return personService.findAllPerson();
    };

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody CreatePerson createPerson){
        if(createPerson.email().isBlank()){
            return ResponseEntity.badRequest().body("Missing email");
        }

        return  new ResponseEntity<>(personService.createPerson(createPerson), HttpStatus.CREATED);
    };
}
*/




/*
@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioRepository propietarioRepository;
    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public List<PropietarioDTO> getAll(){
        return propietarioService.findAll();
    }

    //@GetMapping("/{id}")
    //public Propietario getById(@PathVariable Long id){
        //return propietarioRepository.findById(id).orElseThrow( () -> new PropietarioNotFound("No se encontro el propietario con el id: " + id));
    //} //abstraerlo y aplicar logica

    /*@GetMapping("/uno")
    public Propietario getByCedula(@PathVariable String cedula){
        return propietarioService.findByCedula(cedula);
    }

    @PostMapping
    public ResponseEntity<String> createPropietario(@RequestBody Propietario propietario){
        if(propietarioRepository.existsByCedula(propietario.getCedula())){
            return ResponseEntity.badRequest().body("Ya existe esa cedula");
        }
        propietarioRepository.save(propietario);
        return ResponseEntity.ok("Se creo el propietario");
    }
    //abstraerlo y aplicar logica
} */