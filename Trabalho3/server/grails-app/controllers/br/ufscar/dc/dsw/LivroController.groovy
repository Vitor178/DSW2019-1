package br.ufscar.dc.dsw

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class LivroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    LivroController() {
        super(Livro)
    }
}