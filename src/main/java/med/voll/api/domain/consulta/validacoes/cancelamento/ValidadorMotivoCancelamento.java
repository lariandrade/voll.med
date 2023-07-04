package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMotivoCancelamento implements ValidadorCancelamentoDeConsulta {

    //É obrigatório informar o motivo do cancelamento da consulta

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        if(dados.motivo() == null){
            throw new ValidacaoException("Informe o motivo de cancelamento");
        }
    }
}
