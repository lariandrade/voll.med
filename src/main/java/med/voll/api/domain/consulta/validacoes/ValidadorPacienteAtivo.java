package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    //Não permitir o agendamento de consultas com pacientes inativos no sistema

    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo.");
        }


    }

}
