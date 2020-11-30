import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:p2_flutter/models/imoveis_json.dart';

class ImovelInfos extends StatelessWidget {

  Imovel imovel = new Imovel();

  ImovelInfos(Imovel imovel){
    this.imovel = imovel;
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(title: Text("Voltar"),),
        backgroundColor: Colors.blueGrey[100],
        body: Column(
          children: [
            Expanded(
              child: ListView(
                children: [
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 8.0, 8.0, 0.0),
                    child: Container(
                      color: Colors.blue[100],
                      child: SizedBox(
                        width: 200,
                        height: 500,
                        child: Image.network(imovel.fachada),
                      )
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                      color: Colors.blue[100],
                      child: Row(
                        children: [
                          Expanded(
                            child: Column(
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Nome: ${imovel.nome}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Preço: ${tratamentoVarPreco()}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text(" Dormitorios: ${tratamentoVarDorms()}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Vagas: ${tratamentoVarVagas()}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Metragem: ${tratamentoVarMetragem()}"),
                                ),
                              ],
                            ),
                          ),
                          Expanded(
                            child: Column(
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Rua: ${imovel.rua}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Número: ${imovel.num}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Bairro: ${imovel.bairro}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Cidade: ${imovel.cidade}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("CEP: ${imovel.cep}"),
                                ),
                              ],
                            ),
                          )
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),

          ],
        ),
      ),
    );
  }

  String tratamentoVarPreco(){
    var _preco;
    try{
      _preco = imovel.planta.preco.toString();
    }catch(e){
      _preco = "-";
    }
    return _preco;
  }

  String tratamentoVarMetragem(){
    var _metragem;
    try{
      _metragem = imovel.planta.metragem.toString();
    }catch(e){
      _metragem = "-";
    }
    return _metragem;
  }

  String tratamentoVarDorms(){
    var _dormits;
    try{
      _dormits = imovel.planta.dorms.toString();
    }catch(e){
      _dormits = "-";
    }
    return _dormits;
  }

  String tratamentoVarVagas(){
    var _dormits;
    try{
      _dormits = imovel.planta.dorms.toString();
    }catch(e){
      _dormits = "-";
    }
    return _dormits;
  }
}
