package com.agrotienda.tienda_agropecuaria.controller;

import com.agrotienda.tienda_agropecuaria.model.Producto;
import com.agrotienda.tienda_agropecuaria.repository.ProductoRepository;
import com.agrotienda.tienda_agropecuaria.service.CotizacionService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final CotizacionService cotizacionService;
    private final MeterRegistry meterRegistry;

    public ProductoController(ProductoRepository productoRepository, 
                              CotizacionService cotizacionService, 
                              MeterRegistry meterRegistry) {
        this.productoRepository = productoRepository;
        this.cotizacionService = cotizacionService;
        this.meterRegistry = meterRegistry;
    }

    // 1. Obtener todos los productos e incrementar la métrica
    @GetMapping
    public List<Producto> obtenerTodos() {
        meterRegistry.counter("agrotienda.productos.consultas.total").increment();
        return productoRepository.findAll();
    }

    // 2. Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // 3. Endpoint para cotizar un producto en USD usando el servicio
    @GetMapping("/{id}/precio-usd")
    public ResponseEntity<Map<String, Object>> obtenerPrecioUSD(@PathVariable Long id) {
        return productoRepository.findById(id).map(producto -> {
            double tasa = cotizacionService.obtenerTasaUsdCop();
            double precioUSD = producto.getPrecio() / tasa;

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("id", producto.getId());
            respuesta.put("producto", producto.getNombre());
            respuesta.put("precioCOP", producto.getPrecio());
            respuesta.put("precioUSD", precioUSD);
            respuesta.put("tasaUsdCop", tasa);

            return ResponseEntity.ok(respuesta);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
