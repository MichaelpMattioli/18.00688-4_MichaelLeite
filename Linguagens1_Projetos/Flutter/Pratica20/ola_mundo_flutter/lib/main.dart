import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MinhaTela(),
    );
  }
}

class MinhaTela extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Meu App Flutter"),),
      body: Column(
        children: [
          Text("Me ajude com suas energias!"),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Image.network("https://www.comboinfinito.com.br/principal/wp-content/uploads/2017/09/genki-dama-dragon-ball-super.jpg"),
          ),
          Expanded(
            child: Row(
              children: [
                Expanded(child: Image.network("https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png", fit: BoxFit.contain)),
                Expanded(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      _minha_linha_personalidade("https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png","Michael Pedroza Mattioli Leite"),
                      _minha_linha_personalidade("https://assets.pokemon.com/assets/cms2/img/pokedex/full/152.png","https://github.com/MichaelpMattioli/18.00688-4_MichaelLeite")
                    ],
                  ),
                )
              ],
            ),
          ),
          Expanded(child: Image.asset("assets/qr_code.png"))

        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          print("Ola Devs!!");
        },
        child: Icon(Icons.accessibility_sharp),
      ),
    );
  }

  _minha_linha_personalidade(String imagem, String texto) {
    return Row(
      children: [
        Expanded(child: Image.network(imagem,fit: BoxFit.contain)),
        Expanded(child: Text(texto))
      ],
    );
  }
}
