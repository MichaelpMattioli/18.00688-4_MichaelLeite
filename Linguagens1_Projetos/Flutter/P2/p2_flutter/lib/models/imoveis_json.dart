class Imovel {
  String bairro;
  String cep;
  String cidade;
  String fachada;
  Location location;
  String nome;
  String num;
  String rua;
  Planta planta;
  Imovel(
      {this.bairro,
        this.cep,
        this.cidade,
        this.fachada,
        this.location,
        this.nome,
        this.num,
        this.rua,
        this.planta});
  Imovel.fromJson(Map<String, dynamic> json) {
    bairro = json['bairro'];
    cep = json['cep'];
    cidade = json['cidade'];
    fachada = json['fachada'];
    location = json['location'] != null
        ? new Location.fromJson(json['location'])
        : null;
    nome = json['nome'];
    num = json['num'];
    rua = json['rua'];
    planta =
    json['planta'] != null ? new Planta.fromJson(json['planta']) : null;
  }
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bairro'] = this.bairro;
    data['cep'] = this.cep;
    data['cidade'] = this.cidade;
    data['fachada'] = this.fachada;
    if (this.location != null) {
      data['location'] = this.location.toJson();
    }
    data['nome'] = this.nome;
    data['num'] = this.num;
    data['rua'] = this.rua;
    if (this.planta != null) {
      data['planta'] = this.planta.toJson();
    }
    return data;
  }



  @override
  String toString() {
    return 'MeusDados{bairro: $bairro, cep: $cep, cidade: $cidade, fachada: $fachada, location: $location, nome: $nome, num: $num, rua: $rua, planta: $planta}';
  }
}
class Location {
  double dLat;
  double dLong;
  Location({this.dLat, this.dLong});
  Location.fromJson(Map<String, dynamic> json) {
    dLat = json['_lat'];
    dLong = json['_long'];
  }
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['_lat'] = this.dLat;
    data['_long'] = this.dLong;
    return data;
  }
}
class Planta {
  int dorms;
  double metragem;
  double preco;
  int vagas;
  Planta({this.dorms, this.metragem, this.preco, this.vagas});
  Planta.fromJson(Map<String, dynamic> json) {

    try{
      dorms = json['dorms'];
    }catch(e) {
      var aux = json['dorms'];
      print(aux);
      dorms = int.parse(aux);
    }

    try{
      metragem = json['metragem'];
    }catch(e){
      int aux = json['metragem'];
      metragem = aux.toDouble();
    }

    try{
      preco = json['preco'];
    }catch(e){
      int aux = json['preco'];
      preco = aux.toDouble();
    }

    vagas = json['vagas'];

    try{
      vagas = json['vagas'];
    }catch(e){
      var aux = json['vagas'];
      vagas = int.parse(aux);
    }

  }
  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['dorms'] = this.dorms;
    data['metragem'] = this.metragem;
    data['preco'] = this.preco;
    data['vagas'] = this.vagas;
    return data;
  }
}