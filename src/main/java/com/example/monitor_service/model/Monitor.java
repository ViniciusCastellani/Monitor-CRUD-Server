package com.example.monitor_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Monitor {
    private int id;
    private String nome;
    private String tipo;
    private float tamanho;
    private float preco;
}
