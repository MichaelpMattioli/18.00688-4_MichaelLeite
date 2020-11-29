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
        backgroundColor: Colors.blueGrey[100],
        body: Column(
          children: [
            Expanded(
              child: ListView(
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: SizedBox(width: 200, height: 500, child: Image.network(imovel.fachada),),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                      color: Colors.blueGrey,
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
                                  child: Text("Preço: ${imovel.planta.preco}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text(" Dormitorios: ${imovel.planta.dorms}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Vagas: ${imovel.planta.vagas}"),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Text("Metragem: ${imovel.planta.metragem}"),
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
                  FlatButton(onPressed: (){
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (BuildContext context) =>
                                PaginaImoveis(_busca)));
                  }, child: Text("Procurar no Google Maps"))
                ],
              ),
            ),

          ],
        ),
      ),
    );
  }
}
