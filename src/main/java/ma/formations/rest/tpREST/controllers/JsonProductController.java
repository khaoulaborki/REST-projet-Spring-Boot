package ma.formations.rest.tpREST.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.formations.rest.tpREST.entities.Product;
import ma.formations.rest.tpREST.services.ProductService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/products/json")
@RequiredArgsConstructor
public class JsonProductController {

    private final ProductService service;

    // 🔹 Récupérer tous les produits
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        return service.getAll();
    }

    // 🔹 Récupérer un produit par ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Product product = service.getById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            log.warn("Produit avec l'id {} introuvable", id);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Produit avec l'id " + id + " est introuvable !");
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    // 🔹 Ajouter un produit
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Product product) {
        Product saved = service.save(product);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produit ajouté avec succès !");
        response.put("product", saved);
        return ResponseEntity.ok(response);
    }

    // 🔹 Mettre à jour un produit
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Product product) {
        Product updated = service.update(id, product);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produit mis à jour avec succès !");
        response.put("product", updated);
        return ResponseEntity.ok(response);
    }

    // 🔹 Supprimer un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Produit supprimé avec succès !");
        return ResponseEntity.ok(response);
    }
}
