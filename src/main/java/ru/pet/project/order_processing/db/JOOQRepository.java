package ru.pet.project.order_processing.db;

import org.jooq.DSLContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Gamma on 12.02.2025
 */

public abstract class JOOQRepository<T> {
    protected final DSLContext dsl;

    protected JOOQRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public abstract T save(T tablePojo);

    public abstract T update(T tablePojo, UUID id);

    public abstract List<T> findAll();

    public abstract Optional<T> findById(UUID id);

    public abstract boolean deleteById(UUID id);
}
