import 'package:flutter/material.dart';

class MinhaPaginaInicial extends StatelessWidget {
  var _dados = "";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Minhas Requisições"),),
      body: Text(_dados),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.send),
        onPressed: () async{
        },
      ),
    );
  }
}
