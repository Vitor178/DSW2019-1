package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/sites', readOnly = false, formats = ['json', 'xml'])
class Site {

    static constraints = {
         email blank: false
         senha blank: false
         url blank: false
         nome blank: false
         telefone blank: false
         
         
    }

    String email
    String senha
    String url
    String nome
    String telefone
}
