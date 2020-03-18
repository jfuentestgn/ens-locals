package net.jfuentestgn.enslocals;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;
import net.jfuentestgn.enslocals.domain.EnsLocalEntity;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class EnsLocalRepository implements PageableRepository<EnsLocalEntity, Long> {

    abstract Optional<EnsLocalEntity> find(String codi10);

    abstract Page<EnsLocalEntity> list(Pageable pageable);

//    @NonNull
//    List<EnsLocalEntity> findAll();

//    EnsLocalEntity save(EnsLocalEntity ensLocal);
}
