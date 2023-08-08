package com.axios.Veiculos.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.axios.Veiculos.models.Veiculo;
import com.axios.Veiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {
	private VeiculoRepository repository;
	

	@Autowired
	public VeiculoService(VeiculoRepository repository) {
		this.repository = repository;
	}
	
	public Veiculo salvar(Veiculo veiculo) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if(veiculo.getAno() > year || veiculo.getPreco().intValue() < 0)
		{
			if(veiculo.getAno() > year) {
				//return   "Erro => Ano não pode ser maior que " + year;
				return null;
			}else {
				//return   "Erro => Preço não pode ser negativo.";
				return null;
			}
		}else {	
			//return "Veiculo Salvo com sucesso!"; 
			return repository.save(veiculo);
		}
	}
	
	
	public Veiculo buscarPorId( Integer id) {
		return repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	
	public String atualizar( Integer id, @RequestBody Veiculo veiculoAtualizado) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		buscarPorId(id);
		if(veiculoAtualizado.getAno() > year || veiculoAtualizado.getPreco().intValue() < 0)
		{
			if(veiculoAtualizado.getAno() > year) {
				return   "Erro => Ano não pode ser maior que " + year;
				}else {
					return   "Erro => Preço não pode ser negativo.";
				}
		}else {	
		veiculoAtualizado.setId(id);
		
		 repository.save(veiculoAtualizado);
		 return "Veiculo atualizado com sucesso!"; 
		}
	}
	
	public void deletarPorId( Integer id) {
		buscarPorId(id);

		repository.deleteById(id);

	} 
	
	
	public List<Veiculo> pesquisar(
            @RequestParam(value = "filtro", 
            required = false, defaultValue = "") String filtro
    ) {
        return repository.findByFilter("%" + filtro + "%");
    }
	
	
	
	/*public Page<Veiculo> findAll(Pageable pageable) {
		
		Page<Veiculo> page = repository.findAll(pageable);
		return  page;
		
    }*/
	/*public Page<Veiculo> findAll(Integer pageInit) {
		Integer size = 5;
		PageRequest pageable = PageRequest.of(pageInit, size);
		Page<Veiculo> page = repository.findAll(pageable);
		return  page;
		
    }*/
	public List<Veiculo> findAll(){
		return  (List<Veiculo>) repository.findAll();
	}
}
