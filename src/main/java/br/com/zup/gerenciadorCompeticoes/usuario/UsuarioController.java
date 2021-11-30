package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoService;
import br.com.zup.gerenciadorCompeticoes.jogo.dtos.ExibirDetalheJogoDTO;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.CadastroUsuarioDTO;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.ExibirUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibirUsuarioDTO cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroRecebido) {
        Usuario usuario = usuarioService.salvarUsuario(modelMapper.map(cadastroRecebido, Usuario.class));

        return modelMapper.map(usuario, ExibirUsuarioDTO.class);
    }

    @GetMapping
    public List<ExibirDetalheJogoDTO> exibirJogos() {
        List<ExibirDetalheJogoDTO> listaDeJogos = new ArrayList<>();

        for (Jogo jogo : usuarioService.exibirTodosJogos()) {
            ExibirDetalheJogoDTO exibirDetalheJogoDTO = modelMapper.map(jogo, ExibirDetalheJogoDTO.class);
            listaDeJogos.add(exibirDetalheJogoDTO);
        }

        return listaDeJogos;
    }

    @GetMapping("/{id}")
    public Jogo exibirCadastroPorId(@PathVariable int id){
        return usuarioService.pesquisarUsuarioPorID(id);
    }

}
