package com.izibiz.api.utils;

import com.izibiz.api.dto.InvoiceDto;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

@Component
public class XmlUtil {

    public void convertInvoiceToXml(InvoiceDto invoiceDto) throws JAXBException, IOException {

        try {

            JAXBContext context = JAXBContext.newInstance(InvoiceDto.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(invoiceDto, new File("D://InvoiceXmlSamples/" + invoiceDto.getUuid() + ".xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
