import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TelaInicial extends StatelessWidget {

  final controlador = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            Expanded(child: SizedBox(width:200, height: 100, child: Image.asset("assets/Logo/LogoImovel.png")))
          ],
        ),
      ),
    );
  }
}
