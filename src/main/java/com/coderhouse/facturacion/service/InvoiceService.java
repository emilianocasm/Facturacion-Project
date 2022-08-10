package com.coderhouse.facturacion.service;
import com.coderhouse.facturacion.entity.Invoice;
import com.coderhouse.facturacion.model.SaleRequestDTO;
import com.coderhouse.facturacion.repository.IInvoiceRepository;
import com.coderhouse.facturacion.service.worldClockApi.WorldClockApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class InvoiceService {

    @Autowired
    private IInvoiceRepository iInvoiceRepository;

    @Autowired
    private WorldClockApiService worldClockApiService;

    public Invoice createInvoice(Invoice invoice){
        return iInvoiceRepository.save(invoice);
    }

    public Invoice buildInvoice(SaleRequestDTO saleRequestDTO){
        AtomicReference<Float> totalPriceInvoice = new AtomicReference<>(0.0f);
        AtomicReference<Integer> totalStockInvoice = new AtomicReference<>(0);

        Invoice invoice = this.createInvoice(new Invoice());

        saleRequestDTO.getDetailSale().forEach(detailSale -> {
            detailSale.setId_invoice(invoice.getId_invoice());
            totalPriceInvoice.getAndUpdate(value -> detailSale.getPrice() + value);
            totalStockInvoice.getAndUpdate(value -> detailSale.getStock() + value);
        });

        invoice.setDate(worldClockApiService.getDate());

        invoice.setId_cliente(saleRequestDTO.getUserId());
        invoice.setTotal(totalPriceInvoice.get());
        invoice.setStock(totalStockInvoice.get());

        return this.updateInvoice(invoice.getId_invoice(), invoice);
    }

    public Invoice updateInvoice(Integer id, Invoice invoice){
        Invoice searchInvoice = iInvoiceRepository.findById(id)
                .orElse(null);
        if (searchInvoice == null){
            throw new RuntimeException("La factura no existe");
        }
        searchInvoice.setDate(invoice.getDate());
        searchInvoice.setStock(invoice.getStock());
        searchInvoice.setTotal(invoice.getTotal());
        searchInvoice.setId_cliente(invoice.getId_cliente());
        return iInvoiceRepository.save(searchInvoice);
    }


    public Integer getLastRecord(){
        return iInvoiceRepository.getLastRecord();
    }
}
