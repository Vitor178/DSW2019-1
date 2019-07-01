package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/promocoes', readOnly = false, formats = ['json', 'xml'])
class Promocao {

    static constraints = {
         preco min:        new Float(0.01)
         nome blank:       false
         diahorario blank: false
         url blank:        false
         cnpj blank:       false
    }

    float preco
    String nome
    Date diahorario
    String url
    String cnpj
    
}
