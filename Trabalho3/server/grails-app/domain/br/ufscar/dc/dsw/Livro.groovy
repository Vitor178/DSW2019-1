package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/livros', readOnly = false, formats = ['json', 'xml'])
class Livro {

    static constraints = {
         titulo blank: false
         autor blank: false
         ano min: 1950
         preco min: new Float(0.01)
         editora nullable: false
    }

    String titulo
    String autor
    int ano
    float preco
    Editora editora
}
