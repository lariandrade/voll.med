package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    //Não permitir o agendamento de consultas com médicos inativos no sistema

    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        //escolha do medico é opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com medico inativo.");
        }


    }
}
