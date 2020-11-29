import 'package:flutter/material.dart';
import 'package:p2_flutter/models/imoveis_json.dart';
import 'package:p2_flutter/screens/imovel_infos.dart';

class PaginaImoveis extends StatefulWidget {
  List imoveisList;


  PaginaImoveis(var dados){
    this.imoveisList = dados;
  }

  @override
  _PaginaImoveisState createState() => _PaginaImoveisState();
}

class _PaginaImoveisState extends State<PaginaImoveis> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            Expanded(
                child: ListView.builder(
                  itemCount: widget.imoveisList.length,
                  itemBuilder: (context, index) {
                    return GestureDetector(
                      child: buildContainer(index),
                      onDoubleTap: (){
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (BuildContext context) =>
                                    ImovelInfos(widget.imoveisList[index])));
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
                    child: Text("Cidade: " + widget.imoveisList[index].cidade),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("Bairro: " + widget.imoveisList[index].bairro),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("Preço: " + stringPreco(index)),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("Dormitórios: " + stringDormitorios(index)),
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
    var imagem;
    try{
      imagem = Image.network(widget.imoveisList[index].fachada);
    }catch(e){
      imagem = Image.network("https://radioingamar.com.br/portal/img/not-found.png");
    }
    return imagem;
  }

  String stringPreco(int index){
    var preco;
    try{
      preco = widget.imoveisList[index].planta.preco.toString();
    }catch(e){
      preco = "-";
    }

    return preco;
  }

  String stringDormitorios(int index){
    var dormits;
    try{
      dormits = widget.imoveisList[index].planta.dorms.toString();
    }catch(e){
      dormits = "-";
    }

    return dormits;
  }
}

