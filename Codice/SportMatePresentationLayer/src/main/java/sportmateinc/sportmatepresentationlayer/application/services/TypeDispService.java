package sportmateinc.sportmatepresentationlayer.application.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import sportmateinc.sportmatepresentationlayer.application.data.TypeDisp;
import sportmateinc.sportmatepresentationlayer.application.data.TypeDispRepository;

@Service
public class TypeDispService {

    private final TypeDispRepository repository;

    public TypeDispService(TypeDispRepository repository) {
        this.repository = repository;
    }

    public Optional<TypeDisp> get(Long id) {
        return repository.findById(id);
    }

    public TypeDisp update(TypeDisp entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<TypeDisp> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<TypeDisp> list(Pageable pageable, Specification<TypeDisp> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
