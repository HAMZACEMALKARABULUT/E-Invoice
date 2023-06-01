package com.izibiz.api.controller;


import com.izibiz.api.api.InvoiceAPI;
import com.izibiz.api.context.Context;
import com.izibiz.api.dto.InvoiceDto;
import com.izibiz.api.dto.Response;
import com.izibiz.api.mapper.InvoiceDtoMapper;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.enums.InvoiceState;
import com.izibiz.service.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceController implements InvoiceAPI {


    @Autowired
    private InvoiceService invoiceService;



    @Autowired
private InvoiceDtoMapper invoiceMapper;


    //----------------------CREATE INVOICE METHODS -------------------------//




    @Override

    public Response<InvoiceDto> deleteInvoiceById(Long id){
        Long userId = Context.getCurrentUser().getUserId();
InvoiceDto invoiceDto=invoiceMapper.toDto(invoiceService.setInvoiceStatus(id,userId,InvoiceState.CANCEL));
     return Response.<InvoiceDto>builder().data(invoiceDto).build();
    }
@Override
    public Response<InvoiceDto> createInvoice(InvoiceDto invoiceDto) {

        Long userId = Context.getCurrentUser().getUserId();

       Invoice invoice  = invoiceMapper.toInvoice(invoiceDto);

        invoice.setStatus(InvoiceState.DRAFT.toString());

        InvoiceDto returnDto=invoiceMapper.toDto(invoiceService.createInvoice(invoice,userId));

        return Response.<InvoiceDto>builder().data(returnDto).build();


    }
@Override
    public Response<List<InvoiceDto>> getInvoices() {
        Long userId = Context.getCurrentUser().getUserId();
      List<InvoiceDto>  invoicesDto= invoiceMapper.toInvoiceDtoList(invoiceService.getInvoices(userId));
        return Response.<List<InvoiceDto>>builder().data(invoicesDto).build();
    }
//    public String generateUuid() {
//        UUID uuid = UUID.randomUUID();
//        String uuidAsString = uuid.toString();
//        return uuidAsString;}
    @Override
    public Response<InvoiceDto> sendInvoiceById(Long id) {
        Long userId = Context.getCurrentUser().getUserId();
     InvoiceDto invoiceDto=invoiceMapper.toDto(invoiceService.setInvoiceStatus(id,userId,InvoiceState.SENT))   ;
        return Response.<InvoiceDto>builder().data(invoiceDto).build();
    }

    @Override
    public Response<InvoiceDto> updateInvoice(InvoiceDto invoiceDto) {

      Invoice invoice=  invoiceMapper.toInvoice(invoiceDto);
       InvoiceDto responseInvoice=  invoiceMapper.toDto
               (invoiceService.updateInvoice(invoice));
    return Response.<InvoiceDto>builder().data(responseInvoice).build();
    }

    @Override
    public Response<List<InvoiceDto>> getInvoicesByState(InvoiceState invoiceState) {
        Long userId = Context.getCurrentUser().getUserId();

        List<InvoiceDto> invoicesDto =invoiceMapper.toInvoiceDtoList( invoiceService.getInvoicesByStatus(invoiceState.toString(),userId));

        return Response.<List<InvoiceDto>>builder().data(invoicesDto).build();
    }






}
