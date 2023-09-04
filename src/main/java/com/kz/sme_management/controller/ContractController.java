package com.kz.sme_management.controller;

import com.kz.sme_management.model.contract.Contract;
import com.kz.sme_management.service.contract.ContractDTO;
import com.kz.sme_management.service.contract.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("${PATH_CONTRACTS}")
@Tag(name = "Products", description = "Product Management APIs")
public class ContractController {

    private final ContractService contractService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get contracts")
    public Page<Contract> getProducts(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") @Valid int size,
                                      @RequestParam(defaultValue = "id") String sort,
                                      @RequestParam(defaultValue = "asc") String direction,
                                      @RequestParam Map<String, String> parameters) {

        parameters.remove("page");
        parameters.remove("size");
        parameters.remove("sort");
        parameters.remove("direction");

        return contractService.findAll(parameters, page, size, direction, sort.split(","));
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Contract by id")
    public Contract getContractById(@PathVariable String id) {
        return contractService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Contract> createEntity(@RequestBody ContractDTO contractDTO) {
        Contract newEntity = contractService.save(contractDTO);
        log.info("New contract created with id: {}", newEntity.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }


}