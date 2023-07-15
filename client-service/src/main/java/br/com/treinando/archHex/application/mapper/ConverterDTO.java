package br.com.treinando.archHex.application.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ConverterDTO<T> {

    private final ModelMapperConfig modelMapperConfig;

    public T convertObjects(T object, Class<T> type){
        return modelMapperConfig.modelMapper().map(object,type);
    }

     public List<T> convertObjectList(List<T> listObject, Class<T> type){

        return listObject.stream()
                .map(response -> new ModelMapper().map(response,type))
                .collect(Collectors.toList());
     }
}
