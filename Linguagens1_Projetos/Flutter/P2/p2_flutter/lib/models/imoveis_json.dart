class imoveis_json {
  String _bairro;
  String _cep;
  String _cidade;
  String _fachada;
  Location _location;
  String _nome;
  String _num;
  String _rua;
  Planta _planta;

  imoveis_json(
      {String bairro,
        String cep,
        String cidade,
        String fachada,
        Location location,
        String nome,
        String num,
        String rua,
        Planta planta}) {
    this._bairro = bairro;
    this._cep = cep;
    this._cidade = cidade;
    this._fachada = fachada;
    this._location = location;
    this._nome = nome;
    this._num = num;
    this._rua = rua;
    this._planta = planta;
  }

  String get bairro => _bairro;
  set bairro(String bairro) => _bairro = bairro;
  String get cep => _cep;
  set cep(String cep) => _cep = cep;
  String get cidade => _cidade;
  set cidade(String cidade) => _cidade = cidade;
  String get fachada => _fachada;
  set fachada(String fachada) => _fachada = fachada;
  Location get location => _location;
  set location(Location location) => _location = location;
  String get nome => _nome;
  set nome(String nome) => _nome = nome;
  String get num => _num;
  set num(String num) => _num = num;
  String get rua => _rua;
  set rua(String rua) => _rua = rua;
  Planta get planta => _planta;
  set planta(Planta planta) => _planta = planta;

  imoveis_json.fromJson(Map<String, dynamic> json) {
    _bairro = json['bairro'];
    _cep = json['cep'];
    _cidade = json['cidade'];
    _fachada = json['fachada'];
    _location = json['location'] != null
        ? new Location.fromJson(json['location'])
        : null;
    _nome = json['nome'];
    _num = json['num'];
    _rua = json['rua'];
    _planta =
    json['planta'] != null ? new Planta.fromJson(json['planta']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bairro'] = this._bairro;
    data['cep'] = this._cep;
    data['cidade'] = this._cidade;
    data['fachada'] = this._fachada;
    if (this._location != null) {
      data['location'] = this._location.toJson();
    }
    data['nome'] = this._nome;
    data['num'] = this._num;
    data['rua'] = this._rua;
    if (this._planta != null) {
      data['planta'] = this._planta.toJson();
    }
    return data;
  }


}

class Location {
  double _dLat;
  double _dLong;

  Location({double dLat, double dLong}) {
    this._dLat = dLat;
    this._dLong = dLong;
  }

  double get dLat => _dLat;
  set dLat(double dLat) => _dLat = dLat;
  double get dLong => _dLong;
  set dLong(double dLong) => _dLong = dLong;

  Location.fromJson(Map<String, dynamic> json) {
    _dLat = json['_lat'];
    _dLong = json['_long'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['_lat'] = this._dLat;
    data['_long'] = this._dLong;
    return data;
  }
}

class Planta {
  int _dorms;
  int _metragem;
  int _preco;
  Null _vagas;

  Planta({int dorms, int metragem, int preco, Null vagas}) {
    this._dorms = dorms;
    this._metragem = metragem;
    this._preco = preco;
    this._vagas = vagas;
  }

  int get dorms => _dorms;
  set dorms(int dorms) => _dorms = dorms;
  int get metragem => _metragem;
  set metragem(int metragem) => _metragem = metragem;
  int get preco => _preco;
  set preco(int preco) => _preco = preco;
  Null get vagas => _vagas;
  set vagas(Null vagas) => _vagas = vagas;

  Planta.fromJson(Map<String, dynamic> json) {
    _dorms = json['dorms'];
    _metragem = json['metragem'];
    _preco = json['preco'];
    _vagas = json['vagas'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['dorms'] = this._dorms;
    data['metragem'] = this._metragem;
    data['preco'] = this._preco;
    data['vagas'] = this._vagas;
    return data;
  }
}