package vboot.web.model;

import lombok.Data;

// 发票实体类
// Entidade de Nota Fiscal
@Data
public class NotaFiscal {

    // 发票编号
    // Número da nota fiscal
    private String numero;

    // 发票系列
    // Série da nota fiscal
    private String serie;

    // 发票类型（例如：saida，entrada）
    // Tipo da nota fiscal (ex: saída, entrada)
    private String tipo;

    // 发票总金额
    // Valor total da nota fiscal
    private Double valorTotal;

    // 发票发出方信息
    // Informações do emitente
    private String emitente;

    // 发票接收方信息
    // Informações do destinatário
    private String destinatario;

    // 产品列表（简化）
    // Lista de produtos (simples)
    private String produtos;

    // 发票XML字符串（可选）
    // XML da nota (opcional)
    private String xmlGerado;
}
