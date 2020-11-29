import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:p2_flutter/models/imoveis_json.dart';
import 'package:p2_flutter/screens/pagina_imoveis.dart';
import 'package:p2_flutter/utilities/network_helper.dart';

class TelaInicial extends StatelessWidget {

  final controladorCidade = TextEditingController();
  final controladorBairro = TextEditingController();
  final controladorValorMax = TextEditingController();
  final controladorDorms = TextEditingController();

  var _busca = [];

  final controlador = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        resizeToAvoidBottomInset: false,
        body: Padding(
            padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(width:400, height: 200, child: Image.asset("assets/Logo/LogoImovel.png")),
              Text("Procure seu imovel no ABC paulista!",
                  style: TextStyle(fontSize: 20.0)),
              personalTextField(controladorCidade, "Cidade de interesse","Cidade" , Icon(Icons.location_city)),
              personalTextField(controladorBairro, "Bairro de interesse","Bairro", Icon(Icons.park)),
              personalTextField(controladorValorMax, "Valor máximo de interesse", "Valor até", Icon(Icons.monetization_on_outlined)),
              personalTextField(controladorDorms, "Quantidade de dormitórios", "Dormitórios", Icon(Icons.home)),
              FlatButton(onPressed: () async{
                await buscar_caracteristicas_imovel();
                print(_busca);
                if(_busca.length != 0) {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (BuildContext context) =>
                                  PaginaImoveis(_busca)));
                    }
                  }, child: Text("Buscar",
                style: TextStyle(fontSize: 20.0),
              ))
            ],
          ),
        ),
      ),
    );
  }

  personalTextField(TextEditingController controlador, String hint, String label, Icon icone) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: TextField(controller: controlador, decoration: InputDecoration(
          hintText: hint,
          labelText: label,
          icon: icone
      ),),
    );
  }

  Future<void> buscar_caracteristicas_imovel()async{
    var _requisicao = NetworkHelper(url: "https://api.estagio.amfernandes.com.br/imoveis");
    var _dados = [];

    for (var entrada in await _requisicao.getData()){
      try {
        _dados.add(Imovel.fromJson(entrada));
      } catch(e) {
      }
    }

    for ( var entrada in _dados){
      Imovel imovelAtual = entrada;

      if(imovelAtual.cidade == controladorCidade.text && controladorCidade.text != ""){
        _busca.add(imovelAtual);
      }
      if(imovelAtual.bairro != controladorBairro.text && controladorBairro.text != ""){
        _busca.remove(imovelAtual);
      }

      try{
        if(imovelAtual.planta.preco > double.parse(controladorValorMax.text) && controladorBairro.text != ""){
          _busca.remove(imovelAtual);
        }
      }catch(e){
        if(imovelAtual.bairro != controladorBairro.text && controladorBairro.text != ""){
          _busca.remove(imovelAtual);
        }
      }

      try{
        if(imovelAtual.planta.dorms > double.parse(controladorDorms.text) && controladorBairro.text != ""){
          _busca.remove(imovelAtual);
        }
      }catch(e){}
    }

    print(_dados.length);
    print(_busca.length);

  }
}



