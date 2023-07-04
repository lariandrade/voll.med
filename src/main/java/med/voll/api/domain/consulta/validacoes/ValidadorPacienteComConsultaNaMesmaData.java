package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteComConsultaNaMesmaData {

    //Não permitir o agendamento de mais de uma consulta no mesmo dia para um mesmo paciente

    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
      var primeiroHorario = dados.data().withHour(7);
      var ultimoHorario = dados.data().withHour(18);
      var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
      if (pacientePossuiOutraConsultaNoDia) {
          throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
      }


    }
}
