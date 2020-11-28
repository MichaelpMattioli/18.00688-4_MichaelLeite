import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TelaInicial extends StatelessWidget {

  final controladorCidade = TextEditingController();
  final controladorBairro = TextEditingController();
  final controladorValorMax = TextEditingController();
  final controladorDorms = TextEditingController();

  final controlador = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(width:400, height: 200, child: Image.asset("assets/Logo/LogoImovel.png")),
              Text("Procure seu imovel!",
                  style: TextStyle(fontSize: 20.0)),
              personalTextField(controladorCidade, "Cidade de interesse","Cidade" , Icon(Icons.location_city)),
              personalTextField(controladorBairro, "Bairro de interesse","Bairro", Icon(Icons.park)),
              personalTextField(controladorValorMax, "Valor máximo de interesse", "Valor até", Icon(Icons.monetization_on_outlined)),
              personalTextField(controladorDorms, "Quantidade de dormitórios", "Dormitórios", Icon(Icons.home)),
              FlatButton(onPressed: (){

              }, child: Text("Buscar",
                style: TextStyle(fontSize: 20.0),
              ))
            ],
          ),
        ),
      ),
    );
  }

  personalTextField(TextEditingController controlador, String hint, String label, Icon icone) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: TextField(controller: controlador, decoration: InputDecoration(
          hintText: hint,
          labelText: label,
          icon: icone
      ),),
    );
  }
}
