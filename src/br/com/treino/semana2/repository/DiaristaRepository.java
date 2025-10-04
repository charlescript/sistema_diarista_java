package br.com.treino.semana2.repository;

import java.util.List;
import java.util.ArrayList;
import br.com.treino.semana2.models.Diarista;

/**
 * Repositório em memória para gerenciar instâncias de {@link Diarista}.
 * Implementa as operações básicas de CRUD definidas pela interface {@code IRepository}.
 * 
 * <p>
 * Os diaristas são armazenados em uma lista interna e os IDs são gerados automaticamente.
 * </p>
 *
 * @author Charles Rocha
 * @since 1.0
 */
public class DiaristaRepository implements IRepository<Diarista, Long> {

    private List<Diarista> diaristas;
    private Long idAtual;

    public DiaristaRepository() {
        diaristas = new ArrayList<>();
        idAtual = 1L;
    }
    
    @Override
    public List<Diarista> buscarTodos(){
        return diaristas;
    }

    @Override
    public Diarista cadastrar(Diarista model) {
        model.setId(idAtual);

        diaristas.add(model);
        idAtual++;

        return model;
    }

    @Override
    public Diarista buscarPorId(Long id){

        for (Diarista diarista : diaristas ){
            if(diarista.getId().equals(id)){
                return diarista;
            }
        }

        return null;
    }

    @Override
    public boolean excluirPorId(Long id){
        var diaristaEncontrada = buscarPorId(id);

        if(diaristaEncontrada != null){
            diaristas.remove(diaristaEncontrada);
            return true;
        }

        return false;
    }
    
}
