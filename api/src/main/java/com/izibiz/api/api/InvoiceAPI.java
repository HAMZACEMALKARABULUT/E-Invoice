package com.izibiz.api.api;


import com.izibiz.api.dto.Response;
import com.izibiz.api.dto.InvoiceDto;
import com.izibiz.service.enums.InvoiceState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public interface InvoiceAPI {

    @GetMapping
    Response<List<InvoiceDto>> getInvoices();
    @PostMapping
    Response<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto);
    @GetMapping("/{name}")
    Response<List<InvoiceDto>> getInvoicesByState(InvoiceState state);

    @DeleteMapping({"/{id}"})
    Response<InvoiceDto> deleteInvoiceById(@PathVariable(name = "id") Long id );

    @PutMapping({"/{id}"})
    Response<InvoiceDto> sendInvoiceById(@PathVariable(name = "id") Long id );

    @PostMapping("/update")
    Response<InvoiceDto> updateInvoice(@RequestBody InvoiceDto invoiceDto );



}
