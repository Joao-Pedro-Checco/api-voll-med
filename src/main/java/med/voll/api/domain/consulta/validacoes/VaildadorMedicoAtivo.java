package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VaildadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }
        var medicoAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoAtivo) {
            throw new ValidacaoException("Não é permitido marcar consultas com médicos inativos!");
        }
    }
}
