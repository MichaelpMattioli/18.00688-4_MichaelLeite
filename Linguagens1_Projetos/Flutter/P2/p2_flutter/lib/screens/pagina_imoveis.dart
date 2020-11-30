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
                    padding: const EdgeInsets.all(8.0),
                    child: Text(widget._imoveisList[index].rua),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text(widget._imoveisList[index].bairro + ", " + widget._imoveisList[index].cidade,),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      children: [
                        RichText(
                            text: TextSpan(
                              children: [
                                TextSpan(
                                  text: widget._imoveisList[index].planta.metragem.toString(),
                                )
                                WidgetSpan(
                                    child: )
                              ]
                            ))
                        Text(widget._imoveisList[index].planta.dorms.toString(),)
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("Preco: " + widget._imoveisList[index].planta.preco.toString()),
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

  String stringPreco(int index){
    var _preco;
    try{
      _preco = widget._imoveisList[index].planta.preco.toString();
    }catch(e){
      _preco = "-";
    }

    return _preco;
  }

  String stringDormitorios(int index){
    var _dormits;
    try{
      _dormits = widget._imoveisList[index].planta.dorms.toString();
    }catch(e){
      _dormits = "-";
    }

    return _dormits;
  }
}

