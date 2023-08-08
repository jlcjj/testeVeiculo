package com.axios.Veiculos.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.axios.Veiculos.models.Veiculo;
import com.axios.Veiculos.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin("http://localhost:4200")
public class VeiculoController {
	
	@Autowired
	private VeiculoService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo salvar(@RequestBody  @Validated Veiculo veiculo) {
		veiculo.setCreated(LocalDate.now());
		return service.salvar(veiculo);
	}
	
	@GetMapping("{id}")
	public Veiculo buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
		
		
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String atualizar(@PathVariable Integer id, @RequestBody Veiculo veiculoAtualizado) {
		veiculoAtualizado.setUpdated(LocalDate.now());
		return service.atualizar(id, veiculoAtualizado);
	}
		
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Integer id) {
		service.deletarPorId(id);
	} 
	@GetMapping("/pesquisa")
    public List<Veiculo> search(@RequestParam("filtro") String filtro) {
        return service.pesquisar(filtro);

    }

    /*public Page<Veiculo> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }*/
	
   /* public Page<Veiculo> findAll(Integer page) {
		Integer size = 5;
		PageRequest pageable = PageRequest.of(page, size);
		return service.findAll(page);
    }*/
	
	@GetMapping
	public List<Veiculo> findAll(){
		return service.findAll();
	}
}
