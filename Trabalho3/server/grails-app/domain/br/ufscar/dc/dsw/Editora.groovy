package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/editoras', readOnly = false, formats = ['json', 'xml'])
class Editora {
    static constraints = {
         nome blank: false
    }

    String nome
}
