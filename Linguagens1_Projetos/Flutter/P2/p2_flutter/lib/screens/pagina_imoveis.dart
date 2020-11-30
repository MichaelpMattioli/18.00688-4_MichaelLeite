import 'package:flutter/material.dart';
import 'package:p2_flutter/models/imoveis_json.dart';
import 'package:p2_flutter/screens/imovel_infos.dart';

class PaginaImoveis extends StatefulWidget {
  List _imoveisList;


  PaginaImoveis(var dados){
    this._imoveisList = dados;
  }

  @override
  _PaginaImoveisState createState() => _PaginaImoveisState();
}

class _PaginaImoveisState extends State<PaginaImoveis> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(title: Text("Resultados encontrados: ${widget._imoveisList.length}")),
        body: Column(
          children: [
            Expanded(
                child: ListView.builder(
                  itemCount: widget._imoveisList.length,
                  itemBuilder: (context, index) {
                    return GestureDetector(
                      child: buildContainer(index),
                      onDoubleTap: (){
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (BuildContext context) =>
                                    ImovelInfos(widget._imoveisList[index])));
                      },
                    );
                  },
                )
            )
          ],
        ),
      ),
    );
  }

  Container buildContainer(int index) {
    return Container(
      child: Card(
        child: Row(
          children: [
            Container(
              child: SizedBox(width: 150, height: 200, child: imageBuilder(index)),
              color: Colors.grey[300],
            ),
            Expanded(
              child: Column(
                children: [
                  Padding(
                    padding: const EdgeInsets.fromLTRB(16.0, 0.0, 8.0, 0.0),
                    child: Align(
                      alignment: Alignment.centerLeft,
                        child: Text(
                          widget._imoveisList[index].rua,
                          style: TextStyle(
                              fontWeight: FontWeight.bold),
                        )
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(16.0, 8.0, 8.0, 8.0),
                    child: Align(
                        alignment: Alignment.centerLeft,
                        child: Text(widget._imoveisList[index].bairro + ", " + widget._imoveisList[index].cidade,)),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(11.5, 0.0, 8.0, 8.0),
                    child: Row(
                      children: [
                        RichText(
                            text: TextSpan(
                              style: Theme.of(context).textTheme.bodyText2,
                              children: [
                                WidgetSpan(
                                    child: Icon(Icons.architecture)
                                ),
                                TextSpan(
                                  text: " " + tratamentoVarMetragem(index) + " m²    ",
                                ),
                              ]
                            )
                        ),
                        RichText(
                            text: TextSpan(
                                style: Theme.of(context).textTheme.bodyText2,
                                children: [
                                  WidgetSpan(
                                      child: Icon(Icons.airline_seat_individual_suite_outlined)
                                  ),
                                  TextSpan(
                                    text: "  " + tratamentoVarDorms(index) + " quartos",
                                  ),
                                ]
                            )
                        )
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(16.0, 8.0, 8.0, 0.0),
                    child: Align(
                        alignment: Alignment.centerLeft,
                        child: Text(
                          "Preco: " + tratamentoVarPreco(index),
                          style: TextStyle(
                            color: Colors.green[900],
                            fontWeight: FontWeight.bold,
                            fontSize: 17.0,
                          ),
                        ),
                    ),
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Image imageBuilder(int index) {
    var _imagem;
    try{
      _imagem = Image.network(widget._imoveisList[index].fachada);
    }catch(e){
      _imagem = Image.asset("assets/Logo/imagemNaoEncotrada.png");
    }
    return _imagem;
  }

  String tratamentoVarPreco(int index){
    var _preco;
    try{
      _preco = widget._imoveisList[index].planta.preco.toString();
    }catch(e){
      _preco = "-";
    }
    return _preco;
  }

  String tratamentoVarMetragem(int index){
    var _metragem;
    try{
      _metragem = widget._imoveisList[index].planta.metragem.toString();
    }catch(e){
      _metragem = "-";
    }
    return _metragem;
  }

  String tratamentoVarDorms(int index){
    var _dormits;
    try{
      _dormits = widget._imoveisList[index].planta.dorms.toString();
    }catch(e){
      _dormits = "-";
    }
    return _dormits;
  }
}

