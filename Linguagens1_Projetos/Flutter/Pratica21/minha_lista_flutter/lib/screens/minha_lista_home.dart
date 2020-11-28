
import 'package:flutter/material.dart';
import 'package:minha_lista_flutter/models/MyHero.dart';

class MinhaListaHome extends StatelessWidget {
  final _myHeroList = [
    MyHero("All Might", "One for All", "https://static.tvtropes.org/pmwiki/pub/images/all_might_hero_form_full_body_9.png"),
    MyHero("Midora", "One for All", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRofigl23HEauIkhj6-lYXByI0GWi0IxMP5vA&usqp=CAU"),
    MyHero("Baguko", "Explosao", "https://www.dailydot.com/wp-content/uploads/2018/09/best_my_hero_academia_characters_bakugo.jpg")
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: ListView(
          children: [
            ListTile(title: Text(_myHeroList[0].nome), subtitle: Text(_myHeroList[0].singularidade),
                leading: Image.network(_myHeroList[0].image)),
            ListTile(title: Text(_myHeroList[1].nome), subtitle: Text(_myHeroList[1].singularidade),
              leading: Image.network(_myHeroList[1].image),),
            ListTile(title: Text(_myHeroList[2].nome), subtitle: Text(_myHeroList[2].singularidade),
              leading: Image.network(_myHeroList[2].image),),
          ],
        ),
    );
  }
}

class MinhaListaHome2 extends StatelessWidget {
  final _myHeroList = [
    MyHero("All Might", "One for All", "https://static.tvtropes.org/pmwiki/pub/images/all_might_hero_form_full_body_9.png"),
    MyHero("Midora", "One for All", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRofigl23HEauIkhj6-lYXByI0GWi0IxMP5vA&usqp=CAU"),
    MyHero("Baguko", "Explosao", "https://www.dailydot.com/wp-content/uploads/2018/09/best_my_hero_academia_characters_bakugo.jpg"),
    MyHero("Ochako", "Zero Gravity", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3eCqnlvK5J6iieffqsUTehLCl4E_YjXTgGQ&usqp=CAU")
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
          itemBuilder: (context, index){
            return ListTile(
              title: Text(_myHeroList[index].nome),
              subtitle: Text(_myHeroList[index].singularidade),
              leading: Image.network(_myHeroList[index].image),
            );
          },
          itemCount: _myHeroList.length,
      )
    );
  }
}

class MinhaListaHome3 extends StatefulWidget {
  @override
  _MinhaListaHome3State createState() => _MinhaListaHome3State();
}

class _MinhaListaHome3State extends State<MinhaListaHome3> {
  final _myHeroList = [
    MyHero("All Might", "One for All", "https://static.tvtropes.org/pmwiki/pub/images/all_might_hero_form_full_body_9.png"),
    MyHero("Midora", "One for All", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRofigl23HEauIkhj6-lYXByI0GWi0IxMP5vA&usqp=CAU"),
    MyHero("Baguko", "Explosao", "https://www.dailydot.com/wp-content/uploads/2018/09/best_my_hero_academia_characters_bakugo.jpg"),
    MyHero("Ochako", "Zero Gravity", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3eCqnlvK5J6iieffqsUTehLCl4E_YjXTgGQ&usqp=CAU")
  ];

  final controladorNome = TextEditingController();

  final controladorSingularidade = TextEditingController();

  final controladorUrlImage = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
          body: Column(
            children: [
              SizedBox(width:200, height: 100, child: Image.network("https://i.pinimg.com/originals/4c/67/51/4c67516ab6bf8f6ebda56b8bfb064d41.png")),
              meuTextFieldPersonalizado(controladorNome, "Informe o nome do heroi", "Nome", Icon(Icons.drive_file_rename_outline)),
              meuTextFieldPersonalizado(controladorSingularidade, "Informe a singularidade do heroi", "Singularidade", Icon(Icons.ac_unit_outlined)),
              meuTextFieldPersonalizado(controladorUrlImage, "URL imagem", "URL Imagem", Icon(Icons.image)),
              FlatButton(onPressed: (){
                adicionar_novo_registro();
              }, child: Text("Adicionar")),
              Expanded(
                child: ListView.builder(
                  itemBuilder: (context, index){
                    return ListTile(
                      title: Text(_myHeroList[index].nome),
                      subtitle: Text(_myHeroList[index].singularidade),
                      leading: Image.network(_myHeroList[index].image),
                    );
                  },
                  itemCount: _myHeroList.length,
                ),
              )
            ],
          )
      ),
    );
  }

  Widget meuTextFieldPersonalizado(TextEditingController controlador, String hint, String label, Icon icone) {
    return Padding(
              padding: const EdgeInsets.all(8.0),
              child: TextField(controller: controlador, decoration: InputDecoration(
                hintText: hint, // texto informativo que some ao digitar
                labelText: label, // mini titulo
                icon: icone // Coloca um aviso que entrou no field
              ),),
            );
  }

  void adicionar_novo_registro(){
    setState(() {
      _myHeroList.add(MyHero(controladorNome.text, controladorSingularidade.text, controladorUrlImage.text));
      print(_myHeroList);
    });
  }
}


