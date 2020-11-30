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
        backgroundColor: Colors.blueGrey[50],
        body: Padding(
            padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(width:400, height: 150, child: Image.asset("assets/Logo/LogoImovel.png")),
              Container(
                margin: EdgeInsets.all(15.0),
                child: Text("Procure seu imovel no ABC paulista!",
                    style: TextStyle(fontSize: 20.0)),
              ),
              personalTextField(controladorCidade, "Cidade de interesse","Cidade" , Icon(Icons.location_city)),
              personalTextField(controladorBairro, "Bairro de interesse","Bairro", Icon(Icons.park)),
              personalTextField(controladorValorMax, "Valor máximo de interesse", "Valor até", Icon(Icons.monetization_on_outlined)),
              personalTextField(controladorDorms, "Quantidade de dormitórios", "Dormitórios", Icon(Icons.home)),
              Container(
                decoration: BoxDecoration(
                  color: Colors.blue[700],
                  shape: BoxShape.circle
                ),
                margin: EdgeInsets.all(25.0),
                padding: EdgeInsets.all(25.0),
                child: FlatButton(onPressed: () async{
                  await buscar_caracteristicas_imovel();
                  if (_busca.length == 0) {
                  }
                  else {
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (BuildContext context) =>
                                PaginaImoveis(_busca)));
                  }
                    }, child: Text("Buscar",
                  style: TextStyle(fontSize: 20.0),
                )),
              )
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

    _busca = [];
    var count = 0;

    for ( var entrada in _dados){
      Imovel _imovelAtual = entrada;
      int _verification = 0;
      int countBlank = 0;

      if(_imovelAtual.cidade == controladorCidade.text){
        _verification++;
      }
      if(controladorCidade.text.isEmpty){
        countBlank++;
      }

      if(_imovelAtual.bairro == controladorBairro.text){
        _verification++;
      }
      if(controladorBairro.text.isEmpty){
        countBlank++;
      }

      try{
        try{
          var plantaVerification = _imovelAtual.planta.preco;
        }catch(e){
          continue;
        }
        if(_imovelAtual.planta.preco < double.parse(controladorValorMax.text) && !controladorValorMax.text.isEmpty){
          _verification++;
        }
        if(controladorValorMax.text.isEmpty){
          countBlank++;
        }
      }catch(e){
        count++;
        countBlank++;
      }

      try{
        try{
          var plantaVerification = _imovelAtual.planta.dorms;
        }catch(e){
          continue;
        }

        if(_imovelAtual.planta.dorms == double.parse(controladorDorms.text)){
          _verification++;
        }
        if(controladorDorms.text.isEmpty){
          countBlank++;
        }
      }catch(e){
        count++;
        countBlank++;
      }

      int totalCampos = 4 - countBlank;

      if ( _verification == totalCampos){
        _busca.add(_imovelAtual);
      }
    }

  }

}



