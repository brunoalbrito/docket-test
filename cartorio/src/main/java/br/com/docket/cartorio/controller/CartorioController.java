package br.com.docket.cartorio.controller;


import br.com.docket.cartorio.dto.CartorioDTO;
import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartorio")
public class CartorioController {

    @Autowired
    private CartorioService service;

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return service.findById(id).map(c -> {
            return ResponseEntity.ok(CartorioDTO.convertToDtoWithId(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartorioDTO cartorioDTO) {
        return ResponseEntity.ok(service.save(Cartorio.of(cartorioDTO)));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody CartorioDTO cartorioDTO) {
        service.delete(Cartorio.of(cartorioDTO));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity alter(@RequestBody CartorioDTO cartorioDTO) {
        return ResponseEntity.ok(service.save(Cartorio.of(cartorioDTO)));
    }
}
