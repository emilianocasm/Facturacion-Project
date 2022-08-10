package com.coderhouse.facturacion.service;
import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.entity.Product;
import com.coderhouse.facturacion.entity.Sale;
import com.coderhouse.facturacion.model.ClientSearch;
import com.coderhouse.facturacion.model.SaleRequestDTO;
import com.coderhouse.facturacion.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository iProductRepository;

    public List<Product> getProduct(){
        return iProductRepository.findAll();
    }

    public Product getProductById(Integer productId){
        Product product = iProductRepository.findById(productId).orElse(null);
        if (product == null){
            throw new RuntimeException("El producto no existe");
        }
        return product;
    }

    public Product createProduct(Product product){
        return iProductRepository.save(product);
    }

    public void updateStock(SaleRequestDTO saleRequestDTO){
        saleRequestDTO.getDetailSale().forEach(detailSale -> {
            Product searchedProduct = this.getProductById(detailSale.getId_product());
            searchedProduct = this.validateStock(searchedProduct, detailSale);
            this.updateProduct(detailSale.getId_product(), searchedProduct);
        });
    }

    private Product validateStock(Product searchedProduct, Sale detailSale){
        if (searchedProduct.getStock() < detailSale.getStock()){
            throw new RuntimeException("No hay suficientes " + detailSale.getDescription() + " para la cantidad requerida");
        }
        searchedProduct.setStock(searchedProduct.getStock() - detailSale.getStock());
        return searchedProduct;
    }

    public Product updateProduct(Integer id, Product product) {
        Product searchProduct = iProductRepository.findById(id)
                .orElse(null);
        if (searchProduct == null){
            throw new RuntimeException("El producto no existe");
        }
        if (product.getDescription() != null){
            searchProduct.setDescription(product.getDescription());
        }
        if (product.getStock() != null){
            searchProduct.setStock(product.getStock());
        }
        if (product.getDescription() != null){
            searchProduct.setPrice(product.getPrice());
        }
        return iProductRepository.save(searchProduct);
    }

    public void deleteProducto(Integer id) {
        Product searchProduct = iProductRepository.findById(id)
                .orElse(null);
        if (searchProduct == null){
            throw new RuntimeException("El producto no existe");
        }
        iProductRepository.deleteById(id);
    }
}
