class MyHero{
  var _nome;
  var _singularidade;
  var _urlImg;


  MyHero(this._nome, this._singularidade, this._urlImg);


  @override
  String toString() {
    return 'MyHero{_nome: $_nome, _singularidade: $_singularidade, _urlImg: $_urlImg}';
  }

  get singularidade => _singularidade;

  get nome => _nome;

  get image => _urlImg;
}