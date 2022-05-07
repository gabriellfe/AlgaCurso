package com.algaworks.algafood.api.disassembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;

	
	public Restaurante toDomainObject(RestauranteInput restauranteInput) {
		return modelMapper.map(restauranteInput, Restaurante.class);
	}
	
	public List<Restaurante> toCollectionDomain(List<RestauranteInput> restaurantes) {
		return restaurantes.stream()
				.map(restaurante -> toDomainObject(restaurante))
				.collect(Collectors.toList());
	}
	

}
