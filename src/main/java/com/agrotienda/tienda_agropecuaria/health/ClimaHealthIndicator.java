package com.agrotienda.tienda_agropecuaria.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ClimaHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean servicioDisponible = comprobarConexionServicio();

        if (servicioDisponible) {
            return Health.up()
                    .withDetail("Servicio Cotizaciones/Clima", "Operativo y disponible")
                    .withDetail("Proveedor Externe", "open.er-api.com")
                    .build();
        }

        return Health.down()
                .withDetail("Servicio Cotizaciones/Clima", "No disponible - Se activa respuesta Fallback")
                .build();
    }

    private boolean comprobarConexionServicio() {
        // Simula la verificación de conectividad con el servicio externo
        return true;
    }
}
