package com.izibiz.repository.repository;

import com.izibiz.repository.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity,Long> {


    List<InvoiceEntity> findInvoiceByStatusAndUserId(String status, Long id);

    List<InvoiceEntity> findInvoicesByUserId(Long userId);

  Optional<InvoiceEntity> findByIdAndUserId(Long id, Long userId);



    List<InvoiceEntity> findByUserId(Long userId);
}
