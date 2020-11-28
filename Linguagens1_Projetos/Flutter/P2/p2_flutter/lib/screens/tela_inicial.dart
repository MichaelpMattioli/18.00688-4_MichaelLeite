import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TelaInicial extends StatelessWidget {

  final controlador = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: SizedBox(width:400, height: 200, child: Image.asset("assets/Logo/LogoImovel.png")),
            ),
            Text("Procure seu imovel!"),
            
          ],
        ),
      ),
    );
  }
}
