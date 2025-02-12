package ru.pet.project.order_processing.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pet.project.order_processing.db.enums.OrderStatus;
import ru.pet.project.order_processing.db.tables.pojos.Orders;
import ru.pet.project.order_processing.db.tables.records.OrdersRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.pet.project.order_processing.db.Tables.ORDERS;

/**
 * @author Gamma on 12.02.2025
 */
@Repository
public class OrderRepository extends JOOQRepository<Orders> {

    @Autowired
    public OrderRepository(DSLContext dsl) {
        super(dsl);
    }

    @Override
    @Transactional
    public Orders save(Orders tablePojo) {
        OrdersRecord ordersRecord = dsl.insertInto(ORDERS)
                .set(ORDERS.USER_ID, tablePojo.getUserId())
                .set(ORDERS.STATUS, OrderStatus.CREATED)
                .set(ORDERS.CREATED_AT, LocalDateTime.now())
                .set(ORDERS.UPDATED_AT, LocalDateTime.now())
                .returning(ORDERS.ID).fetchOne();

        if (ordersRecord != null) {
            tablePojo.setId(ordersRecord.getValue(ORDERS.ID));
            return tablePojo;
        }

        return null;
    }

    @Override
    public Orders update(Orders tablePojo, UUID id) {
        return null;
    }

    @Override
    public List<Orders> findAll() {
        return List.of();
    }

    @Override
    public Optional<Orders> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        return false;
    }
}
