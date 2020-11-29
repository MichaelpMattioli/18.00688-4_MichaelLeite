import 'package:flutter/material.dart';
import 'package:p2_flutter/models/imoveis_json.dart';

class PaginaImoveis extends StatefulWidget {
  List imoveis;


  PaginaImoveis(var dados){
    this.imoveis = dados;
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
                  itemCount: widget.imoveis.length,
                  itemBuilder: (context, index) {
                    return buildContainer(index);
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
                  Text("Cidade: " + widget.imoveis[index].cidade),
                  Text("Bairro: " + widget.imoveis[index].bairro),
                  Text("Preço: " + stringPreco(index)),
                  Text("Dormitórios: " + stringDormitorios(index))
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
      imagem = Image.network(widget.imoveis[index].fachada);
    }catch(e){
      imagem = Image.network("https://radioingamar.com.br/portal/img/not-found.png");
    }
    return imagem;
  }

  String stringPreco(int index){
    var preco;
    try{
      preco = widget.imoveis[index].planta.preco.toString();
    }catch(e){
      preco = "-";
    }

    return preco;
  }

  String stringDormitorios(int index){
    var dormits;
    try{
      dormits = widget.imoveis[index].planta.dorms.toString();
    }catch(e){
      dormits = "-";
    }

    return dormits;
  }
}

