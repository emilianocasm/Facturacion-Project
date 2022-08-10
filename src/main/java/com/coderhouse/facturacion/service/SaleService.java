package com.coderhouse.facturacion.service;
import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.entity.Sale;
import com.coderhouse.facturacion.entity.Invoice;
import com.coderhouse.facturacion.model.SaleRequestDTO;
import com.coderhouse.facturacion.model.SaleResponseDTO;
import com.coderhouse.facturacion.repository.IDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    IDetailsRepository iDetailsRepository;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    public List<Sale> getSales(){
        return iDetailsRepository.findAll();
    }

    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO){

        Invoice invoice = invoiceService.buildInvoice(saleRequestDTO);
        Client userInformation = clientService.getClientById(saleRequestDTO.getUserId());

        productService.updateStock(saleRequestDTO);
        iDetailsRepository.saveAll(saleRequestDTO.getDetailSale());

        return buildVoucher(invoice, userInformation, saleRequestDTO.getDetailSale());
    }

    public SaleResponseDTO buildVoucher(Invoice invoice, Client userInformation, List<Sale> saleList){
        /**
         * The buildVoucher method will generate a voucher with details.
         */
        return new SaleResponseDTO(
                invoice.getDate(),
                userInformation,
                saleList,
                invoice.getTotal());
    }

    public Sale updateSale(Integer id, Sale saleSale){
        Sale searchSale = iDetailsRepository.findById(id)
                .orElse(null);
        if (searchSale == null){
            throw new RuntimeException("La venta no existe");
        }
        searchSale.setDescription(saleSale.getDescription());
        searchSale.setStock(saleSale.getStock());
        searchSale.setPrice(saleSale.getPrice());
        searchSale.setId_invoice(saleSale.getId_invoice());
        searchSale.setId_product(saleSale.getId_product());
        return iDetailsRepository.save(searchSale);
    }

}
