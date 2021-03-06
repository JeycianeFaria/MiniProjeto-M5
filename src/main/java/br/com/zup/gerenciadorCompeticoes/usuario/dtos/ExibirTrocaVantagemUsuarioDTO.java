package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

import br.com.zup.gerenciadorCompeticoes.voucher.dtos.VoucherDTO;

import java.util.List;

public class ExibirTrocaVantagemUsuarioDTO {

    private String email;
    private int pontos;
    private List<VoucherDTO> vouchers;


    public ExibirTrocaVantagemUsuarioDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<VoucherDTO> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<VoucherDTO> vouchers) {
        this.vouchers = vouchers;
    }

}
